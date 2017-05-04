package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CustomerDao;
import dao.SequenceKodeDao;
@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Collection<Customer> getAllCustomer() throws Exception {
		String sql = "SELECT cust.*, stat.status as status_hut, stat1.status as status_cust "
					+"FROM customer cust " 
					+"INNER JOIN status stat "
					+"ON cust.status_hutang = stat.kode_status "
					+"INNER JOIN status stat1 "
					+"ON cust.status_customer = stat1.kode_status";
		return this.getJdbcTemplate().query(sql, new CustMapper());
	}
	
	@Override
	public Collection<Customer> getAktifCustomer() throws Exception {
		String sql = "SELECT cust.*, stat.status as status_hut, stat1.status as status_cust "
					+"FROM customer cust " 
					+"INNER JOIN status stat "
					+"ON cust.status_hutang = stat.kode_status "
					+"INNER JOIN status stat1 "
					+"ON cust.status_customer = stat1.kode_status "
					+"WHERE cust.status_customer=1";
		return this.getJdbcTemplate().query(sql, new CustMapper());
	}
	
	@Override
	public void delete(String kodeCustomer) throws Exception {
		String sql = "update customer set status_customer=2 where kode_customer=?";
		this.getJdbcTemplate().update(sql, new Object[]{kodeCustomer});
	}
	
	@Override
	public void insert(Customer customer) throws Exception {
		String sql = "insert into customer (kode_customer, nama_customer, alamat, status_customer, tgl_lahir, status_hutang, total_hutang) "
				   + "values(?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{customer.getKodeCustomer(), customer.getNamaCustomer(), customer.getAlamatCustomer()
								      ,customer.getStatusCustomer(),customer.getTglLahir(),customer.getStatusHutang(),customer.getTotalHutang()});
	}

	@Override
	public void update(Customer customer) throws Exception {
		String sql = "update customer set nama_customer=?, alamat=?,tgl_lahir=? where kode_customer=?";
		this.getJdbcTemplate().update(sql, new Object[]{customer.getNamaCustomer(), customer.getAlamatCustomer()
								      ,customer.getTglLahir(),customer.getKodeCustomer()});		
	}
	
	class CustMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
			Customer cust = new Customer();
			cust.setKodeCustomer(rs.getString("kode_customer"));
			cust.setNamaCustomer(rs.getString("nama_customer"));
			cust.setAlamatCustomer(rs.getString("alamat"));
			cust.setTglLahir(rs.getDate("tgl_lahir"));
			cust.setStatusCust(rs.getString("status_cust"));
			cust.setStatusHut(rs.getString("status_hut"));
			cust.setTotalHutang(rs.getInt("total_hutang"));
			return cust;
		}
		
	}
	
	class kodeCustMapper implements RowMapper<Customer>{
		@Override
		public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
			Customer cust = new Customer();
			cust.setKodeCustomer(rs.getString("kode_customer"));
			return cust;
		}
	}
}

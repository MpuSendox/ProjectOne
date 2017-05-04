package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import model.Penjualan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.PenjualanDao;
@Repository
public class PenjualanDaoImpl extends JdbcDaoSupport implements PenjualanDao {
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Collection<Penjualan> getAllPenjualan() throws Exception {
		String sql = "select * from penjualan order by kode_penjualan";
		return this.getJdbcTemplate().query(sql, new PenjMapper());
	}

	@Override
	public void insert(Penjualan penj) throws Exception {
		String sql = "insert into penjualan values(?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{penj.getKodePenjualan(), penj.getKodeCustomer(), penj.getKodeBarang(),
									  penj.getJumlahBarang(),penj.getTotalHarga(),penj.getTglPenjualan(),penj.getTotalBayar()});
	}

	@Override
	public void update(Penjualan penj) throws Exception {
		String sql = "update penjualan set kode_customer=?,kode_barang=?,jumlah_barang=?,tgl_penjualan=?,total_harga=?,total_bayar=? where kode_penjualan=?";
		this.getJdbcTemplate().update(sql, new Object[]{penj.getKodeCustomer(),penj.getKodeBarang(),penj.getJumlahBarang(),penj.getTglPenjualan(),
									  penj.getTotalHarga(),penj.getTotalBayar(),penj.getKodePenjualan()});
	}
	
	class PenjMapper implements RowMapper<Penjualan>{

		@Override
		public Penjualan mapRow(ResultSet rs, int rownum) throws SQLException {
			Penjualan pj = new Penjualan();
			pj.setKodePenjualan(rs.getString("kode_penjualan"));
			pj.setKodeCustomer(rs.getString("kode_customer"));
			pj.setKodeBarang(rs.getString("kode_barang"));
			pj.setJumlahBarang(rs.getInt("jumlah_barang"));
			pj.setTglPenjualan(rs.getDate("tgl_penjualan"));
			pj.setTotalHarga(rs.getInt("total_harga"));
			pj.setTotalBayar(rs.getInt("total_bayar"));
			return pj;
		}
		
	}

}

package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import model.Hutang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.HutangDao;
@Repository
public class HutangDaoImpl extends JdbcDaoSupport implements HutangDao{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Collection<Hutang> getAllHutang() throws Exception {
		String sql = "select * from hutang order by kode_hutang";
		return this.getJdbcTemplate().query(sql, new HutangMapper());
	}

	@Override
	public void insert(Hutang hutang) throws Exception {
		String sql = "insert into hutang values(?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{hutang.getKodeHutang(), hutang.getKodeCustomer(), 
				                      hutang.getJumlahHutang(), hutang.getTipeHutang(), hutang.getTglHutang()});
	}

	@Override
	public void update(Hutang hutang) throws Exception {
		String sql = "update hutang set kode_customer=?, jumlah_hutang=?, tipe_hutang=?, tgl_hutang=? where kode_hutang=?";
		this.getJdbcTemplate().update(sql, new Object[]{hutang.getKodeCustomer(), hutang.getJumlahHutang(), hutang.getTipeHutang(),
									  hutang.getTglHutang(), hutang.getKodeHutang()});
	}

	@Override
	public Hutang getHutang(String kodeHutang) throws Exception {
		String sql = "select * from hutang where kode_hutang=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[]{kodeHutang}, new HutangMapper());
	}
	
	class HutangMapper implements RowMapper<Hutang>{

		@Override
		public Hutang mapRow(ResultSet rs, int rownum) throws SQLException {
			Hutang ht = new Hutang();
			ht.setKodeHutang(rs.getString("kode_hutang"));
			ht.setKodeCustomer(rs.getString("kode_customer"));
			ht.setJumlahHutang(rs.getInt("jumlah_hutang"));
			ht.setTipeHutang(rs.getInt("tipe_hutang"));
			ht.setTglHutang(rs.getDate("tgl_hutang"));
			return ht;
		}

	}

}

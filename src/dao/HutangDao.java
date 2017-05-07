package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import model.Hutang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.HutangDao;
@Repository
public class HutangDao extends JdbcTemplate{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	public List<Hutang> getAllHutang() throws Exception {
		String sql = "select * from hutang order by kode_hutang";
		return this.query(sql, new HutangMapper());
	}

	public void insert(Hutang hutang) throws Exception {
		String sql = "insert into hutang values(?,?,?,?,?)";
		this.update(sql, new Object[]{hutang.getKodeHutang(), hutang.getKodeCustomer(), 
				                      hutang.getJumlahHutang(), hutang.getTipeHutang(), hutang.getTglHutang()});
	}

	public void update(Hutang hutang) throws Exception {
		String sql = "update hutang set kode_customer=?, jumlah_hutang=?, tipe_hutang=?, tgl_hutang=? where kode_hutang=?";
		this.update(sql, new Object[]{hutang.getKodeCustomer(), hutang.getJumlahHutang(), hutang.getTipeHutang(),
									  hutang.getTglHutang(), hutang.getKodeHutang()});
	}

	public Hutang getHutang(String kodeHutang) throws Exception {
		String sql = "select * from hutang where kode_hutang=?";
		return this.queryForObject(sql, new Object[]{kodeHutang}, new HutangMapper());
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

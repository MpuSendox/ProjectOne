package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import model.Barang;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.BarangDao;
@Repository
public class BarangDao {
	private JdbcTemplate jdbcTemplate;
	
	public BarangDao(){
		
	}
	
	public BarangDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
	
	public List<Barang> getAllBarang() throws Exception {
		String sql = "select * from barang order by kode_barang";
		return this.jdbcTemplate.query(sql, new BarangMapper());
	}

	public List<Barang> getStokBarang() throws Exception {
		String sql = "select * from barang where status_barang=5 order by kode_barang";
		return this.jdbcTemplate.query(sql, new BarangMapper());
	}
	
	public Barang getBarang(String kodeBarang) throws Exception {
		String sql = "select * from barang where kode_barang=?";
		return this.jdbcTemplate.queryForObject(sql, new Object[]{kodeBarang}, new BarangMapper());
	}

	public void insert(Barang barang) throws Exception {
		String sql = "insert into barang values (?,?,?,?)";
		this.jdbcTemplate.update(sql, new Object[]{barang.getKodeBarang(), barang.getNamaBarang(), barang.getHargaBarang(), barang.getStatusBarang()});
	}

	public void update(Barang barang) throws Exception {
		String sql = "update barang set nama_barang=?, status_barang=?, harga_barang=? where kode_barang=?";
		this.jdbcTemplate.update(sql, new Object[]{barang.getNamaBarang(), barang.getStatusBarang(), barang.getHargaBarang(), barang.getKodeBarang()});
	}

	public void delete(String kodeBarang) throws Exception {
		String sql = "delete from barang where kode_barang=?";
		this.jdbcTemplate.update(sql, new Object[]{kodeBarang});
	}
	
	class BarangMapper implements RowMapper<Barang>{
		@Override
		public Barang mapRow(ResultSet rs, int rownum) throws SQLException {
			Barang b = new Barang();
			b.setKodeBarang(rs.getString("kode_barang"));
			b.setNamaBarang(rs.getString("nama_barang"));
			b.setStatusBarang(rs.getInt("status_barang"));
			b.setHargaBarang(rs.getInt("harga_barang"));
			return b;
		}
	}
}

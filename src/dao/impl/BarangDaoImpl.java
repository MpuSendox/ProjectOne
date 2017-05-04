package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import model.Barang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.BarangDao;
@Repository
public class BarangDaoImpl extends JdbcDaoSupport implements BarangDao{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Collection<Barang> getAllBarang() throws Exception {
		String sql = "select * from barang order by kode_barang";
		return this.getJdbcTemplate().query(sql, new BarangMapper());
	}

	@Override
	public Collection<Barang> getStokBarang() throws Exception {
		String sql = "select * from barang where status_barang=5 order by kode_barang";
		return this.getJdbcTemplate().query(sql, new BarangMapper());
	}
	
	@Override
	public Barang getBarang(String kodeBarang) throws Exception {
		String sql = "select * from barang where kode_barang=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[]{kodeBarang}, new BarangMapper());
	}

	@Override
	public void insert(Barang barang) throws Exception {
		String sql = "insert into barang values (?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{barang.getKodeBarang(), barang.getNamaBarang(), barang.getHargaBarang(), barang.getStatusBarang()});
	}

	@Override
	public void update(Barang barang) throws Exception {
		String sql = "update barang set nama_barang=?, status_barang=?, harga_barang=? where kode_barang=?";
		this.getJdbcTemplate().update(sql, new Object[]{barang.getNamaBarang(), barang.getStatusBarang(), barang.getHargaBarang(), barang.getKodeBarang()});
	}

	@Override
	public void delete(String kodeBarang) throws Exception {
		String sql = "delete from barang where kode_barang=?";
		this.getJdbcTemplate().update(sql, new Object[]{kodeBarang});
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

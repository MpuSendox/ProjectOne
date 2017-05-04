package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import util.Status;
import dao.StatusDao;

@Repository
public class StatusDaoImpl extends JdbcDaoSupport implements StatusDao{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Collection<Status> getStatus(String deskripsi) throws Exception {
		String sql = "select * from status where deskripsi='"+deskripsi+"' order by kode_status";
		return this.getJdbcTemplate().query(sql, new StatusMapper());
	}
	
	class StatusMapper implements RowMapper<Status>{

		@Override
		public Status mapRow(ResultSet rs, int rownum) throws SQLException {
			Status st = new Status();
			st.setKodeStatus(rs.getInt("kode_status"));
			st.setStatus(rs.getString("status"));
			st.setDeskripsi(rs.getString("deskripsi"));
			return st;
		}
	}
}

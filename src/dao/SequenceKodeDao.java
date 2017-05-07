package dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.SequenceKodeDao;
@Repository
public class SequenceKodeDao extends JdbcTemplate{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	public Integer CustomerSequence() throws Exception {
		String sql = "select nextval('seq_kode_customer'::regclass)";
		return this.queryForInt(sql);
	}

}

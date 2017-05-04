package dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.SequenceKodeDao;
@Repository
public class SequenceKodeDaoImpl extends JdbcDaoSupport implements SequenceKodeDao{
	@Autowired
	private DataSource dSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dSource);
	}
	
	@Override
	public Integer CustomerSequence() throws Exception {
		String sql = "select nextval('seq_kode_customer'::regclass)";
		return this.getJdbcTemplate().queryForInt(sql);
	}

}

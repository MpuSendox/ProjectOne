package service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import util.ConfigPool;
import dao.BarangDao;
import model.Barang;

@Transactional
@Service
public class BarangService {
	private ConfigPool configPool = new ConfigPool();
	private DataSource dataSource;
	private BarangDao barangDao;
	
	public BarangService(){
		dataSource = configPool.getDataSource();
		barangDao = new BarangDao(dataSource);
	}

	public List<Barang> getAllBarang() throws Exception {
		return this.barangDao.getAllBarang();
	}

	public Barang getBarang(String kodeBarang) throws Exception {
		return this.barangDao.getBarang(kodeBarang);
	}

	public void insert(Barang barang) throws Exception {
		this.barangDao.insert(barang);
	}

	public void update(Barang barang) throws Exception {
		this.barangDao.update(barang);
	}

	public void delete(String kodeBarang) throws Exception {
		this.barangDao.delete(kodeBarang);
	}

	public List<Barang> getStokBarang() throws Exception {
		return this.barangDao.getStokBarang();
	}

}

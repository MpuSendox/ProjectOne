package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BarangDao;
import model.Barang;
import service.BarangService;

@Transactional
@Service
public class BarangServiceImpl implements BarangService {
	@Autowired private BarangDao barangDao;
	@Override
	public Collection<Barang> getAllBarang() throws Exception {
		return this.barangDao.getAllBarang();
	}

	@Override
	public Barang getBarang(String kodeBarang) throws Exception {
		return this.barangDao.getBarang(kodeBarang);
	}

	@Override
	public void insert(Barang barang) throws Exception {
		this.barangDao.insert(barang);
	}

	@Override
	public void update(Barang barang) throws Exception {
		this.barangDao.update(barang);
	}

	@Override
	public void delete(String kodeBarang) throws Exception {
		this.barangDao.delete(kodeBarang);
	}

	@Override
	public Collection<Barang> getStokBarang() throws Exception {
		return this.barangDao.getStokBarang();
	}

}

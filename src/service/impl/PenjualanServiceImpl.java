package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PenjualanDao;
import model.Penjualan;
import service.PenjualanService;

@Transactional
@Service
public class PenjualanServiceImpl implements PenjualanService{
	@Autowired private PenjualanDao penjDao;
	@Override
	public Collection<Penjualan> getAllPenjualan() throws Exception {
		return this.penjDao.getAllPenjualan();
	}

	@Override
	public void insert(Penjualan penj) throws Exception {
		this.penjDao.insert(penj);
	}

	@Override
	public void update(Penjualan penj) throws Exception {
		this.penjDao.update(penj);
	}

}

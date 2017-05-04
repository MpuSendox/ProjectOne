package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.HutangDao;
import model.Hutang;
import service.HutangService;

@Transactional
@Service
public class HutangServiceImpl implements HutangService{
	@Autowired private HutangDao hutangDao;
	@Override
	public Collection<Hutang> getAllHutang() throws Exception {
		return this.hutangDao.getAllHutang();
	}

	@Override
	public void insert(Hutang hutang) throws Exception {
		this.hutangDao.insert(hutang);
	}

	@Override
	public void update(Hutang hutang) throws Exception {
		this.hutangDao.update(hutang);
	}

	@Override
	public Hutang getHutang(String kodeHutang) throws Exception {
		return this.hutangDao.getHutang(kodeHutang);
	}

}

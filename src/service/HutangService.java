package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.HutangDao;
import model.Hutang;
import service.HutangService;

@Transactional
@Service
public class HutangService {
	private HutangDao hutangDao = new HutangDao();

	public List<Hutang> getAllHutang() throws Exception {
		return this.hutangDao.getAllHutang();
	}

	public void insert(Hutang hutang) throws Exception {
		this.hutangDao.insert(hutang);
	}

	public void update(Hutang hutang) throws Exception {
		this.hutangDao.update(hutang);
	}

	public Hutang getHutang(String kodeHutang) throws Exception {
		return this.hutangDao.getHutang(kodeHutang);
	}

}

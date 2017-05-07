package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PenjualanDao;
import model.Penjualan;
import service.PenjualanService;

@Transactional
@Service
public class PenjualanService {
	private PenjualanDao penjDao = new PenjualanDao();

	public List<Penjualan> getAllPenjualan() throws Exception {
		return this.penjDao.getAllPenjualan();
	}

	public void insert(Penjualan penj) throws Exception {
		this.penjDao.insert(penj);
	}

	public void update(Penjualan penj) throws Exception {
		this.penjDao.update(penj);
	}

}

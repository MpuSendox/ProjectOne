package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.StatusDao;
import service.StatusService;
import util.Status;

@Transactional
@Service
public class StatusService {
	private StatusDao statusDao = new StatusDao();
	
	public List<Status> getStatus(String deskripsi) throws Exception {
		return this.statusDao.getStatus(deskripsi);
	}

}

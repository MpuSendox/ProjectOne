package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.StatusDao;
import service.StatusService;
import util.Status;

@Transactional
@Service
public class StatusServiceImpl implements StatusService{
	@Autowired private StatusDao statusDao;
	
	@Override
	public Collection<Status> getStatus(String deskripsi) throws Exception {
		return this.statusDao.getStatus(deskripsi);
	}

}

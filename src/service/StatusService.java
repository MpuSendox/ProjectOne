package service;

import java.util.Collection;

import util.Status;

public interface StatusService {
	public Collection<Status> getStatus(String deskripsi) throws Exception;
}

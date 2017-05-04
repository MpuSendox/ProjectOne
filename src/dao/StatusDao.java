package dao;

import java.util.Collection;

import util.Status;

public interface StatusDao {
	public Collection<Status> getStatus(String deskripsi) throws Exception;
}

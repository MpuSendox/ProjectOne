package service;

import java.util.Collection;

import model.Penjualan;

public interface PenjualanService {
	public Collection<Penjualan> getAllPenjualan() throws Exception;
	public void insert(Penjualan penj) throws Exception;
	public void update(Penjualan penj) throws Exception;
}

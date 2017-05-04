package dao;

import java.util.Collection;

import model.Penjualan;

public interface PenjualanDao {
	public Collection<Penjualan> getAllPenjualan() throws Exception;
	public void insert(Penjualan penj) throws Exception;
	public void update(Penjualan penj) throws Exception;
}

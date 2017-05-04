package dao;

import java.util.Collection;

import model.Barang;

public interface BarangDao {
	public Collection<Barang> getAllBarang() throws Exception;
	public Collection<Barang> getStokBarang() throws Exception;
	public Barang getBarang(String kodeBarang) throws Exception;
	public void insert(Barang barang) throws Exception;
	public void update(Barang barang) throws Exception;
	public void delete(String kodeBarang) throws Exception;
}

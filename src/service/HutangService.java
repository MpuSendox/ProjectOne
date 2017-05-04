package service;

import java.util.Collection;

import model.Hutang;

public interface HutangService {
	public Collection<Hutang> getAllHutang() throws Exception;
	public void insert(Hutang hutang) throws Exception;
	public void update(Hutang hutang) throws Exception;
	public Hutang getHutang(String kodeHutang) throws Exception;
}

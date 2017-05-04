package model;

import java.util.Date;

public class Hutang {
	private String kodeHutang;
	private String kodeCustomer;
	private int jumlahHutang;
	private int tipeHutang;
	private Date tglHutang;
	
	public String getKodeHutang() {
		return kodeHutang;
	}
	public void setKodeHutang(String kodeHutang) {
		this.kodeHutang = kodeHutang;
	}
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public int getJumlahHutang() {
		return jumlahHutang;
	}
	public void setJumlahHutang(int jumlahHutang) {
		this.jumlahHutang = jumlahHutang;
	}
	public int getTipeHutang() {
		return tipeHutang;
	}
	public void setTipeHutang(int tipeHutang) {
		this.tipeHutang = tipeHutang;
	}
	public Date getTglHutang() {
		return tglHutang;
	}
	public void setTglHutang(Date tglHutang) {
		this.tglHutang = tglHutang;
	}
}

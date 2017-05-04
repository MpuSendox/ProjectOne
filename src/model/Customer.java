package model;

import java.util.Date;

public class Customer {
	private String kodeCustomer;
	private String namaCustomer;
	private String alamatCustomer;
	private Date tglLahir;
	private int statusCustomer;
	private String statusCust;
	private int statusHutang;
	private String statusHut;
	
	public String getStatusCust() {
		return statusCust;
	}
	public void setStatusCust(String statusCust) {
		this.statusCust = statusCust;
	}
	public String getStatusHut() {
		return statusHut;
	}
	public void setStatusHut(String statusHut) {
		this.statusHut = statusHut;
	}
	private int totalHutang;
	
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public String getNamaCustomer() {
		return namaCustomer;
	}
	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}
	public String getAlamatCustomer() {
		return alamatCustomer;
	}
	public void setAlamatCustomer(String alamatCustomer) {
		this.alamatCustomer = alamatCustomer;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}
	public int getStatusCustomer() {
		return statusCustomer;
	}
	public void setStatusCustomer(int statusCustomer) {
		this.statusCustomer = statusCustomer;
	}
	public int getStatusHutang() {
		return statusHutang;
	}
	public void setStatusHutang(int statusHutang) {
		this.statusHutang = statusHutang;
	}
	public int getTotalHutang() {
		return totalHutang;
	}
	public void setTotalHutang(int totalHutang) {
		this.totalHutang = totalHutang;
	}
}

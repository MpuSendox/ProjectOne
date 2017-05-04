package model;

import java.util.Date;

public class Penjualan {
	private String kodePenjualan;
	private String kodeCustomer;
	private String kodeBarang;
	private int jumlahBarang;
	private int totalHarga;
	private int totalBayar;
	private Date tglPenjualan;
	
	public String getKodePenjualan() {
		return kodePenjualan;
	}
	public void setKodePenjualan(String kodePenjualan) {
		this.kodePenjualan = kodePenjualan;
	}
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public int getJumlahBarang() {
		return jumlahBarang;
	}
	public void setJumlahBarang(int jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}
	public int getTotalHarga() {
		return totalHarga;
	}
	public void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}
	public int getTotalBayar() {
		return totalBayar;
	}
	public void setTotalBayar(int totalBayar) {
		this.totalBayar = totalBayar;
	}
	public Date getTglPenjualan() {
		return tglPenjualan;
	}
	public void setTglPenjualan(Date tglPenjualan) {
		this.tglPenjualan = tglPenjualan;
	}
}

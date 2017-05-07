package model;

import java.io.Serializable;

public class Barang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String kodeBarang;
	private String namaBarang;
	private int statusBarang;
	private int hargaBarang;
	
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public int getStatusBarang() {
		return statusBarang;
	}
	public void setStatusBarang(int statusBarang) {
		this.statusBarang = statusBarang;
	}
	public int getHargaBarang() {
		return hargaBarang;
	}
	public void setHargaBarang(int hargaBarang) {
		this.hargaBarang = hargaBarang;
	}
	
	public Barang(){
		
	}
	
	public Barang(String kodeBarang, String namaBarang, int statusBarang,
			int hargaBarang) {
		super();
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.statusBarang = statusBarang;
		this.hargaBarang = hargaBarang;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hargaBarang;
		result = prime * result
				+ ((kodeBarang == null) ? 0 : kodeBarang.hashCode());
		result = prime * result
				+ ((namaBarang == null) ? 0 : namaBarang.hashCode());
		result = prime * result + statusBarang;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barang other = (Barang) obj;
		if (hargaBarang != other.hargaBarang)
			return false;
		if (kodeBarang == null) {
			if (other.kodeBarang != null)
				return false;
		} else if (!kodeBarang.equals(other.kodeBarang))
			return false;
		if (namaBarang == null) {
			if (other.namaBarang != null)
				return false;
		} else if (!namaBarang.equals(other.namaBarang))
			return false;
		if (statusBarang != other.statusBarang)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Barang [kodeBarang=" + kodeBarang + ", namaBarang="
				+ namaBarang + ", statusBarang=" + statusBarang
				+ ", hargaBarang=" + hargaBarang + "]";
	}
}

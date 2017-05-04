package managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.BarangService;
import model.Barang;

@ManagedBean
@ViewScoped
@Component
public class BarangMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Barang> barangList;
	private Collection<Barang> barangStok;
	private Barang barang = new Barang();
	@Autowired private BarangService barangService;
	private String act;
	private String ro;
	
	public Collection<Barang> getBarangList() {
		try {
			this.barangList = this.barangService.getAllBarang();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.barangList;
	}
	
	public Collection<Barang> getBarangStok() {
		try {
			this.barangStok = this.barangService.getStokBarang();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.barangStok;
	}
	
	public void deleteBarang(){
		try {
			this.barangService.delete(this.barang.getKodeBarang());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modeInsert(){
		this.act = "insert";
		this.ro = "false";
		this.barang.setKodeBarang(null);
		this.barang.setNamaBarang(null);
		this.barang.setStatusBarang(0);
		this.barang.setHargaBarang(0);
	}
	
	public void modeEdit(){
		this.act = "edit";
		this.ro = "true";
	}
	
	public void manipBarang(){
		try {
			if (this.act.contains("insert")){
				this.barangService.insert(barang);
			} else if (this.act.contains("edit")){
				this.barangService.update(barang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBarangList(Collection<Barang> barangList) {
		this.barangList = barangList;
	}
	public Barang getBarang() {
		return barang;
	}
	public void setBarang(Barang barang) {
		this.barang = barang;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getRo() {
		return ro;
	}
	public void setRo(String ro) {
		this.ro = ro;
	}

	public void setBarangStok(Collection<Barang> barangStok) {
		this.barangStok = barangStok;
	}

}

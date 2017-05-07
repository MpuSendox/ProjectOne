package managed.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import model.Barang;
import model.Penjualan;
import service.BarangService;
import service.PenjualanService;

@ManagedBean
@ViewScoped
@Component
public class PenjualanMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Penjualan> penjList;
	private Penjualan penj = new Penjualan();
	private PenjualanService penjService;
	private BarangService barangService;
	private String act;
	private String ro;
	private Date dateNow = new Date();
	
	public List<Penjualan> getPenjList() {
		try {
			this.penjList = this.penjService.getAllPenjualan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.penjList;
	}
	
	public void modeInsert(){
		this.act = "insert";
		this.ro = "false";
		this.penj.setKodePenjualan(null);
		this.penj.setKodeCustomer(null);
		this.penj.setKodeBarang(null);
		this.penj.setJumlahBarang(0);
		this.penj.setTglPenjualan(null);
		this.penj.setTotalHarga(0);
		this.penj.setTotalBayar(0);
	}
	
	public void modeEdit(){
		this.act = "edit";
		this.ro = "true";
	}
	
	public void manipJual(){
		try {
			if (this.act.contains("insert")){
				this.penjService.insert(this.penj);
			} else if (this.act.contains("edit")){
				this.penjService.update(this.penj);
			}
			int hasil;
			FacesContext context = FacesContext.getCurrentInstance();
			if (this.penj.getTotalBayar()>this.penj.getTotalHarga()){
				hasil = this.penj.getTotalBayar() - this.penj.getTotalHarga();
				context.addMessage(null, new FacesMessage("Uang Kembali",  "Kembalian: " + hasil) );
			} else if (this.penj.getTotalBayar()<this.penj.getTotalHarga()){
				hasil = this.penj.getTotalHarga() - this.penj.getTotalBayar();
				context.addMessage(null, new FacesMessage("Hutang",  "Kurang: " + hasil) );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}
	
	public void submitMessage(){
		int hasil;
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.penj.getTotalBayar()>this.penj.getTotalHarga()){
			hasil = this.penj.getTotalBayar() - this.penj.getTotalHarga();
			context.addMessage(null, new FacesMessage("Uang Kembali",  "Kembalian: " + hasil) );
		} else if (this.penj.getTotalBayar()<this.penj.getTotalHarga()){
			hasil = this.penj.getTotalHarga() - this.penj.getTotalBayar();
			context.addMessage(null, new FacesMessage("Hutang",  "Kurang: " + hasil) );
		}
	}
	
	public void totalHarga(){
		Barang brg = new Barang();
		try {
			brg = this.barangService.getBarang(this.penj.getKodeBarang());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.penj.setTotalHarga(brg.getHargaBarang()*this.penj.getJumlahBarang());
	}
	
	public void setPenjList(List<Penjualan> penjList) {
		this.penjList = penjList;
	}
	public Penjualan getPenj() {
		return penj;
	}
	public void setPenj(Penjualan penj) {
		this.penj = penj;
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

	public Date getDateNow() {
		return dateNow;
	}

	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}

}

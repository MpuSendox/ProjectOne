package managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

@ManagedBean
@ViewScoped
public class Navigation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String urlPage = "/home.xhtml";
	
	/* Navigasi */
	public void home(){
		this.urlPage = "/home.xhtml";
	}
	
	public void listCustomer(){
		this.urlPage = "/pages/customer/list.xhtml";
	}
	
	public void formCustomer(){
		this.urlPage = "/pages/customer/form.xhtml";
	}
	
	public void listBarang(){
		this.urlPage = "/pages/barang/list.xhtml";
	}
	
	public void formBarang(){
		this.urlPage = "/pages/barang/form.xhtml";
	}
	
	public void listPenjualan(){
		this.urlPage = "/pages/penjualan/list.xhtml";
	}
	
	public void formPenjualan(){
		this.urlPage = "/pages/penjualan/form.xhtml";
	}
	/* Navigasi */
	
	public String getUrlPage() {
		return urlPage;
	}
	public void setUrlPage(String urlPage) {
		this.urlPage = urlPage;
	}

}

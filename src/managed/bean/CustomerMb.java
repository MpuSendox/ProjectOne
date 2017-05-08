package managed.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Customer;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.CustomerService;
import service.SequenceKodeService;

@ManagedBean
@ViewScoped
public class CustomerMb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> custList;
	private List<Customer> custAktif;
	private CustomerService custService;
	private SequenceKodeService sks;
	private String act;
	private String dis;
	private Customer customer = new Customer();
	private Customer customerEditRow = new Customer();
	private Date dNow = new Date();
	private int umur;
		
	@PostConstruct
	public void init(){
		dataCustomerList();
	}
	
	public List<Customer> getCustList() {
		try {
			this.custList = this.custService.getAllCustomer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.custList;
	}
	
	public List<Customer> getCustAktif() {
		return this.custAktif;
	}
	
	public void dataCustomerList(){
		try {
			this.custAktif = this.custService.getAktifCustomer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void umurTotal(){
		int tahun = this.dNow.getYear() - this.customer.getTglLahir().getYear();
		int bulan = this.dNow.getMonth() - this.customer.getTglLahir().getMonth();
		int hari = this.dNow.getDay() - this.customer.getTglLahir().getDay();
	
		if(bulan < 0){
			tahun--;
			bulan +=12;
		}/*
		if(hari < 0){
			bulan--;
			hari += this.dNow.getDate();
		}*/
		
		this.umur = tahun;
	}
	
	public void modeDelete(){
		this.act = "delete";
		this.dis = "true";
	}
	
	public void modeInsert(){
		this.act = "insert";
		this.dis = "false";
		try {
			this.customer = new Customer();
			this.customer.setKodeCustomer(this.sks.CustomerSequence());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modeEdit(){
		this.act = "edit";
		this.dis = "false";
	}
	
	public void manipCustomer(){
		try {
			if (this.act.contains("insert")){
				this.customer.setKodeCustomer(this.sks.CustomerSequence());
				this.customer.setStatusCustomer(1);
				this.customer.setStatusHutang(6);
				this.customer.setTotalHutang(0);
				this.custService.insert(this.customer);
			} else if (this.act.contains("edit")){
				this.custService.update(this.customer);
			} else if (this.act.contains("delete")){
				this.custService.delete(this.customer.getKodeCustomer());
			}
			dataCustomerList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editRow(RowEditEvent event){
		try {
			this.customerEditRow = (Customer) event.getObject();
			this.custService.update(this.customerEditRow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCustList(List<Customer> custList) {
		this.custList = custList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public Date getdNow() {
		return dNow;
	}

	public void setdNow(Date dNow) {
		this.dNow = dNow;
	}

	public void setCustAktif(List<Customer> custAktif) {
		this.custAktif = custAktif;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}
	
	public int getUmur() {
		return this.umur;
	}

	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public Customer getCustomerEditRow() {
		return customerEditRow;
	}

	public void setCustomerEditRow(Customer customerEditRow) {
		this.customerEditRow = customerEditRow;
	}
}

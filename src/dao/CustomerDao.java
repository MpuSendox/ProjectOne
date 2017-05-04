package dao;

import java.util.Collection;

import model.Customer;

public interface CustomerDao {
	public Collection<Customer> getAllCustomer() throws Exception;
	public Collection<Customer> getAktifCustomer() throws Exception;
	public void delete(String kodeCustomer) throws Exception;
	public void insert(Customer customer) throws Exception;
	public void update(Customer customer) throws Exception;
}

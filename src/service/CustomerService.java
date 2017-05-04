package service;

import java.util.Collection;

import model.Customer;

public interface CustomerService {
	public Collection<Customer> getAllCustomer() throws Exception;
	public Collection<Customer> getAktifCustomer() throws Exception;
	public void delete(String kodeCustomer) throws Exception;
	public void insert(Customer customer) throws Exception;
	public void update(Customer customer) throws Exception;
}

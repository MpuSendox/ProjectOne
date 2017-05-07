package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;

@Transactional
@Service
public class CustomerService{
	private CustomerDao custDao = new CustomerDao();

	public List<Customer> getAllCustomer() throws Exception {
		return this.custDao.getAllCustomer();
	}

	public void delete(String kodeCustomer) throws Exception {
		this.custDao.delete(kodeCustomer);
	}

	public void insert(Customer customer) throws Exception {
		this.custDao.insert(customer);
	}

	public void update(Customer customer) throws Exception {
		this.custDao.update(customer);
	}

	public List<Customer> getAktifCustomer() throws Exception {
		return this.custDao.getAktifCustomer();
	}
}

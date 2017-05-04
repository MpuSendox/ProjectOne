package service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import dao.SequenceKodeDao;
import model.Customer;
import service.CustomerService;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired private CustomerDao custDao;
	@Override
	public Collection<Customer> getAllCustomer() throws Exception {
		return this.custDao.getAllCustomer();
	}
	@Override
	public void delete(String kodeCustomer) throws Exception {
		this.custDao.delete(kodeCustomer);
	}
	@Override
	public void insert(Customer customer) throws Exception {
		this.custDao.insert(customer);
	}
	@Override
	public void update(Customer customer) throws Exception {
		this.custDao.update(customer);
	}
	@Override
	public Collection<Customer> getAktifCustomer() throws Exception {
		return this.custDao.getAktifCustomer();
	}
}

package com.app.hostel.service;

import java.util.List;

import com.app.hostel.entity.CustomerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hostel.dao.CustomerDao;
import com.app.hostel.entity.Customer;


@Service("customerService")
public class CustomerService{

	@Autowired
	private CustomerDao customerDaoImpl;
	
	public void createCustomer(Customer customer) {
		 
		customerDaoImpl.createCustomer(customer);
	}

	 
	public Customer getCustomer(Integer id) {
		return customerDaoImpl.getCustomer(id);
	}

	 
	public List<Customer> getCustomers() {
		 
		return customerDaoImpl.getCustomers();
	}

	 
	public void updateCustomer(Customer customer) {
		 
		customerDaoImpl.updateCustomer(customer);
	}

	 
	public void deleteCustomer(Integer id) {
		 
		customerDaoImpl.deleteCustomer(id);
	}


	public void buyProduct(Integer id, Integer quantity,Integer customer_id) {
		
		customerDaoImpl.buyProduct(id,quantity,customer_id);
	}

	public void buyItinerary(Integer id, Integer quantity,Integer customer_id) {

		customerDaoImpl.buyItinerary(id,quantity,customer_id);
	}


	public List<CustomerTransaction> getPaymentAmount(Integer customerId) {
		return customerDaoImpl.getPaymentAmount(customerId);
	}

	public String createCustomerTransaction(CustomerTransaction customerTransaction) {
		return customerDaoImpl.createCustomerTransaction(customerTransaction);
	}
}

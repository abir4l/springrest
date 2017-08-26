package com.app.hostel.service;

import java.util.List;

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


	public void buyProduct(Integer id, Integer quantity) {
		
		customerDaoImpl.buyProduct(id,quantity);
	}
}
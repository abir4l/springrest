package com.app.hostel.dao;

import java.util.List;


import com.app.hostel.entity.Customer;
import com.app.hostel.entity.CustomerTransaction;


public interface CustomerDao {

	public void createCustomer(Customer customer);

	public Customer getCustomer(Integer id);
	
	public List<Customer> getCustomers();
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer id);

	public void buyProduct(Integer id, Integer quantity,Integer customer_id);
	public void buyItinerary(Integer id, Integer quantity,Integer customer_id);
	public List<CustomerTransaction> getPaymentAmount(Integer customerId);
	public String createCustomerTransaction(CustomerTransaction customerTransaction);

}

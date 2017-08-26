package com.app.hostel.controller;

import java.util.List;

import com.app.hostel.dto.CustomerDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hostel.entity.Customer;
import com.app.hostel.service.CustomerService;

@RestController

@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private Mapper mapper;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
		
		customerService.createCustomer(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@RequestMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") Integer id) {
		Customer customer = customerService.getCustomer(id);
		CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
		return new ResponseEntity<>(customerDTO,HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.PUT)
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		
		customerService.updateCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id) {
		
		customerService.deleteCustomer(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/buyproduct/{product_id}/{quantity}")
	public ResponseEntity<String> buyProduct(@PathVariable("product_id") Integer id, @PathVariable("quantity")Integer quantity){
	
		customerService.buyProduct(id,quantity);
		return new ResponseEntity<>("Bought Successfully", HttpStatus.OK);
	}
}
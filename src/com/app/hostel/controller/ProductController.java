package com.app.hostel.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hostel.entity.Product;
import com.app.hostel.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		productService.createProduct(product);
		return new ResponseEntity<>(product,HttpStatus.OK);

	}

	@RequestMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
		

		return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Set<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.PUT)
		public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		
		productService.updateProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
		
		productService.deleteProduct(id);
		return new  ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}
}

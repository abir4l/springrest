package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.Product;


public interface ProductDao {

	public void createProduct(Product product);

	public Product getProduct(Integer id);
	
	public List<Product> getProducts();
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Integer id);
}

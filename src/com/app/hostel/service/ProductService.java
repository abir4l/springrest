package com.app.hostel.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hostel.dao.ProductDao;
import com.app.hostel.dao.StockDao;
import com.app.hostel.dao.StockDaoImpl;
import com.app.hostel.entity.Product;
import com.app.hostel.entity.Stock;


@Service("productService")
public class ProductService{

	@Autowired
	private ProductDao productDaoImpl;

	@Autowired
	private StockDao stockDaoImpl;

	 
	public void createProduct(Product product) {
		 
		productDaoImpl.createProduct(product);
		
		
		
	}

	 
	public Product getProduct(Integer id) {
		 
		return productDaoImpl.getProduct(id);
	}

	 
	public Set<Product> getProducts() {
		 
		return productDaoImpl.getProducts();
	}

	 
	public void updateProduct(Product product) {
		 
		productDaoImpl.updateProduct(product);
	}

	 
	public void deleteProduct(Integer id) {
		 
		productDaoImpl.deleteProduct(id);
	}
}

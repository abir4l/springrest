package com.app.hostel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hostel.entity.Product;
import com.app.hostel.entity.Stock;
import com.app.hostel.entity.User;

@Component
public class ProductDaoImpl extends BaseDao implements ProductDao {


	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createProduct(Product product) {

		Session session = getSession(sessionFactory);
		session.persist(product);
		
		//Setting up the stock for new product
		Stock stock = new Stock();
		stock.setProduct(product);
		stock.setInitialStock(product.getQuantity());
		stock.setFinalStock(product.getQuantity());
		stock.setSpent_quantity(0);
		stock.setRemarks("Product Added"); 

		//saving stock
		session.persist(stock);

		closeSession(session);

	}

	@Override
	public Product getProduct(Integer id) {

		Session session = getSession(sessionFactory);
		Product product = (Product) session.createCriteria(Product.class)
				.add(Restrictions.eq("deleted",false))
				.add(Restrictions.eq("id",id));

		closeSession(session);
		return product;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {

		Session session = getSession(sessionFactory);
		List<Product> products = session.createCriteria(Product.class)
				.add(Restrictions.eq("deleted",false))
				.list();
		closeSession(session);
		return products;

	}

	@Override
	public void updateProduct(Product product) {

		Session session = getSession(sessionFactory);
		
		//Getting product's initial quantity
		Product productDetail = (Product) session.get(Product.class,product.getId());
		closeSession(session);


		//Setting up the stock variable
		Stock stock = new Stock();
		stock.setProduct(product);
		stock.setInitialStock(productDetail.getQuantity());
		stock.setFinalStock(product.getQuantity());
		stock.setRemarks(product.getRemarks());
		
		//persisting stock
		session = getSession(sessionFactory);
		session.persist(stock);

		session.update(product);
		closeSession(session);

	}

	@Override
	public void deleteProduct(Integer id) {

		Session session = getSession(sessionFactory);

		// Setting up the Product to delete
		//Product product = new Product();
		//product.setId(id);

		Product product = (Product) session.get(Product.class,id);
		product.setDeleted(true);
		
		session.update(product);//TODO: Need to change code for soft Delete

		closeSession(session);
	}

}

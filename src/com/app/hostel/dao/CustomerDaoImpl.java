package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.CustomerProducts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hostel.entity.Customer;
import com.app.hostel.entity.Product;

@Component
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createCustomer(Customer customer) {

		Session session = getSession(sessionFactory);
		if(customer.getParentId() != null)
		customer.setParent((Customer)session.get(Customer.class,customer.getParentId()));
		session.persist(customer);
		closeSession(session);

	}

	@Override
	public Customer getCustomer(Integer id) {

		Session session = getSession(sessionFactory);
		Customer customer = (Customer) session.get(Customer.class, id);
		if(customer.getParent() != null)
			customer.setParentId(customer.getParent().getId());
		closeSession(session);
		return customer;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {

		Session session = getSession(sessionFactory);
		List<Customer> customers = session.createCriteria(Customer.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		for (Customer customer:customers) {
			if(customer.getParent() != null)
				customer.setParentId(customer.getParent().getId());
		}
		session.clear();
		closeSession(session);
		return customers;
	}

	@Override
	public void updateCustomer(Customer customer) {

		Session session = getSession(sessionFactory);
		session.update(customer);
		closeSession(session);

	}

	@Override
	public void deleteCustomer(Integer id) {

		Session session = getSession(sessionFactory);
		// Setting up the Customer to delete
		Customer customer = new Customer();
		customer.setId(id);
		session.delete(customer);// Need to change code for soft Delete
		closeSession(session);
	}

	@Override
	public void buyProduct(Integer id,Integer quantity) {
		
		Session session = getSession(sessionFactory);
		Customer customer = (Customer) session.get(Customer.class, 1);// need to change to principle
		Product product = (Product) session.get(Product.class, id);
		CustomerProducts customerProducts  = new CustomerProducts();
		customerProducts.setQuantity(quantity);
		customerProducts.setCustomer(customer);
		customerProducts.setProduct(product);
		session.save(customerProducts);
		closeSession(session);

	}

}

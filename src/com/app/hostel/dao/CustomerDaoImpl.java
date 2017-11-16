package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		if(customer.getParentId() != null && customer.getParentId() != 0){

			Customer parentCustomer= (Customer) session.get(Customer.class, customer.getParentId());
			customer.setParent(parentCustomer);
		}

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

		if(customer.getParentId() != null && customer.getParentId() != 0){

			Customer parentCustomer= (Customer) session.get(Customer.class, customer.getParentId());
			customer.setParent(parentCustomer);
		}


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
	public void buyProduct(Integer id,Integer quantity,Integer customer_id) {
		
		Session session = getSession(sessionFactory);
		Customer customer = (Customer) session.get(Customer.class, customer_id);
		Product product = (Product) session.get(Product.class, id);
		CustomerProducts customerProducts  = new CustomerProducts();
		customerProducts.setQuantity(quantity);
		customerProducts.setCustomer(customer);
		customerProducts.setProduct(product);
		session.save(customerProducts);
		closeSession(session);

	}

	@Override
	public void buyItinerary(Integer id, Integer quantity, Integer customer_id) {
		Session session = getSession(sessionFactory);
		Customer customer = (Customer) session.get(Customer.class, customer_id);
		Itinerary itinerary = (Itinerary)session.get(Itinerary.class,id);
		CustomerItinerary customerItinerary = new CustomerItinerary();
		customerItinerary.setQuantity(quantity);
		customerItinerary.setItinerary(itinerary);
		customerItinerary.setCustomer(customer);
		session.save(customerItinerary);
		closeSession(session);


	}


}

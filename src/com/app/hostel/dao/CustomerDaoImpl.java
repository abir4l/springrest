package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.*;
import org.hibernate.Query;
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

		Stock stock = new Stock();
		stock.setProduct(product);
		stock.setInitialStock(product.getQuantity());

		product.setQuantity(product.getQuantity()-customerProducts.getQuantity());

		stock.setFinalStock(product.getQuantity());
		stock.setSpent_quantity(customerProducts.getQuantity());
		stock.setRemarks("Customer Purchase");




		customerProducts.setCustomer(customer);
		customerProducts.setProduct(product);
		session.save(customerProducts);
		session.save(stock);
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

	@Override
	public List<CustomerTransaction> getPaymentAmount(Integer customerId) {
		Session session = getSession(sessionFactory);
		String sql = "Select * from tbl_customer_transaction where customer_id=:customer_id";
		Query query = session.createSQLQuery(sql).addEntity(CustomerTransaction.class)
				.setParameter("customer_id",customerId);
		List <CustomerTransaction> amount = query.list();
		return amount;

	}

	@Override
	public String createCustomerTransaction(CustomerTransaction customerTransaction) {
		Session session = getSession(sessionFactory);
		session.save(customerTransaction);
		closeSession(session);

		return "Transaction created";
	}


}

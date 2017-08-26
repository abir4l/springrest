package com.app.hostel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hostel.entity.Stock;
@Component
public class StockDaoImpl extends BaseDao implements StockDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void createStock(Stock stock) {

		Session session = getSession(sessionFactory);
		session.persist(stock);
		closeSession(session);


	}

	@Override
	public Stock getStock(Integer id) {

		Session session = getSession(sessionFactory);
		Stock stock = (Stock) session.get(Stock.class, id);
		closeSession(session);
		return stock;


	}

	@Override
	public List<Stock> getStocks() {

		Session session = getSession(sessionFactory);
		List<Stock> stocks = session.createCriteria(Stock.class).list();
		closeSession(session);
		return stocks;
	}

	@Override
	public void updateStock(Stock stock) {

		Session session = getSession(sessionFactory);
		session.update(stock);
		closeSession(session);


	}

	@Override
	public void deleteStock(Integer id) {

		Session session = getSession(sessionFactory);

		// Setting up the user to delete
		Stock stock = new Stock();
		stock.setId(id);
		session.delete(stock);
		closeSession(session);
	}

}

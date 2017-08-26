package com.app.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hostel.dao.StockDao;
import com.app.hostel.entity.Stock;


@Service("stockService")
public class StockService{


	@Autowired
	private StockDao stockDaoImpl;

	 
	public void createStock(Stock stock) {
		 
		stockDaoImpl.createStock(stock);

	}


	 
	public Stock getStock(Integer id) {
		 
		return stockDaoImpl.getStock(id);
	}

	 
	public List<Stock> getStocks() {
		 
		return stockDaoImpl.getStocks();
	}

	 
	public void updateStock(Stock stock) {
		 
		stockDaoImpl.updateStock(stock);
	}

	 
	public void deleteStock(Integer id) {
		 
		stockDaoImpl.deleteStock(id);
	}
}

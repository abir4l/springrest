package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.Stock;


public interface StockDao {

	public void createStock(Stock stock);

	public Stock getStock(Integer id);
	
	public List<Stock> getStocks();
	
	public void updateStock(Stock stock);
	
	public void deleteStock(Integer id);
}

package com.app.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hostel.entity.Stock;
import com.app.hostel.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	
	@RequestMapping(method = RequestMethod.POST)
	public void addStock(@RequestBody Stock stock) {
		
		stockService.createStock(stock);

	}

	@RequestMapping("/{id}")
	public Stock getStock(@PathVariable("id") Integer id) {
		
		return stockService.getStock(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getAllStocks() {
		return new ResponseEntity<>(stockService.getStocks(), HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.PUT)
		public void updateStock( @RequestBody Stock stock) {
		
		stockService.updateStock(stock);
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public void deleteStock(@PathVariable("id") Integer id) {
		
		stockService.deleteStock(id);
	}
}

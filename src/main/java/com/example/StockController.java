package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.StockNotFoundException;
import com.example.exceptions.StockNotSavedException;

@RestController
public class StockController {

	@Autowired
	private StockRepository sr;
	
	private Logger logger = Logger.getLogger(StockController.class);
	public StockController() {
		// TODO Auto-generated constructor stub
	}
	
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping(value="/stock")
	public Stock stock(@RequestParam(value="ticker") String ticker, 
			@RequestParam(value="price") Double price){
		Stock s = new Stock(ticker, price);
		logger.info("Inserting stock: " + s);

		Stock savedStock = sr.save(s);
		if(savedStock == null){
			String error = s + " not saved!";
			logger.error(error);
			throw new StockNotSavedException(error);
		}
		return savedStock;
	}
	
	@ResponseStatus(value=HttpStatus.CREATED)
	@GetMapping(value="/stock")
	public Stock stock(@RequestParam(value="ticker") String ticker){
		Stock s = sr.findOne(ticker);
		if(s == null){
			String error = ticker + " not found!";
			logger.error(error);
			throw new StockNotFoundException(error);
		}
		logger.info("Found ticker: " + s);
		return s;
	}

}

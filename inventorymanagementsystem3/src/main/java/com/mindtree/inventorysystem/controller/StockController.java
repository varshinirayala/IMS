package com.mindtree.inventorysystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
	@Autowired
	private StockService stockService;

	@PostMapping("/addStock")
	public ResponseEntity<?> addStock(@RequestBody LaptopStock stock) {
		log.info("calling addStock method from StockController");
		LaptopStock savedStock = stockService.addStock(stock);
		return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
	}

	@GetMapping("/getAllStocks")
	public ResponseEntity<?> getAllStocks() {
		log.info("calling getAllStocks method from StockController");
		List<LaptopStock> stocks = stockService.getAllStocks();
		stocks = stocks.stream().sorted(LaptopStock.comparator).collect(Collectors.toList());
		return new ResponseEntity<>(stocks, HttpStatus.OK);
	}

	@GetMapping("/getStockByName/{name}")
	public ResponseEntity<?> getStockByName(@PathVariable(value = "name") String stockName)
			throws StockNotFoundException {
		log.info("calling getStockByName method from StockController");
		LaptopStock stock = stockService.getStockByName(stockName);
		log.info("Got stock with name " + stockName);
		return new ResponseEntity<>(stock, HttpStatus.OK);
	}

}

package com.mindtree.inventorysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.repository.StockRepository;
import com.mindtree.inventorysystem.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
	@Autowired
	private StockRepository stockRepository;

	@Override
	public LaptopStock addStock(LaptopStock stock) {
		log.info("calling addStock method from StockServiceImpl");
		if (stock.getStockName().equals("") || stock.getAvailableQuantity() < 0 || stock.getPrice() < 0) {
			return null;
		} else {
			Optional<LaptopStock> stockByName = stockRepository.findByStockName(stock.getStockName());
			if (stockByName.isEmpty()) {
				return stockRepository.save(stock);
			}
		}
		return null;
	}

	@Override
	public List<LaptopStock> getAllStocks() {
		log.info("calling getAllStocks method from StockServiceImpl");
		return stockRepository.findAll();
	}

	@Override
	public LaptopStock getStockByName(String stockName) throws StockNotFoundException {
		log.info("calling getStockByName method from StockServiceImpl");
		LaptopStock stockByName = stockRepository.findByStockName(stockName)
				.orElseThrow(() -> new StockNotFoundException("No Stock found for this name " + stockName));
		return stockByName;
	}

}

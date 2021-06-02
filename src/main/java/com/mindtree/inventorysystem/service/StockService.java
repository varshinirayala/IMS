package com.mindtree.inventorysystem.service;

import java.util.List;

import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.model.LaptopStock;

public interface StockService {

	LaptopStock addStock(LaptopStock stock);

	List<LaptopStock> getAllStocks();

	LaptopStock getStockByName(String stockName) throws StockNotFoundException;

}

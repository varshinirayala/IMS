package com.mindtree.inventorysystem.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.controller.StockController;
import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.service.StockService;

@SpringBootTest
public class TestStockController {
	@Mock
	StockService stockService;
	@InjectMocks
	StockController stockController;

	@Test
	public void testAddStock() {
		LaptopStock stock = new LaptopStock();
		stock.setStockId(1);
		stock.setStockName("lenovo");
		stock.setAvailableQuantity(20);
		stock.setPrice(40000);
		when(stockService.addStock(stock)).thenReturn(stock);
		assertEquals(stock, stockController.addStock(stock).getBody());
	}

	@Test
	public void testGetAllStocks() {
		List<LaptopStock> stocks = new ArrayList<>();
		stocks.add(new LaptopStock(1, "lenovo", 40000, 20));
		stocks.add(new LaptopStock(2, "dell", 35000, 15));
		stocks.add(new LaptopStock(3, "hp", 35000, 15));
		when(stockService.getAllStocks()).thenReturn(stocks);
		stocks = stocks.stream().sorted(LaptopStock.comparator).collect(Collectors.toList());
		assertEquals(stocks, stockController.getAllStocks().getBody());
	}

	@Test
	public void testGetStockByName() throws StockNotFoundException {
		LaptopStock stock = new LaptopStock("lenovo");
		when(stockService.getStockByName("lenovo")).thenReturn(stock);
		assertEquals(stock, stockController.getStockByName("lenovo").getBody());
	}
}

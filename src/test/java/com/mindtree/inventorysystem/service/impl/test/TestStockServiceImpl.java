package com.mindtree.inventorysystem.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.repository.StockRepository;
import com.mindtree.inventorysystem.service.impl.StockServiceImpl;

@SpringBootTest
public class TestStockServiceImpl {
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl stockServiceImpl;

	@Test
	public void testAddStock() {
		LaptopStock stock = new LaptopStock(1, "lenovo", 40000, 20);
		Optional<LaptopStock> stockByName = Optional.of(new LaptopStock(1, "lenovo", 40000, 20));
		when(stockRepository.findByStockName("lenovo")).thenReturn(stockByName);
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(null, stockServiceImpl.addStock(stock));
	}

	@Test
	public void testAddStockCase2() {
		LaptopStock stock = new LaptopStock(1, "", 0, 0);
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(null, stockServiceImpl.addStock(stock));
	}

	@Test
	public void testAddStockCase3() {
		LaptopStock stock = new LaptopStock(1, "lenovo", 40000, 20);
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(stock, stockServiceImpl.addStock(stock));
	}

	@Test
	public void testGetAllStocks() {
		List<LaptopStock> stocks = new ArrayList<>();
		stocks.add(new LaptopStock(1, "lenovo", 40000, 20));
		stocks.add(new LaptopStock(2, "dell", 35000, 15));
		stocks.add(new LaptopStock(3, "hp", 35000, 15));
		when(stockRepository.findAll()).thenReturn(stocks);
		assertEquals(stocks, stockServiceImpl.getAllStocks());
	}

	@Test
	public void testGetStockByName() throws StockNotFoundException {
		Optional<LaptopStock> stock = Optional.of(new LaptopStock("lenovo"));
		when(stockRepository.findByStockName("lenovo")).thenReturn(stock);
		assertEquals(stock.get(), stockServiceImpl.getStockByName("lenovo"));
	}

}

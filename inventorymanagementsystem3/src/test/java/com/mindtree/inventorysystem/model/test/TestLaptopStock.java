package com.mindtree.inventorysystem.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.model.LaptopStock;

@SpringBootTest
public class TestLaptopStock {

	@Test
	public void testGetStockId() {
		LaptopStock stock = new LaptopStock(1, "lenovo", 40000, 20);
		assertEquals(1, stock.getStockId());
	}

}

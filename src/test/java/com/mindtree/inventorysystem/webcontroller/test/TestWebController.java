package com.mindtree.inventorysystem.webcontroller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.webcontroller.WebController;

@SpringBootTest
public class TestWebController {
	@Autowired
	WebController webController;

	@Test
	public void testHome() {
		assertEquals("index", webController.home());
	}

	@Test
	public void testStock() {
		assertEquals("stock", webController.stock());
	}

	@Test
	public void testCustomer() {
		assertEquals("customer", webController.customer());
	}

	@Test
	public void testAllStocks() {
		assertEquals("allstocks", webController.allStocks());
	}

	@Test
	public void testGetStockByName() {
		assertEquals("getstockbyname", webController.getStockByName());
	}

	@Test
	public void testOrder() {
		assertEquals("order", webController.order());
	}
}

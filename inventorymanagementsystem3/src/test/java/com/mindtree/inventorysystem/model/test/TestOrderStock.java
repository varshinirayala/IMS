package com.mindtree.inventorysystem.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.model.OrderDetails;
import com.mindtree.inventorysystem.model.OrderStock;

@SpringBootTest
public class TestOrderStock {

	@Test
	public void testGetOrderStockId() {
		OrderStock orderStock = new OrderStock(1, null, "lenovo", 2);
		assertEquals(1, orderStock.getOrderStockId());
	}

	@Test
	public void testGetOrder() {
		OrderDetails order = new OrderDetails(1, null, 50000, null);
		OrderStock orderStock = new OrderStock(1, order, "lenovo", 2);
		assertEquals(order, orderStock.getOrder());
	}

}

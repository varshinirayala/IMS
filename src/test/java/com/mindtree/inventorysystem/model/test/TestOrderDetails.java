package com.mindtree.inventorysystem.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.model.OrderDetails;

@SpringBootTest
public class TestOrderDetails {

	@Test
	public void testGetOrderId() {
		OrderDetails order = new OrderDetails(1, null, 50000, null);
		assertEquals(1, order.getOrderId());
	}

	@Test
	public void testGetCustomer() {
		OrderDetails order = new OrderDetails(1, null, 50000, null);
		assertEquals(50000, order.getTotalPrice());
	}
}

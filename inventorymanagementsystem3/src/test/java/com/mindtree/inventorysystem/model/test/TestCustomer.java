package com.mindtree.inventorysystem.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.OrderDetails;

@SpringBootTest
public class TestCustomer {

	@Test
	public void testGetCustomerId() {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		assertEquals(1, customer.getCustomerId());
	}

	@Test
	public void testGetOrders() {
		List<OrderDetails> orders = new ArrayList<>();
		orders.add(new OrderDetails(1, null, 0, null));
		Customer customer = new Customer(1, "varshini", "hyderabad", orders);
		assertEquals(orders, customer.getOrders());
	}
}

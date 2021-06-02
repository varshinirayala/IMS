package com.mindtree.inventorysystem.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.controller.CustomerController;
import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.OrderDetails;
import com.mindtree.inventorysystem.model.OrderStock;
import com.mindtree.inventorysystem.service.CustomerService;

@SpringBootTest
public class TestCustomerController {
	@Mock
	CustomerService customerService;
	@InjectMocks
	CustomerController customerController;

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("varshini");
		customer.setCity("hyderabad");
		customer.setOrders(null);
		when(customerService.addCustomer(customer)).thenReturn(customer);
		assertEquals(customer, customerController.addCustomer(customer).getBody());
	}

	@Test
	public void testOrderStock() throws InsufficientQuantityException {
		Customer customer = new Customer("varshini");
		List<OrderStock> stocks = new ArrayList<>();
		OrderStock orderStock = new OrderStock();
		orderStock.setOrderStockId(1);
		orderStock.setOrderedQuantity(1);
		orderStock.setStockName("lenovo");
		orderStock.setOrder(null);
		stocks.add(orderStock);
		stocks.add(new OrderStock(2, null, "hp", 1));
		OrderDetails order = new OrderDetails(1, customer, 40000, stocks);
		when(customerService.orderStock(order)).thenReturn(order);
		assertEquals(order, customerController.orderStock(order).getBody());
	}
}

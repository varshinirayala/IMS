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

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.model.OrderDetails;
import com.mindtree.inventorysystem.model.OrderStock;
import com.mindtree.inventorysystem.repository.CustomerRepository;
import com.mindtree.inventorysystem.repository.OrderRepository;
import com.mindtree.inventorysystem.repository.StockRepository;
import com.mindtree.inventorysystem.service.impl.CustomerServiceImpl;

@SpringBootTest
public class TestCustomerServiceImpl {
	@Mock
	CustomerRepository customerRepository;
	@Mock
	StockRepository stockRepo;
	@Mock
	OrderRepository orderRepo;
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImpl.addCustomer(customer));
	}

	@Test
	public void testAddCustomerCase2() {
		Customer customer = new Customer(1, "", "", null);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(null, customerServiceImpl.addCustomer(customer));
	}

	@Test
	public void testAddCustomerCase3() {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		Optional<Customer> customerByName = Optional.of(new Customer(1, "varshini", "hyderabad", null));
		when(customerRepository.findByCustomerName("varshini")).thenReturn(customerByName);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(null, customerServiceImpl.addCustomer(customer));
	}

	@Test
	public void testOrderStock() throws InsufficientQuantityException {
		Customer customer = new Customer(1, "", "hyderabad", null);
		OrderDetails order = new OrderDetails();
		order.setCustomer(customer);
		order.setOrderId(1);
		order.setTotalPrice(0);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(null, customerServiceImpl.orderStock(order));
	}

	@Test
	public void testOrderStockCase2() throws InsufficientQuantityException {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		List<OrderStock> orderStocks = new ArrayList<>();
		orderStocks.add(new OrderStock(1, null, "lenovo", 2));
		OrderDetails order = new OrderDetails(1, customer, 0, null);
		order.setOrderedStocks(orderStocks);
		Optional<Customer> customerByName = Optional.of(new Customer(1, "varshini", "hyderabad", null));
		when(customerRepository.findByCustomerName("varshini")).thenReturn(customerByName);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(null, customerServiceImpl.orderStock(order));
	}

	@Test
	public void testOrderStockCase3() throws InsufficientQuantityException {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		OrderDetails order = new OrderDetails(1, customer, 50000, null);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(null, customerServiceImpl.orderStock(order));
	}

	@Test
	public void testOrderStockCase4() throws InsufficientQuantityException {
		Customer customer = new Customer(1, "varshini", "hyderabad", null);
		List<OrderStock> orderStocks = new ArrayList<>();
		orderStocks.add(new OrderStock(1, null, "lenovo", 2));
		OrderDetails order = new OrderDetails(1, customer, 0, orderStocks);
		Optional<Customer> customerByName = Optional.of(new Customer(1, "varshini", "hyderabad", null));
		when(customerRepository.findByCustomerName("varshini")).thenReturn(customerByName);
		Optional<LaptopStock> stockByName = Optional.of(new LaptopStock(1, "lenovo", 40000, 20));
		when(stockRepo.findByStockName("lenovo")).thenReturn(stockByName);
		when(orderRepo.save(order)).thenReturn(order);
		order.setTotalPrice(80000);
		assertEquals(order, customerServiceImpl.orderStock(order));
	}
}

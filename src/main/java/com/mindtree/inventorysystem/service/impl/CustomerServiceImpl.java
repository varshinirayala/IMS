package com.mindtree.inventorysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.LaptopStock;
import com.mindtree.inventorysystem.model.OrderDetails;
import com.mindtree.inventorysystem.model.OrderStock;
import com.mindtree.inventorysystem.repository.CustomerRepository;
import com.mindtree.inventorysystem.repository.OrderRepository;
import com.mindtree.inventorysystem.repository.StockRepository;
import com.mindtree.inventorysystem.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		log.info("calling addCustomer method from CustomerServiceImpl");
		if (customer.getCustomerName().equals("") || customer.getCity().equals("")) {
			return null;
		} else {
			Optional<Customer> customerByName = customerRepository.findByCustomerName(customer.getCustomerName());
			if (customerByName.isEmpty()) {
				return customerRepository.save(customer);
			}
		}
		return null;
	}

	@Override
	public OrderDetails orderStock(OrderDetails orderDetails) throws InsufficientQuantityException {
		if (orderDetails.getCustomer().getCustomerName().equals("")) {
			return null;
		} else {
			String customerName = orderDetails.getCustomer().getCustomerName();
			Optional<Customer> customerByName = customerRepository.findByCustomerName(customerName);
			if (customerByName.isPresent()) {
				double totalPrice = calculateTotalPrice(orderDetails);
				if (totalPrice == 0) {
					return null;
				} else {
					orderDetails.setCustomer(customerByName.get());
					orderDetails.setTotalPrice(totalPrice);
					return orderRepository.save(orderDetails);
				}
			}
		}
		return null;
	}

	private double calculateTotalPrice(OrderDetails orderDetails) throws InsufficientQuantityException {
		List<OrderStock> orderStocks = orderDetails.getOrderedStocks();
		double totalPrice = 0;
		for (OrderStock orderStock : orderStocks) {
			Optional<LaptopStock> stockByName = stockRepository.findByStockName(orderStock.getStockName());
			if (stockByName.isEmpty()) {
				return 0;
			} else {
				if (orderStock.getOrderedQuantity() < stockByName.get().getAvailableQuantity()) {
					totalPrice += orderStock.getOrderedQuantity() * stockByName.get().getPrice();
				} else {
					throw new InsufficientQuantityException("Insufficient quantity, " + stockByName.get().getStockName()
							+ " available quantity: " + stockByName.get().getAvailableQuantity());
				}
			}
			stockByName.get()
					.setAvailableQuantity(stockByName.get().getAvailableQuantity() - orderStock.getOrderedQuantity());
		}
		return totalPrice;
	}
}

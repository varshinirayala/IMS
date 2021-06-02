package com.mindtree.inventorysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.OrderDetails;
import com.mindtree.inventorysystem.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		log.info("calling addCustomer method from CustomerController");
		Customer savedCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@PostMapping("/orderStock")
	public ResponseEntity<?> orderStock(@RequestBody OrderDetails orderDetails) throws InsufficientQuantityException {
		log.info("calling orderStock method from CustomerController");
		OrderDetails order = customerService.orderStock(orderDetails);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

}

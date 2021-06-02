package com.mindtree.inventorysystem.service;

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.model.Customer;
import com.mindtree.inventorysystem.model.OrderDetails;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	OrderDetails orderStock(OrderDetails orderDetails) throws InsufficientQuantityException;

}

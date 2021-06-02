package com.mindtree.inventorysystem.exceptions.handler.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.exceptions.handler.GlobalExceptionHandler;

@SpringBootTest
public class TestGlobalExceptionHandler {
	@Autowired
	GlobalExceptionHandler ex;

	@Test
	public void testHandleStockNotFoundException() {
		assertNotNull(ex.handleStockNotFoundException(new StockNotFoundException("stock not found")));
	}

	@Test
	public void testHandleInsufficientQuantityException() {
		assertNotNull(ex.handleInsufficientQuantityException(new InsufficientQuantityException("insufficient")));
	}
}

package com.mindtree.inventorysystem.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.inventorysystem.exceptions.InsufficientQuantityException;
import com.mindtree.inventorysystem.exceptions.StockNotFoundException;
import com.mindtree.inventorysystem.exceptions.errormessage.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<?> handleStockNotFoundException(StockNotFoundException ex) {
		log.info("StockNotFoundException occurred");
		ErrorMessage errorDetails = new ErrorMessage(404, ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleInsufficientQuantityException(InsufficientQuantityException ex) {
		log.info("InsufficientQuantityException occurred");
		ErrorMessage errorDetails = new ErrorMessage(400, ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}

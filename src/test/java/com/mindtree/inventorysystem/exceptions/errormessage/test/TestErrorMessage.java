package com.mindtree.inventorysystem.exceptions.errormessage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.exceptions.errormessage.ErrorMessage;

@SpringBootTest
public class TestErrorMessage {
	@Test
	public void testGetErrorCode() {
		ErrorMessage errorMessage = new ErrorMessage(200, null, null);
		assertEquals(200, errorMessage.getErrorCode());
	}

	@Test
	public void testGetMessage() {
		ErrorMessage errorMessage = new ErrorMessage(200, "not found", null);
		assertEquals("not found", errorMessage.getMessage());
	}

	@Test
	public void testGetDate() {
		Date date = new Date();
		ErrorMessage errorMessage = new ErrorMessage(200, "not found", date);
		assertEquals(date, errorMessage.getDate());
	}
}

package com.mindtree.inventorysystem.security.user.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.security.user.User;

@SpringBootTest
public class TestUser {

	@Test
	public void testGetUserId() {
		User user = new User(1, null, null, false, null);
		assertEquals(1, user.getId());
	}
}

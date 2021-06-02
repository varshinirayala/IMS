package com.mindtree.inventorysystem.security.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.security.service.MyUserDetails;
import com.mindtree.inventorysystem.security.user.User;

@SpringBootTest
public class TestMyUserDetails {

	@Test
	public void testGetAuthorities() {
		User user = new User(1, "admin", "admin", true, "ROLE_ADMIN");
		MyUserDetails myUserDetails = new MyUserDetails(user);
		assertNotNull(myUserDetails.getAuthorities());
	}

	@Test
	public void testGetUserName() {
		User user = new User(1, "admin", "admin", true, "ROLE_ADMIN");
		MyUserDetails myUserDetails = new MyUserDetails(user);
		assertEquals("admin", myUserDetails.getUsername());
	}

	@Test
	public void testGetPassword() {
		User user = new User(1, "admin", "admin", true, "ROLE_ADMIN");
		MyUserDetails myUserDetails = new MyUserDetails(user);
		assertEquals("admin", myUserDetails.getPassword());
	}

	@Test
	public void testIsEnabled() {
		User user = new User(1, "admin", "admin", true, "ROLE_ADMIN");
		MyUserDetails myUserDetails = new MyUserDetails(user);
		assertEquals(true, myUserDetails.isEnabled());
	}

	@Test
	public void testIsAccountNonExpired() {
		User user = new User(1, "admin", "admin", true, "ROLE_ADMIN");
		MyUserDetails myUserDetails = new MyUserDetails(user);
		assertEquals(true, myUserDetails.isAccountNonExpired());
	}

	@Test
	public void testIsAccountNonLocked() {
		MyUserDetails myUserDetails = new MyUserDetails();
		assertEquals(true, myUserDetails.isAccountNonLocked());
	}

	@Test
	public void testIsCredentialsNonExpired() {
		MyUserDetails myUserDetails = new MyUserDetails();
		assertEquals(true, myUserDetails.isCredentialsNonExpired());
	}
}

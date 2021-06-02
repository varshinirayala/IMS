package com.mindtree.inventorysystem.security.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.inventorysystem.repository.UserRepository;
import com.mindtree.inventorysystem.security.service.MyUserDetailsService;
import com.mindtree.inventorysystem.security.user.User;

@SpringBootTest
public class TestMyUserDetailsService {
	@Mock
	UserRepository userRepo;
	@InjectMocks
	MyUserDetailsService myUserDetailsService;

	@Test
	public void testLoadUserByUserName() {
		Optional<User> user = Optional.of(new User(1, "admin", "admin", true, "ROLE_ADMIN"));
		when(userRepo.findByUserName("admin")).thenReturn(user);
		assertNotNull(myUserDetailsService.loadUserByUsername("admin"));
	}

}

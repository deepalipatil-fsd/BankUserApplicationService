package com.javacloud.bank.service;

import com.javacloud.bank.BankApplication;
import com.javacloud.bank.model.AccountHolder;
import com.javacloud.bank.repository.RegistrationRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = BankApplication.class)
public class BankUserDetailsServiceTest {

	@InjectMocks
	BankUserDetailsService service;
	@Mock
	RegistrationRepo repository;

	@Test
	public void testUserDetailsService() {
		AccountHolder account = new AccountHolder();
		when(repository.findByUserName(anyString())).thenReturn(account);
		Assert.assertNotNull(service.loadUserByUsername("user"));
	}

	@Test
	public void testUserNameNotFoundException() {
		assertThrows(UsernameNotFoundException.class, () -> {
			service.loadUserByUsername("user");
		});
	}

}

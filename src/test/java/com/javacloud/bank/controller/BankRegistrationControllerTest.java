package com.javacloud.bank.controller;

import com.javacloud.bank.BankApplication;
import com.javacloud.bank.model.AccountHolder;
import com.javacloud.bank.repository.RegistrationRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = BankApplication.class)
//@RunWith(SpringRunner.class)
public class BankRegistrationControllerTest {

	@InjectMocks
	BankRegistrationController controller;
	@Mock
	RegistrationRepo repository;

	@Test
	public void testRegistrationException() throws Exception {
		AccountHolder account = new AccountHolder();
		when(repository.save(any(AccountHolder.class))).thenThrow(new RuntimeException());
		Assert.assertNull(controller.register(account));
	}

	@Test
	public void testRegisterUser() throws Exception {
		AccountHolder account = new AccountHolder();
		when(repository.save(any(AccountHolder.class))).thenReturn(account);
		Assert.assertNotNull(controller.register(account));
	}

	@Test
	public void testUpdateDetailsForNoAccount() throws Exception {
		AccountHolder account = new AccountHolder();
		Assert.assertNull(controller.updateDetails(account));
	}

	@Test
	public void testUpdateDetails() throws Exception {
		AccountHolder account = new AccountHolder();
		account.setUserName("user");
		when(repository.findByUserName(anyString())).thenReturn(account);
		Assert.assertNotNull(controller.updateDetails(account));
	}

	@Test
	public void testUpdateUserException() throws Exception {
		AccountHolder account = new AccountHolder();account.setUserName("user");
		when(repository.findByUserName(anyString())).thenReturn(account);
		when(repository.save(any(AccountHolder.class))).thenThrow(new RuntimeException());
		Assert.assertNull(controller.updateDetails(account));
	}

	@Test
	public void testGetAccount() throws Exception {
		AccountHolder account = new AccountHolder();
		when(repository.findByAccountNumber(anyString())).thenReturn(account);
		Assert.assertEquals(account, controller.getAccount("1234567890"));
	}
}

package com.javacloud.bank;

import com.javacloud.bank.model.AccountHolder;
import com.javacloud.bank.repository.RegistrationRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BankApplicationTests {
	@InjectMocks
	BankApplication bankApplication;
	@Mock
	RegistrationRepo repository;
	@Test
	void testBankApplicationRun() {
		String[] args = {};
		BankApplication.main(args);
		bankApplication.run(args);
		verify(repository, times(1)).save(any(AccountHolder.class));
	}
}

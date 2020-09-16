package com.javacloud.bank;

import com.javacloud.bank.model.AccountHolder;
import com.javacloud.bank.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class BankApplication  implements CommandLineRunner {

	@Autowired
	RegistrationRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Override
	public void run(String... args) {
		repository.save(new AccountHolder(null, "1234567890", "Deepali", "user", "AIDTAIiCazaQavILI07rtA==", "Pune", "Mah", "India", "deepali@cts.com", "ASDFG0987A", "9898989898", new Date("12/12/1998"), "Savings"));
	}
}

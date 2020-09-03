package com.javacloud.bank.repository;

import com.javacloud.bank.model.AccountHolder;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<AccountHolder, String> {
    AccountHolder findByUserName(String userName);
}

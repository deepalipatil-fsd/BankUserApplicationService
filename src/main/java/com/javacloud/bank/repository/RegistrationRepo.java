package com.javacloud.bank.repository;

import com.javacloud.bank.model.AccountHolder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<AccountHolder, String> {
    AccountHolder findByUserName(String userName);
    AccountHolder findByAccountNumber(String accountNumber);
//    @Query("SELECT a FROM AccountHolder a WHERE LOWER(a.userName) = LOWER(:userName) AND LOWER(a.password) = LOWER(:password)")
//    AccountHolder findByUserNamePassword(String userName, String password);
}

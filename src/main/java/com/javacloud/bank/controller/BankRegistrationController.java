package com.javacloud.bank.controller;

import com.javacloud.bank.model.AccountHolder;
import com.javacloud.bank.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/")
public class BankRegistrationController {
    @Autowired
    RegistrationRepo repository;

    @PostMapping("/register")
    AccountHolder register(@RequestBody AccountHolder accountHolder) {
        //Add code to check if user exist with same PAN. Not needed after adding unique constraint on PAN column.
        try{
            return repository.save(accountHolder);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    @PostMapping("/login")
    AccountHolder login(@RequestBody AccountHolder accountHolder) {
        //Add code to check if user exist with same PAN. Not needed after adding unique constraint on PAN column.
        try{
            AccountHolder account = repository.findByUserName(accountHolder.getUserName());
            if(ObjectUtils.isEmpty(account) || !account.getPassword().equalsIgnoreCase(accountHolder.getPassword()))
                throw new RuntimeException("Login failed.");
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    @PostMapping("/update")
    AccountHolder updateDetails(@RequestBody AccountHolder accountHolder) {
        try{
            AccountHolder account = repository.findByUserName(accountHolder.getUserName());
            if(ObjectUtils.isEmpty(account))
                return null; // throw exception instead
            account.setName(accountHolder.getName());
            account.setPassword(accountHolder.getPassword());
            account.setAddress(accountHolder.getAddress());
            account.setContactNo(accountHolder.getContactNo());
            account.setCountry(accountHolder.getCountry());
            account.setEmail(accountHolder.getEmail());
            repository.save(account);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    @GetMapping("/accountdetails/{accountNumber}")
    AccountHolder getAccount(@PathVariable("accountNumber") String accountNumber) {
        return repository.findById(accountNumber).orElse(new AccountHolder());
    }

}

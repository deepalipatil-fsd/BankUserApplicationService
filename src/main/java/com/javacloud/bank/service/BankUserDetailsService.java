//package com.javacloud.bank.service;
//
//import com.javacloud.bank.model.AccountHolder;
//import com.javacloud.bank.model.BankUser;
//import com.javacloud.bank.repository.RegistrationRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//@Service
//public class BankUserDetailsService implements UserDetailsService {
//    @Autowired
//    RegistrationRepo registrationRepo;
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        AccountHolder accountHolder = registrationRepo.findByUserName(userName);
//        if(ObjectUtils.isEmpty(accountHolder))
//            throw new UsernameNotFoundException("User 404");
//        return new BankUser(accountHolder);
//    }
//}

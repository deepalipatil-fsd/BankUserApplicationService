package com.javacloud.bank.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String name;
    @Column(unique=true)
    private String userName;
    private String password;
    private String address;
    private String state;
    private String country;
    private String email;
    //@UniqueConstraint("pan")
    @Column(unique=true)
    private String pan;
    private String contactNo;
    //@NotNull
    //@JsonbDateFormat("dd/MM/yyyy")
    private Date dob;
    //private AccountType accountType;
    private String accountType;
}

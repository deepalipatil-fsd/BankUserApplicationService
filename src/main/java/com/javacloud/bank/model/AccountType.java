package com.javacloud.bank.model;

public enum AccountType {
    //Constants with values
    LOAN("Loan"), SAVINGS("Savings"), CURRENT("Current"), FD("FixedDeposite"), RD("RecurringDeposite");
    //Instance variable
    private String value;

    //Constructor to initialize the instance variable
    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

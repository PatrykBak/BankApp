package com.patryk.bankapp.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id
    private long account_id;
    private String customer_name;
    private BigDecimal balance;

    public long getId() {
        return account_id;
    }

    public void setId(long account_id) {
        this.account_id = account_id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

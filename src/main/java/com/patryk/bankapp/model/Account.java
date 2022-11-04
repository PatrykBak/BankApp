package com.patryk.bankapp.model;

import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

public class Account {

    @Id
    private long id;
    private String customer;
    private BigDecimal balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customer;
    }

    public void setCustomerName(String customerName) {
        this.customer = customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

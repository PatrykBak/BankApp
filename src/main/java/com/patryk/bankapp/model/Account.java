package com.patryk.bankapp.model;

import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

public class Account {

    @Id
    private long accountId;
    private String customerName;
    private BigDecimal balance;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

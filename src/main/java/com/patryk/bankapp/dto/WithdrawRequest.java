package com.patryk.bankapp.dto;

import java.math.BigDecimal;

public class WithdrawRequest {

    private long accountId;
    private BigDecimal amount;

    public long getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

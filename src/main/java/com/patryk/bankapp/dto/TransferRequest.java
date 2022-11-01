package com.patryk.bankapp.dto;

import java.math.BigDecimal;

public class TransferRequest {

    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

    public long getSenderAccountId() {
        return senderAccountId;
    }
    public long getReceiverAccountId() {
        return receiverAccountId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
}

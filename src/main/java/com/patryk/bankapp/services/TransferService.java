package com.patryk.bankapp.services;

import com.patryk.bankapp.exceptions.AccountNotFoundException;
import com.patryk.bankapp.model.Account;
import com.patryk.bankapp.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewBalance = sender.getBalance().subtract(amount);
        BigDecimal receiverNewBalance = receiver.getBalance().add(amount);

        accountRepository.changeBalance(idSender, senderNewBalance);
        accountRepository.changeBalance(idReceiver, receiverNewBalance);
    }
}

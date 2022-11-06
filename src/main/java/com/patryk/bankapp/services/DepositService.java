package com.patryk.bankapp.services;

import com.patryk.bankapp.exceptions.AccountNotFoundException;
import com.patryk.bankapp.model.Account;
import com.patryk.bankapp.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class DepositService {

    private final AccountRepository accountRepository;

    public DepositService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void depositMoney(long idAccount, BigDecimal amount) {
        Account account = accountRepository.findById(idAccount)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal accountNewBalance = account.getBalance().add(amount);
        accountRepository.changeBalance(idAccount, accountNewBalance);
    }
}

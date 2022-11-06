package com.patryk.bankapp.services;

import com.patryk.bankapp.model.Account;
import com.patryk.bankapp.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByCustomerName(String name) {
        return accountRepository.findAccountsByCustomerName(name);
    }
}

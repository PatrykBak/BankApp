package com.patryk.bankapp;

import com.patryk.bankapp.model.Account;
import com.patryk.bankapp.repositories.AccountRepository;
import com.patryk.bankapp.services.DepositService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DepositServiceUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private DepositService depositService;

    @Test
    public void depositMoneyHappyFlow() {
        Account account = new Account();
        account.setId(1);
        account.setBalance(new BigDecimal(1000));

        given(accountRepository.findById(account.getId()))
                .willReturn(Optional.of(account));

        depositService.depositMoney(1, new BigDecimal(100));

        verify(accountRepository).changeBalance(1, new BigDecimal(1100));
    }
}
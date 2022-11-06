package com.patryk.bankapp.controllers;

import com.patryk.bankapp.dto.DepositRequest;
import com.patryk.bankapp.dto.TransferRequest;
import com.patryk.bankapp.dto.WithdrawRequest;
import com.patryk.bankapp.model.Account;
import com.patryk.bankapp.services.AccountService;
import com.patryk.bankapp.services.DepositService;
import com.patryk.bankapp.services.TransferService;
import com.patryk.bankapp.services.WithdrawService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;
    private final WithdrawService withdrawService;
    private final DepositService depositService;
    private final AccountService accountService;

    public AccountController(TransferService transferService, WithdrawService withdrawService, DepositService depositService, AccountService accountService) {
        this.transferService = transferService;
        this.withdrawService = withdrawService;
        this.depositService = depositService;
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @PostMapping("/withdraw")
    public void withdrawMoney(
            @RequestBody WithdrawRequest request
    ) {
        withdrawService.withdrawMoney(
                request.getAccountId(),
                request.getAmount());
    }

    @PostMapping("/deposit")
    public void depositMoney(
            @RequestBody DepositRequest request
    ) {
        depositService.depositMoney(
                request.getAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name, String accountId
    ) {
        if (name != null) {
            return accountService.findAccountsByCustomerName(name);
        }
        else if (accountId != null) {
            return accountService.findAccountsByAccountId(accountId);
        }
        else {
            return accountService.getAllAccounts();
        }
    }

}
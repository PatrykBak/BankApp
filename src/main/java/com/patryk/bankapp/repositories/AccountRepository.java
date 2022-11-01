package com.patryk.bankapp.repositories;

import com.patryk.bankapp.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account WHERE customerName = :customerName")
    List<Account> findAccountsByName(String customerName);

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE accountId = :accountId")
    void changeAmount(long accountId, BigDecimal balance);

}
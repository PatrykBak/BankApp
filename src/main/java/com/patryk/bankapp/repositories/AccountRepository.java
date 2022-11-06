package com.patryk.bankapp.repositories;

import com.patryk.bankapp.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account WHERE customer_name = :customer_name")
    List<Account> findAccountsByCustomerName(String customer_name);

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE account_id = :account_id")
    void changeBalance(long account_id, BigDecimal balance);

}
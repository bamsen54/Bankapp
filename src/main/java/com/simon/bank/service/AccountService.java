package com.simon.bank.service;

import com.simon.bank.entity.Account;
import com.simon.bank.entity.Transaction;
import jakarta.validation.constraints.Positive;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountService {

    public Optional<Account> findById(Long id);

    public Account save(Account account);

    public Account deposit(@Positive double amount, Account account);
    public Account withdraw(@Positive double amount, Account account);
    public Account createTransaction(Transaction transaction);
}

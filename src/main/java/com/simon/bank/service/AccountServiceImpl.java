package com.simon.bank.service;

import com.simon.bank.entity.Account;
import com.simon.bank.entity.Transaction;
import com.simon.bank.repository.AccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final TransactionService transactionService;

    public AccountServiceImpl(AccountRepo accountRepo, TransactionService transactionService) {
        this.accountRepo = accountRepo;
        this.transactionService = transactionService;
    }

    @Override
    public Account save(Account account) {
        return this.accountRepo.save(account);
    }

    @Override
    public Account transfer(Transaction transaction) {

        transactionService.save(transaction);

        double amount = transaction.getAmount();
        Account accountFrom = transaction.getAccountFrom();
        Account accountTo = transaction.getAccountTo();


        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountTo.setBalance(accountTo.getBalance() + amount);

        this.accountRepo.save(accountTo);

        return this.accountRepo.save(accountFrom);
    }
}

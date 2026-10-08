package com.simon.bank.service;

import com.simon.bank.entity.Account;
import com.simon.bank.entity.Transaction;

public interface AccountService {

    public Account save(Account account);

    public Account transfer(Transaction transaction);
}

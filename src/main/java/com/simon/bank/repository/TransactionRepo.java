package com.simon.bank.repository;

import com.simon.bank.entity.Account;
import com.simon.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByAccountFrom(Account accountFrom);
    List<Transaction> findTransactionsByAccountTo(Account accountTo);
}

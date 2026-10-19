package com.simon.bank.entity;

import com.simon.bank.exception.InsufficientFundsException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@Validated
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_from_id")
    private Account accountFrom;


    @ManyToOne
    @JoinColumn(name = "account_to_id")
    private Account accountTo;

    protected Transaction() {
    }

    public Transaction(@Positive double amount, Account accountFrom, Account accountTo) {
        this.amount      = amount;
        this.accountFrom = accountFrom;
        this.accountTo   = accountTo;

        if(accountFrom.getBalance() < amount)
            throw new InsufficientFundsException(accountFrom.getId(), amount);
    }

    public String toString() {
        return this.amount + " " + this.accountFrom.getId() + "->" + this.accountTo.getId();
    }
}

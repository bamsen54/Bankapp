package com.simon.bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "transactions")
@Getter
@Setter
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

    public Transaction(double amount, Account accountFrom, Account accountTo) {
        this.amount      = amount;
        this.accountFrom = accountFrom;
        this.accountTo   = accountTo;
    }
}

package com.simon.bank.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(Long id, double amount) {
        super(
                "Account with id: " + id + " has a balance that is less than: " + amount
        );
    }
}

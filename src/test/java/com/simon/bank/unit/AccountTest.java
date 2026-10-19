package com.simon.bank.unit;

import com.simon.bank.entity.Account;
import com.simon.bank.exception.InsufficientFundsException;
import com.simon.bank.repository.AccountRepo;
import com.simon.bank.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    Account testaccount;

    @Mock
    private AccountRepo accountRepoMock;

    @InjectMocks
    AccountServiceImpl accountService;


    @BeforeEach
    public void setup() {
        this.testaccount = new Account();
        this.testaccount.setBalance(0);
        this.testaccount = new Account();
        this.testaccount.setBalance(0);
    }

    @Test
    @DisplayName("After depositing 100kr the balance should be 100kr")
    public void AfterDepositing100krTheBalanceShouldBe100kr() {

        when(accountService.findById(1L)).thenReturn(Optional.ofNullable(this.testaccount));

        Account account =accountService.findById(1L).get();

        accountService.deposit(100, account);

        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    @DisplayName("After withdrawing 30kr the balance should be 70kr")
    public void AfterWithdrawing30krTheBalanceShouldBe70r() {

        when(accountService.findById(1L)).thenReturn(Optional.ofNullable(this.testaccount));

        Account account = accountService.findById(1L).get();

        accountService.deposit(100, account);
        accountService.withdraw(30, account);

        assertThat(account.getBalance()).isEqualTo(70);
    }

    @Test
    @DisplayName("Deposit a an amount larger than the balance should throw InsufficientFundsException")
    public void DepositANegativeAmountShouldThrowInsufficientFundsException() {
        when(accountService.findById(1L)).thenReturn(Optional.ofNullable(this.testaccount));

        Account account = accountService.findById(1L).get();

        accountService.deposit(100, account);

        assertThrows(InsufficientFundsException.class,  () -> accountService.withdraw(120, account));
    }
}

package com.simon.bank.unit;

import com.simon.bank.entity.Account;
import com.simon.bank.repository.AccountRepo;
import com.simon.bank.repository.TransactionRepo;
import com.simon.bank.service.AccountService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    Account testAccount;

    @Mock
    private AccountRepo accountRepoMock;

    @InjectMocks
    AccountServiceImpl accountService;


    @BeforeEach
    public void setup() {
        this.testAccount = new Account();
        this.testAccount.setBalance(0);
    }

    @Test
    @DisplayName("After depositing 100kr the balance should be 100kr")
    public void AfterDepositing100krTheBalanceShouldBe100kr() {

        when(accountService.findById(1L)).thenReturn(Optional.ofNullable(this.testAccount));

        Account account =accountService.findById(1L).get();

        account.deposit(100);

        assertThat(account.getBalance()).isEqualTo(100);
    }
}

package com.simon.bank;


import com.simon.bank.entity.Account;
import com.simon.bank.entity.Transaction;
import com.simon.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.hibernate.SpringSessionContext;

@SpringBootApplication
public class BankApplication {

    @Autowired
    private ApplicationContext context;

    void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Value("${server.port:8080}") String port) {
        return args -> {

            AccountService accountService = context.getBean(AccountService.class);

            Account account1 = new Account();
            account1.setBalance(100);
            Account account2 = new Account();
            accountService.save(account1);
            accountService.save(account2);

            Transaction transaction = new Transaction(50, account1, account2);

            accountService.transfer(transaction);



            IO.println("Application is running on port: " + port);
        };
    }
}

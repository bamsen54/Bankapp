package com.simon.bank;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class BankApplication {

    void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Value("${server.port:8080}") String port) {
        return args -> {
            IO.println("Application is running on port: " + port);
        };
    }
}

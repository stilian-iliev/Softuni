package com.example.demo.services;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Account account = accountRepository.findAccountById(id);
        if (account != null && account.getBalance().compareTo(amount) != -1) {
            account.setBalance(account.getBalance().subtract(amount));
            accountRepository.save(account);
        }

    }

    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Account account = accountRepository.findAccountById(id);
        if (account != null) {
            account.setBalance(account.getBalance().add(amount));
            accountRepository.save(account);
        }
    }
}

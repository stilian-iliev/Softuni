package com.example.demo.services;

import com.example.demo.models.Account;
import com.example.demo.models.User;

import java.math.BigDecimal;

public interface AccountService {
    void addAccount(Account account);
    void withdrawMoney(BigDecimal amount, Long id);
    void depositMoney(BigDecimal amount, Long id);
}

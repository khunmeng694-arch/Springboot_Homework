package com.example.springbootteaching.service.balance;

import com.example.springbootteaching.model.Balance;

import java.math.BigDecimal;

public interface BalanceService {
    Balance checkBalances();
    Balance depositBalance(BigDecimal usd, BigDecimal khr);
    Balance withdrawBalance(BigDecimal usd,BigDecimal khr);
}

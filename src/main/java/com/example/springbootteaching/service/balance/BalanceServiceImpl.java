package com.example.springbootteaching.service.balance;

import com.example.springbootteaching.model.Balance;
import com.example.springbootteaching.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    private Balance getOrCreateBalance() {
        return balanceRepository.findAll().stream()
                .findFirst()
                .orElseGet(() -> balanceRepository.save(new Balance(BigDecimal.ZERO, BigDecimal.ZERO)));
    }

    @Override
    @Transactional
    public Balance checkBalances() {
        return getOrCreateBalance();
    }

    @Override
    @Transactional
    public Balance depositBalance(BigDecimal usd, BigDecimal khr) {
        Balance balance = getOrCreateBalance();

        BigDecimal inputUsd = (usd != null) ? usd : BigDecimal.ZERO;
        BigDecimal inputKhr = (khr != null) ? khr : BigDecimal.ZERO;

        if (inputUsd.compareTo(BigDecimal.ZERO) < 0 || inputKhr.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }

        BigDecimal currentUsd = (balance.getUsdBalance() != null) ? balance.getUsdBalance() : BigDecimal.ZERO;
        BigDecimal currentKhr = (balance.getKhrBalance() != null) ? balance.getKhrBalance() : BigDecimal.ZERO;

        balance.setUsdBalance(currentUsd.add(inputUsd));
        balance.setKhrBalance(currentKhr.add(inputKhr));

        return balanceRepository.save(balance);
    }

    @Override
    @Transactional
    public Balance withdrawBalance(BigDecimal usd, BigDecimal khr) {
        Balance balance = getOrCreateBalance();

        BigDecimal inputUsd = (usd != null) ? usd : BigDecimal.ZERO;
        BigDecimal inputKhr = (khr != null) ? khr : BigDecimal.ZERO;

        if (inputUsd.compareTo(BigDecimal.ZERO) < 0 || inputKhr.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }

        BigDecimal currentUsd = (balance.getUsdBalance() != null) ? balance.getUsdBalance() : BigDecimal.ZERO;
        BigDecimal currentKhr = (balance.getKhrBalance() != null) ? balance.getKhrBalance() : BigDecimal.ZERO;

        if (currentUsd.compareTo(inputUsd) < 0) {
            throw new IllegalArgumentException("Insufficient USD balance");
        }
        if (currentKhr.compareTo(inputKhr) < 0) {
            throw new IllegalArgumentException("Insufficient KHR balance");
        }

        balance.setUsdBalance(currentUsd.subtract(inputUsd));
        balance.setKhrBalance(currentKhr.subtract(inputKhr));

        return balanceRepository.save(balance);
    }
}
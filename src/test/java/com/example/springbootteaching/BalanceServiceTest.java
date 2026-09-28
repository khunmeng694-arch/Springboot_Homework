package com.example.springbootteaching;

import com.example.springbootteaching.model.Balance;
import com.example.springbootteaching.repository.BalanceRepository;
import com.example.springbootteaching.service.balance.BalanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceServiceTest {

    private BalanceRepository balanceRepository;
    private BalanceServiceImpl balanceService;

    @BeforeEach
    void setUp() {
        balanceRepository = new BalanceRepository();
        balanceService = new BalanceServiceImpl(balanceRepository);
    }

    @Test
    void testInitialBalanceIsZero() {
        Balance balance = balanceService.checkBalances();
        assertEquals(0, BigDecimal.ZERO.compareTo(balance.getUsdBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(balance.getKhrBalance()));
    }

    @Test
    void testDepositIncreasesBalance() {
        Balance balance = balanceService.depositBalance(new BigDecimal("100.00"), new BigDecimal("400000"));
        assertEquals(0, new BigDecimal("100.00").compareTo(balance.getUsdBalance()));
        assertEquals(0, new BigDecimal("400000").compareTo(balance.getKhrBalance()));
    }

    @Test
    void testWithdrawDecreasesBalance() {
        // First deposit
        balanceService.depositBalance(new BigDecimal("100.00"), new BigDecimal("400000"));

        // Now withdraw
        Balance balance = balanceService.withdrawBalance(new BigDecimal("30.00"), new BigDecimal("100000"));
        assertEquals(0, new BigDecimal("70.00").compareTo(balance.getUsdBalance()));
        assertEquals(0, new BigDecimal("300000").compareTo(balance.getKhrBalance()));
    }

    @Test
    void testWithdrawInsufficientUsdThrowsException() {
        balanceService.depositBalance(new BigDecimal("50.00"), new BigDecimal("100000"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            balanceService.withdrawBalance(new BigDecimal("100.00"), BigDecimal.ZERO);
        });
        assertEquals("Insufficient USD balance", ex.getMessage());
    }

    @Test
    void testWithdrawInsufficientKhrThrowsException() {
        balanceService.depositBalance(new BigDecimal("50.00"), new BigDecimal("100000"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            balanceService.withdrawBalance(BigDecimal.ZERO, new BigDecimal("200000"));
        });
        assertEquals("Insufficient KHR balance", ex.getMessage());
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            balanceService.withdrawBalance(new BigDecimal("-10"), BigDecimal.ZERO);
        });
        assertEquals("Withdrawal amount cannot be negative", ex.getMessage());
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            balanceService.depositBalance(new BigDecimal("-10"), BigDecimal.ZERO);
        });
        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }
}

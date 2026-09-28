package com.example.springbootteaching;

import com.example.springbootteaching.StudentController.BalanceUIController;
import com.example.springbootteaching.model.Balance;
import com.example.springbootteaching.repository.BalanceRepository;
import com.example.springbootteaching.service.balance.BalanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceUIControllerTest {

    private BalanceRepository balanceRepository;
    private BalanceServiceImpl balanceService;
    private BalanceUIController controller;

    @BeforeEach
    void setUp() {
        balanceRepository = new BalanceRepository();
        balanceService = new BalanceServiceImpl(balanceRepository);
        controller = new BalanceUIController(balanceService);
    }

    @Test
    void testCheckBalance() {
        Model model = new ExtendedModelMap();
        String view = controller.checkBalance(model);
        assertEquals("index", view);
        assertNotNull(model.getAttribute("balance"));
    }

    @Test
    void testWithdrawInitialView() {
        Model model = new ExtendedModelMap();
        String view = controller.withdrawBalance(model, BigDecimal.ZERO, BigDecimal.ZERO);
        assertEquals("Withdraw-Balance", view);
        assertNotNull(model.getAttribute("balance"));
        assertNull(model.getAttribute("error"));
        assertNull(model.getAttribute("success"));
    }

    @Test
    void testWithdrawSuccess() {
        balanceService.depositBalance(new BigDecimal("100"), new BigDecimal("50000"));

        Model model = new ExtendedModelMap();
        String view = controller.withdrawBalance(model, new BigDecimal("40"), new BigDecimal("20000"));
        assertEquals("Withdraw-Balance", view);

        Balance balance = (Balance) model.getAttribute("balance");
        assertNotNull(balance);
        assertEquals(0, new BigDecimal("60").compareTo(balance.getUsdBalance()));
        assertEquals(0, new BigDecimal("30000").compareTo(balance.getKhrBalance()));
        assertEquals("Withdrawal completed successfully!", model.getAttribute("success"));
        assertNull(model.getAttribute("error"));
    }

    @Test
    void testWithdrawInsufficientBalanceShowsErrorInModel() {
        Model model = new ExtendedModelMap();
        String view = controller.withdrawBalance(model, new BigDecimal("100"), BigDecimal.ZERO);
        assertEquals("Withdraw-Balance", view);
        assertEquals("Insufficient USD balance", model.getAttribute("error"));
        assertNotNull(model.getAttribute("balance"));
        assertNull(model.getAttribute("success"));
    }
}

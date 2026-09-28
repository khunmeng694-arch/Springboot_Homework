package com.example.springbootteaching.StudentController;

import com.example.springbootteaching.model.Balance;
import com.example.springbootteaching.service.balance.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class BalanceUIController {
    private final BalanceService balanceService;

    @GetMapping("/balance")
    public String checkBalance(Model model) {
        Balance balance = balanceService.checkBalances();
        model.addAttribute("balance" , balance);
        return "index";
    }

    @GetMapping("/deposit")
    public String DepositBalance(
            Model model,
            @RequestParam(defaultValue = "0") BigDecimal usd,
            @RequestParam(defaultValue = "0") BigDecimal khr) {
        try {
            Balance balance = balanceService.depositBalance(usd, khr);
            model.addAttribute("balance", balance);
            if ((usd != null && usd.compareTo(BigDecimal.ZERO) > 0) || (khr != null && khr.compareTo(BigDecimal.ZERO) > 0)) {
                model.addAttribute("success", "Deposit completed successfully!");
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("balance", balanceService.checkBalances());
        }
        return "update-balance";
    }

    @GetMapping("/withdraw")
    public String withdrawBalance(
            Model model,
            @RequestParam(defaultValue = "0") BigDecimal usd,
            @RequestParam(defaultValue = "0") BigDecimal khr) {
        try {
            Balance balance = balanceService.withdrawBalance(usd, khr);
            model.addAttribute("balance", balance);
            if ((usd != null && usd.compareTo(BigDecimal.ZERO) > 0) || (khr != null && khr.compareTo(BigDecimal.ZERO) > 0)) {
                model.addAttribute("success", "Withdrawal completed successfully!");
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("balance", balanceService.checkBalances());
        }
        return "Withdraw-Balance";
    }
}

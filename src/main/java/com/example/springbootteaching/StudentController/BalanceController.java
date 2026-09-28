package com.example.springbootteaching.StudentController;

import com.example.springbootteaching.model.Balance;
import com.example.springbootteaching.service.balance.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/balance")
public class BalanceController {
    private final BalanceService balanceService;

    @GetMapping
    public Balance checkBalance() {
        return balanceService.checkBalances();
    }

    @PutMapping("/deposit")
    public Balance DepositBalance(@RequestBody Balance balance) {
        return balanceService.depositBalance(balance.getUsdBalance() , balance.getKhrBalance());
    }
    @PutMapping("/withdraw")
    public Balance withdrawBalance(@RequestBody Balance balance){
        return  balanceService.withdrawBalance(balance.getUsdBalance(),balance.getKhrBalance());
    }
}

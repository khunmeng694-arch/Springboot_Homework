package com.example.springbootteaching.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "balances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usd_balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal usdBalance = BigDecimal.ZERO;

    @Column(name = "khr_balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal khrBalance = BigDecimal.ZERO;

    public Balance(BigDecimal usdBalance, BigDecimal khrBalance) {
        this.usdBalance = usdBalance;
        this.khrBalance = khrBalance;
    }
}
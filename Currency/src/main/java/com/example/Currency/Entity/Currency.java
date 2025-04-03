package com.example.Currency.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @Id
    private Long userId;

    private int currentCoinBalance;
    private int earnedCoins;
    private int redeemedCoins;
}

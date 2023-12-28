package com.kodilla.currencyexchangefront.bayingAmmount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPurchase {
    private Long id;
    private String currencyCode;
    private String operationType;
    private double amount;
    private double purchaseRate;
    private double purchaseAmount;
    private LocalDateTime purchaseDate;

    public CurrencyPurchase(String currencyCode, String operationType, double amount, double purchaseRate, double purchaseAmount) {
        this.currencyCode = currencyCode;
        this.operationType = operationType;
        this.amount = amount;
        this.purchaseRate = purchaseRate;
        this.purchaseAmount = purchaseAmount;
    }
}
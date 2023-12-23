package com.kodilla.currencyexchangefront.calculateAmount;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyCalculator {
    RestTemplate restTemplate = new RestTemplate();
    CalculateAmount calculateAmount = new CalculateAmount();
    public double sendRequestCalculation(String code, String type, double amount) {
        calculateAmount.setCode(code);
        calculateAmount.setType(type);
        calculateAmount.setAmount(amount);

        Amount resultAmount = restTemplate.postForObject("http://localhost:8080/calculate-amount", calculateAmount, Amount.class);

        return resultAmount.getResult();
    }
}

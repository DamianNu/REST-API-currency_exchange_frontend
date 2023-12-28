package com.kodilla.currencyexchangefront.bayingAmmount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CurrencyBaying {
    RestTemplate restTemplate = new RestTemplate();
    CurrencyPurchase currencyPurchase = new CurrencyPurchase();
    public void sendRequestBaying(String currencyCode, String operationType, double amount, double purchaseRate, double purchaseAmount) {
        currencyPurchase.setCurrencyCode(currencyCode);
        currencyPurchase.setOperationType(operationType);
        currencyPurchase.setAmount(amount);
        currencyPurchase.setPurchaseRate(purchaseRate);
        currencyPurchase.setPurchaseAmount(purchaseAmount);
        CurrencyPurchase result = restTemplate.postForObject("http://localhost:8080/purchase", currencyPurchase, CurrencyPurchase.class);
        System.out.println(result);
    }
}

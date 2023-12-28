package com.kodilla.currencyexchangefront.currency;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CurrencyClient {
    public static final String CURRENCY_URL = "http://localhost:8080/currency";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Currency> getCurrencyList() {
        Currency currency[] = restTemplate.getForObject(CURRENCY_URL,
                Currency[].class);
        return List.of(currency);
    }

    public double getCurrencyByCode(String code, String operationType) {
        Currency currency = restTemplate.getForObject(CURRENCY_URL + "/code/" + code,
                Currency.class);
        if (operationType.equals("buying")) {
            return currency.getBuying();
        } else {
            return currency.getSelling();
        }
    }
}

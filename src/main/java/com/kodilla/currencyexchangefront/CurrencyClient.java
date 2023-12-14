package com.kodilla.currencyexchangefront;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CurrencyClient {
    public static final String CURRENCY_URL = "http://localhost:8080/currency";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Currency> getCurrency() {
        Currency currency[] = restTemplate.getForObject(CURRENCY_URL,
                Currency[].class);
        return List.of(currency);
    }
}

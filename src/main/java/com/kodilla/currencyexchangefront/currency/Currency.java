package com.kodilla.currencyexchangefront.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private String code;

    private String currency;

    private double buying;

    private double selling;

}

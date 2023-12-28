package com.kodilla.currencyexchangefront.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    private String name;
    private String password;

    public LoginUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

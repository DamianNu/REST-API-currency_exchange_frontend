package com.kodilla.currencyexchangefront.registration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class Registration {
    RestTemplate restTemplate = new RestTemplate();
    User user = new User();
    String URL = "http://localhost:8080/users";

    public boolean registration(String login, String email, String password) {
        user.setName(login);
        user.setEmail(email);
        user.setPassword(password);
        try {
            User user1 = restTemplate.getForObject(URL + "/name/" + login, User.class);
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            User result = restTemplate.postForObject(URL, user, User.class);
            System.out.println("User - [" + user.getName() + " , " + user.getEmail() + "] -- has been registered!");
            return true;
        }
        return false;
    }
}

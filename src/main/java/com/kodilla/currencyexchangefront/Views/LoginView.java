package com.kodilla.currencyexchangefront.Views;

import com.kodilla.currencyexchangefront.login.LoginUser;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Route("login")
@PageTitle("Login | Wymiana Walut")
public class LoginView extends VerticalLayout {
    RestTemplate restTemplate = new RestTemplate();
    private TextField username;
    private PasswordField password;

    public LoginView() {
        username = new TextField("Nazwa użytkownika");
        password = new PasswordField("Hasło");

        add(username, password);

        Button loginButton = new Button("Zaloguj");
        loginButton.addClickListener(event -> {
            String usernameValue = username.getValue();
            String passwordValue = password.getValue();

            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/login", new LoginUser(usernameValue,passwordValue), String.class);

            boolean success = response.getStatusCode().is2xxSuccessful();

            System.out.println(success);

            if (success) {
                Notification.show("Logowanie pomyślne!");
                UI.getCurrent().navigate("v1");
            } else {
                Notification.show("Niepoprawna nazwa użytkownika lub hasło");
            }
        });

        add(loginButton);
    }
}
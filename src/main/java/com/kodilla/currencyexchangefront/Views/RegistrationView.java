package com.kodilla.currencyexchangefront.Views;

import com.kodilla.currencyexchangefront.registration.Registration;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Wymiana Walut")
@Route(value = "registration")
@Uses(Icon.class)
public class RegistrationView extends Composite<VerticalLayout> {

    Registration registration = new Registration();

    public RegistrationView() {
        VerticalLayout layoutColumn3 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H2 h2 = new H2();

        String text = " ";

        TextField textFieldEmail = new TextField();
        TextField textFieldLog = new TextField();
        TextField textFieldPass = new TextField();
        Button buttonRegister = new Button();
        Paragraph textInfo = new Paragraph();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        getContent().setSpacing(false);
        getContent().setPadding(false);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.START);
        layoutColumn3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn4.setSpacing(false);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("min-content");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h2.setText("Rejestracja");
        h2.setWidth("max-content");
        textFieldLog.setLabel("Login");
        textFieldLog.setWidth("min-content");
        textFieldPass.setLabel("Hasło");
        textFieldPass.setWidth("min-content");
        textFieldEmail.setLabel("Email");
        textFieldEmail.setWidth("min-content");
        buttonRegister.setText("Załóż Konto");
        buttonRegister.setWidth("min-content");
        buttonRegister.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        textInfo.setText(text);
        textInfo.setWidth("100%");
        textInfo.getStyle().set("font-size", "var(--lumo-font-size-m)");
        layoutColumn5.setSpacing(false);
        layoutColumn5.addClassName(Padding.XSMALL);
        layoutColumn5.getStyle().set("flex-grow", "1");
        layoutColumn5.getStyle().set("flex-grow", "1");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.CENTER);
        layoutColumn6.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("100%");
        layoutColumn6.getStyle().set("flex-grow", "1");
        getContent().add(layoutColumn3);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h2);
        layoutColumn2.add(textFieldLog);
        layoutColumn2.add(textFieldEmail);
        layoutColumn2.add(textFieldPass);
        layoutColumn2.add(buttonRegister);
        layoutColumn2.add(textInfo);
        layoutRow.add(layoutColumn5);
        getContent().add(layoutColumn6);

        buttonRegister.addClickListener(event -> {
            String login = textFieldLog.getValue();
            String email = textFieldEmail.getValue();
            String password = textFieldPass.getValue();

            boolean result = registration.registration(login, email, password);
            if(result) {
                textInfo.setText(" rejestracja udana !");

            } else {
                textInfo.setText(" rejestracja nieudana !");
            }
        });
    }
}


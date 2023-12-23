package com.kodilla.currencyexchangefront.Views;

import com.kodilla.currencyexchangefront.currency.Currency;
import com.kodilla.currencyexchangefront.calculateAmount.CurrencyCalculator;
import com.kodilla.currencyexchangefront.currency.CurrencyClient;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@PageTitle("Kalkulator Walut")
@Route(value = "cv")
@Uses(Icon.class)
public class CalculateView extends Composite<VerticalLayout> {
    private CurrencyClient client = new CurrencyClient();
    private CurrencyCalculator currencyCalculator = new CurrencyCalculator();
    private MainView mainView = new MainView();

    public CalculateView() throws URISyntaxException {


        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonRe = new Button();
        Button buttonLog = new Button();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Button buttonMV = new Button();
        Button buttonCalculateView = new Button();
        Button buttonResult = new Button();
        Grid<Currency> basicGrid = new Grid<>();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H2 h2 = new H2();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        NumberField numberField = new NumberField();
        ComboBox comboBox = new ComboBox();
        RadioButtonGroup radioGroup = new RadioButtonGroup();
        H2 resultCurr = new H2();
        getContent().setSpacing(false);
        getContent().setPadding(false);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.START);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.XSMALL);
        layoutRow.addClassName(LumoUtility.Padding.XSMALL);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.END);
        buttonRe.setText("Rejestracja");
        layoutRow.setAlignSelf(FlexComponent.Alignment.END, buttonRe);
        buttonRe.setWidth("min-content");
        buttonRe.setHeight("26px");
        buttonRe.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        buttonLog.setText("Logowanie");
        layoutRow.setAlignSelf(FlexComponent.Alignment.END, buttonLog);
        buttonLog.setWidth("min-content");
        buttonLog.setHeight("26px");
        buttonLog.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setSpacing(false);
        layoutColumn2.addClassName(LumoUtility.Padding.XSMALL);
        layoutColumn2.setWidth("min-content");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.CENTER);

        buttonMV.setText("Strona Główna");
        buttonMV.setWidth("100%");
        buttonMV.setMinWidth("11px");
        buttonMV.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        buttonCalculateView.setText("Kalkulator Waluty");
        buttonCalculateView.setWidth("100%");
        buttonCalculateView.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        buttonResult.setText("Oblicz");
        buttonResult.setWidth("100px");
        buttonResult.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        h2.setText("Kalkulator Waluty");
        h2.setWidth("max-content");
        layoutRow3.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow3);

        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, basicGrid);
        basicGrid.setWidth("1400px");
        basicGrid.setHeight("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        mainView.setGridSampleData(basicGrid);

        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        numberField.setLabel("Wpisz Kwotę");
        numberField.setWidth("min-content");
        comboBox.setLabel("Wybierz Walutę");
        layoutRow3.setAlignSelf(FlexComponent.Alignment.START, comboBox);
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        radioGroup.setLabel("Kupno/Sprzedaż");
        radioGroup.setWidth("min-content");
        radioGroup.setItems("buying", "selling");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        resultCurr.setText(" ");
        resultCurr.setWidth("max-content");
        getContent().add(layoutRow);
        layoutRow.add(buttonRe);
        layoutRow.add(buttonLog);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(buttonMV);
        layoutColumn2.add(buttonCalculateView);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(h2);
        layoutColumn3.add(layoutRow3);

        layoutRow3.add(numberField);
        layoutRow3.add(comboBox);
        layoutRow3.add(radioGroup);
        layoutRow3.add(buttonResult);
        layoutRow3.add(resultCurr);

        layoutColumn3.add(basicGrid);

        buttonLog.addClickListener(e -> {
            UI.getCurrent().navigate("login");
        });
        buttonRe.addClickListener(e -> {
            UI.getCurrent().navigate("registration");
        });
        buttonMV.addClickListener(e -> {
            UI.getCurrent().navigate("v1");
        });
        buttonCalculateView.addClickListener(e -> {
            UI.getCurrent().navigate("cv");
        });
        buttonResult.addClickListener(event -> {
            String code = (String) comboBox.getValue();
            String type = (String) radioGroup.getValue();
            double amount = numberField.getValue();

            double result = currencyCalculator.sendRequestCalculation(code, type, amount);
            resultCurr.setText(result + " " + code);
        });
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<Currency> currencyList = client.getCurrency();
        List<String> listCode = new ArrayList<>();

        for (int i = 0; i < currencyList.size(); i++) {
            String code = currencyList.get(i).getCode();
            listCode.add(code);
        }

        comboBox.setItems(listCode);
    }
}
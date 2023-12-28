package com.kodilla.currencyexchangefront.Views;

import com.kodilla.currencyexchangefront.currency.Currency;
import com.kodilla.currencyexchangefront.currency.CurrencyClient;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.util.List;


@PageTitle("Wymiana Walut")
@Route(value = "v1")
@Uses(Icon.class)
public class MainView extends Composite<VerticalLayout> {
    private CurrencyClient client = new CurrencyClient();

    public MainView() {

        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonRe = new Button();
        Button buttonLog = new Button();
        Button buttonCalculateView = new Button();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Button buttonMV = new Button();
        VerticalLayout layoutColumn3 = new VerticalLayout();

        Grid<Currency> basicGrid = new Grid<>();

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
        layoutRow.getStyle().set("flex-grow", "1");
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

        buttonCalculateView.setText("Kalkulator Waluty");
        buttonCalculateView.setWidth("100%");
        buttonCalculateView.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

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
        buttonMV.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, basicGrid);
        basicGrid.setWidth("1400px");
        basicGrid.setHeight("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        getContent().add(layoutRow);
        layoutRow.add(buttonRe);
        layoutRow.add(buttonLog);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(buttonMV);
        layoutColumn2.add(buttonCalculateView);
        layoutRow2.add(layoutColumn3);
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
    }

    public void setGridSampleData(Grid<Currency> basicGrid) {
        List<Currency> a = client.getCurrencyList();

        basicGrid.setItems(a);
        basicGrid.addColumn(Currency::getCode).setHeader("kod waluty");
        basicGrid.addColumn(Currency::getCurrency)
                .setHeader("nazwa waluty");
        basicGrid.addColumn(Currency::getBuying)
                .setHeader("kupno");
        basicGrid.addColumn(Currency::getSelling)
                .setHeader("sprzedaż");
    }
}
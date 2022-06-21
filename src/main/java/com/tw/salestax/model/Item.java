package com.tw.salestax.model;

import java.text.DecimalFormat;

public class Item {

    private final int quantity;
    private final String name;
    private final double amount;

    public final Category category;

    private double basicSalesTax;

    private double additionalSalesTax;

    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
        basicSalesTax = 0.0;
        additionalSalesTax = 0.0;
        category = new Category(name);
    }

    public boolean isImportedItem() {
        return name.contains("imported");
    }

    public void setSalestax(double salesTaxPercent) {

        basicSalesTax = formatDecimalDigits(amount * salesTaxPercent);
    }

    public void setAdditionalSalesTax(double importTaxPercent) {
        additionalSalesTax = formatDecimalDigits(amount * importTaxPercent);
    }

    public double getTotalSalesTax() {
        return basicSalesTax + additionalSalesTax;
    }

    public double getTotalPrice() {
        return formatDecimalDigits(amount + basicSalesTax + additionalSalesTax);
    }

    public String getDetails() {
        return quantity + " " + name + ": " + getTotalPrice();
    }

    private double formatDecimalDigits(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(value));
    }
}

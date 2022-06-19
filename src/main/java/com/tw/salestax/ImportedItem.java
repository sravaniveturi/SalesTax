package com.tw.salestax;

import java.text.DecimalFormat;

public class ImportedItem extends Item {

    private final double importTax;

    DecimalFormat df = new DecimalFormat("0.00");

    public ImportedItem(int quantity, String name, double amount) {
        super(quantity, name, amount);
        this.importTax = calcImportTax();
    }
    public double calcImportTax() {
        return Double.parseDouble((df.format(super.amount * 0.05)));
    }

    @Override
    public double calculateTax() {
        return super.calculateTax() + calcImportTax();
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = Double.parseDouble(df.format(
                super.amount + calculateTax()));
        return totalPrice;
    }
}

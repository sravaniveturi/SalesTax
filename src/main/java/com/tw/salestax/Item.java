package com.tw.salestax;

import java.text.DecimalFormat;

public class Item {

    private final int quantity;
    private final String name;
    protected final double amount;

    private final Category category;

    protected double basicSalesTax;
    DecimalFormat df = new DecimalFormat("0.00");


    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
        basicSalesTax = 0.0;
        category = new Category(name);
    }

    public double calculateBasicSalesTax() {
        double tax = 0.0;

        if (!category.isCategoryExemptFromSalesTax())
            tax = Double.parseDouble(df.format((amount * 10)/100));
        return tax;
    }

    public double getTotalPrice(){
        basicSalesTax =  calculateBasicSalesTax();
        double result = Double.parseDouble(df.format(amount + basicSalesTax));
        return result;
    }

    public String getDetails() {
        return String.valueOf(quantity)+" " +name+" : "+ getTotalPrice();
    }
}

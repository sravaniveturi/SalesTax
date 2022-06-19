package com.tw.salestax;

import java.text.DecimalFormat;
public class Item {

    private final int quantity;
    private final String name;
    protected final double amount;

    private final Category category;

    private double basicSalesTax;

    private double additionalSalesTax;
    DecimalFormat df = new DecimalFormat("0.00");


    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
        basicSalesTax = 0.0;
        additionalSalesTax = 0.0;
        category = new Category(name);
    }

    public double calculateSalesTax() {
        double tax = 0.0;

        if (!category.isCategoryExemptFromSalesTax()) {
            tax = (amount * 10) / 100;
            tax = Math.ceil(tax / 0.05) * 0.05;
        }
        return tax;
    }

    public boolean isImportedItem(){
        return name.contains("imported");
    }

    public double calculateImportDutyTax(){
        if(this.isImportedItem()){
            return Double.parseDouble(df.format(amount * 0.05));
        }
        return 0.0;
    }

    public double getTotalPrice() {
        basicSalesTax = calculateSalesTax();
        additionalSalesTax = calculateImportDutyTax();
        return amount + basicSalesTax + additionalSalesTax;
    }

    public String getDetails() {
        return quantity + " " + name + ": " + getTotalPrice();
    }
}

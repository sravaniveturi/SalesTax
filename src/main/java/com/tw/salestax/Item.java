package com.tw.salestax;

import java.util.Arrays;
import java.util.ResourceBundle;

public class Item {

    private final int quantity;
    private final String name;
    private final double amount;

    private double salestax;

    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
        salestax = 0.0;
    }

    public double calculateSalesTax() {
        if(!checkItemExemptFromSalesTax(this))
        this.salestax = this.amount * 0.01;
        return this.salestax;
    }

    public boolean checkItemExemptFromSalesTax(Item item) {
        final ResourceBundle bundle = ResourceBundle.getBundle("message");
        String[] exemptString = bundle.getString("items_exempt").split(",");
        System.out.println("string: "+ exemptString[0]);
        for(String exemptItem: exemptString) {
            if (item.name.contains(exemptItem)) {
                return true;
            }
        }
        return false;
    }
}

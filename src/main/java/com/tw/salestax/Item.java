package com.tw.salestax;

import java.util.Arrays;
import java.util.ResourceBundle;

public class Item {

    private final int quantity;
    private final String name;
    private final double amount;

    private Category category;
    private double salestax;

    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
        salestax = 0.0;
        category = new Category(name);
    }

    public double calculateSalesTax() {
        if (!category.isCategoryExemptFromSalesTax())
            this.salestax = amount * 0.01;
        return this.salestax;
    }


}

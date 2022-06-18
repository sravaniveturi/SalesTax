package com.tw.salestax;

public class Item {

    private final int quantity;
    private final String name;
    private final double amount;
    private double salestax;

    public Item(int quantity, String name, double amount) {
        this.quantity = quantity;
        this.name = name;
        this.amount = amount;
    }

    public double calculateSalesTax() {
        this.salestax = this.amount * 0.01;
        return this.salestax;
    }
}

package com.tw.salestax;

import com.tw.salestax.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SalesTax {

    private final List<Item> items;
    private final SalesTaxCalculator calculator;

    public SalesTax() {
        items = new ArrayList<>();
        calculator = new SalesTaxCalculator();
    }

    public void addItem(Item item) {
        items.add(item);
        calculator.calculateTax(item);
    }

    public Receipt generateReceipt() {
        Receipt receipt = new Receipt(items);
        receipt.getReceiptDetails();
        return receipt;
    }
}




package com.tw.salestax;

public class ImportedItem  extends Item{

    private final double importTax;

    public ImportedItem(int quantity, String name, double amount) {
        super(quantity, name, amount);
        super.basicSalesTax = amount * 0.10;
        this.importTax =  amount * 0.05;
    }

    @Override
    public double getTotalPrice() {
        return  super.amount + super.basicSalesTax + importTax;
    }
}

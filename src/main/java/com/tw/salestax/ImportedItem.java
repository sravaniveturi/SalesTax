package com.tw.salestax;

public class ImportedItem  extends Item{

    private final double importTax;

    public ImportedItem(int quantity, String name, double amount) {
        super(quantity, name, amount);
        super.basicSalesTax = 0.10D;
        this.importTax =  amount * 0.05D;
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() + importTax;
    }
}

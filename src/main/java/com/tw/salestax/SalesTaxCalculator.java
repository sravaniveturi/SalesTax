package com.tw.salestax;

import com.tw.salestax.model.Item;

public class SalesTaxCalculator {
    private final double SALES_TAX_PERCENT = .10;

    private final double IMPORT_TAX_PERCENT = .05;

    public void calculateTax(Item item) {
        if (!item.category.isCategoryExempt()) {
            item.setSalestax(SALES_TAX_PERCENT);
        }
        if (item.isImportedItem()) {
            item.setAdditionalSalesTax(IMPORT_TAX_PERCENT);
        }
    }

}

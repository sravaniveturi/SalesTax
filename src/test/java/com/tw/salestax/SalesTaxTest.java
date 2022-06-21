package com.tw.salestax;

import com.tw.salestax.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SalesTaxApplicationTest {

    List<Item> itemsList;
    SalesTax salesTax;

    @BeforeEach
    void setUp() {
        itemsList = new ArrayList<>();
        salesTax = new SalesTax();
    }

    @Test
    void checkReceiptForAddNormalItems() {
        Item book = new Item(1, "book", 12.49);
        Item musicCD = new Item(1, "musicCD", 14.99);
        Item chocolateBar = new Item(1, "chocolate bar", 0.85);

        salesTax.addItem(book);
        salesTax.addItem(musicCD);
        salesTax.addItem(chocolateBar);

        salesTax.generateReceipt();
    }

    @Test
    void checkReceiptForAddImportedItems() {
        Item importedChocolate = new Item(1, "imported box of chocolates", 10.0);
        Item importedPerfume = new Item(1, "imported bottle of perfume", 47.50);

        salesTax.addItem(importedChocolate);
        salesTax.addItem(importedPerfume);

        salesTax.generateReceipt();
    }

    @Test
    void checkReceiptForNormalAndImportedItems() {
        Item importedPerfume = new Item(1, "imported bottle of perfume", 27.99);
        Item perfume = new Item(1, "bottle of perfume", 18.99);
        Item headachePills = new Item(1, "packet of headache pills", 9.75);
        Item importedChocolate = new Item(1, "imported box of chocolates", 11.25);

        salesTax.addItem(importedPerfume);
        salesTax.addItem(perfume);
        salesTax.addItem(headachePills);
        salesTax.addItem(importedChocolate);

        salesTax.generateReceipt();

    }
}
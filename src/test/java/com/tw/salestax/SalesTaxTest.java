package com.tw.salestax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesTaxTest {

    List<Item> itemsList;
    Item book, chocolateBar, musicCD;
    SalesTax salesTexAppl;

    @BeforeEach
    void setUp() {
        itemsList = new ArrayList<>();
    }

    @Test
    void checkReceiptForAddNormalItems() {
        book = new Item(1, "book", 12.49);
        musicCD = new Item(1, "musicCD", 14.99);
        chocolateBar = new Item(1, "chocolate bar", 0.85);

        itemsList.add(book);
        itemsList.add(musicCD);
        itemsList.add(chocolateBar);
        salesTexAppl = new SalesTax(itemsList);

        assertTrue(itemsList.contains(book));
        salesTexAppl.sendReceipt();
    }

    @Test
    void checkReceiptForAddImportedItems() {
        Item importedChocolate = new Item(1, "imported box of chocolates", 10);
        Item importedperfume = new Item(1, "imported bottle of perfume", 47.50);

        itemsList.add(importedChocolate);
        itemsList.add(importedperfume);
        salesTexAppl = new SalesTax(itemsList);

        salesTexAppl.sendReceipt();
    }

    @Test
    void checkReceiptForNormalAndImportedItems(){
        Item importedperfume = new Item(1, "imported bottle of perfume", 27.99);
        Item perfume = new Item(1, "bottle of perfume", 18.99);
        Item heachepills  = new Item(1,"packet of headache pills", 9.75);
        Item importedChocolate = new Item(1, "imported box of chocolates", 11.25);

        itemsList.add(importedperfume);
        itemsList.add(perfume);
        itemsList.add(heachepills);
        itemsList.add(importedChocolate);
        salesTexAppl = new SalesTax(itemsList);

        salesTexAppl.sendReceipt();
    }
}
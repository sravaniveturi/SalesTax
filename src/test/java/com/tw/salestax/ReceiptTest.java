package com.tw.salestax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    List<Item> itemsList;
    Item book, chocolateBar, musicCD;
    Receipt receipt;

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
        receipt = new Receipt(itemsList);

        assertTrue(itemsList.contains(book));
        receipt.generateReceipt();
    }

    @Test
    void checkReceiptForAddImportedItems() {
        Item importedChocolate = new Item(1, "imported box of chocolates", 10);
        Item importedperfume = new Item(1, "imported bottle of perfume", 47.50);

        itemsList.add(importedChocolate);
        itemsList.add(importedperfume);
        receipt = new Receipt(itemsList);

        receipt.generateReceipt();
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
        receipt = new Receipt(itemsList);

        receipt.generateReceipt();
    }
}
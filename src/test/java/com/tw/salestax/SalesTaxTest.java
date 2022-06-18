package com.tw.salestax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesTaxTest {

    List<Item> itemsList;
    Item book, chocolateBar, musicCD;

    @BeforeEach
    void setUp(){
        itemsList = new ArrayList<>();
        book = new Item(1,"book",12.49);
        musicCD = new Item(1,"musicCD", 14.99);
        chocolateBar = new Item(1,"chocolate bar",0.85);

        itemsList.add(musicCD);
        itemsList.add(chocolateBar);
    }

    @Test
    void addItems() {
        itemsList.add(book);
        assertTrue(itemsList.contains(book));
    }

    @Test
    void displayItems() {
        itemsList.add(book);
        SalesTax salesTexAppl = new SalesTax(itemsList);
        salesTexAppl.displayItems();
    }
}
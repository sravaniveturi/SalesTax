package com.tw.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    void testSalestaxIsCalculated() {
        Item item1 = new Item(1, "table", 12);
        assertEquals(0.12, item1.calculateSalesTax());
    }

    @Test
    void testSalestaxIsZeroForItemsExemptFromTax() {
        Item book = new Item(1, "book", 12);
        Item chocolate = new Item(1, "chocolates", 20);
        Item headachePills = new Item(1, "headache pills", 30);
        assertEquals(0, book.calculateSalesTax());
    }

}

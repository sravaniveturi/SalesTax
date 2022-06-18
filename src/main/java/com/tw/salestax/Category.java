package com.tw.salestax;

import java.util.Arrays;
import java.util.ResourceBundle;

public class Category {

    private final String name;
    final ResourceBundle bundle = ResourceBundle.getBundle("message");

    public Category(String itemName) {
        name = getCategoryName(itemName);
    }

    public boolean isCategoryExemptFromSalesTax() {
        String[] exemptString = bundle.getString("categories_exempt").split(",");

        for (String exemptCategory : exemptString) {
            if (name.contains(exemptCategory)) {
                return true;
            }
        }
        return false;
    }

    private String getCategoryName(String itemName) {
        String categoryName = "default";
        String[] bookItems = bundle.getString("book_items").split(",");
        String[] foodItems = bundle.getString("food_items").split(",");
        String[] medicalItems = bundle.getString("medical_items").split(",");

        if (Arrays.stream(bookItems).anyMatch(itemName::contains))
            categoryName = "book";
        if (Arrays.stream(foodItems).anyMatch(itemName::contains))
            categoryName = "food";
        if (Arrays.stream(medicalItems).anyMatch(itemName::contains))
            categoryName = "medical";

        return categoryName;
    }
}

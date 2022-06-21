package com.tw.salestax;

import com.tw.salestax.model.Item;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Receipt {

    private final List<Item> itemsList;

    private double totalSalesTax, totalPrice;

    public Receipt(List<Item> items) {
        itemsList = items;
        totalPrice = 0.0;
        totalSalesTax = 0.0;
    }

    public void getReceiptDetails() {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsList) {
            sb.append(item.getDetails()).append("\n");
            totalSalesTax += item.getTotalSalesTax();
            totalPrice += item.getTotalPrice();
        }
        sb.append("Sales Tax: ").append(roundOff(totalSalesTax)).append("\n")
                .append("Total: ").append(totalPrice);
        sendReceipt(sb.toString());
    }

    public void sendReceipt(String stringDetails) {
        File outputFile = new File("receipt.txt");
        try (FileWriter fw = new FileWriter(outputFile);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(stringDetails);
            bw.newLine();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private double roundOff(double sum) {
        return Math.ceil(sum * 20) / 20;
    }


}

package  com.tw.salestax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class SalesTax {

    private  List<Item> itemsList;

    public SalesTax(List<Item> items) {
        itemsList = items;
    }

    public void addItem(Item item){
        if(item != null) {
            itemsList.add(item);
        }
    }

    public double getTotalSalesTax(){
        double sum =0;

        for (Item item : itemsList) {
            sum += (item.calculateSalesTax() + item.calculateImportDutyTax());
        }
        return formatDecimalDigits(sum);
    }

    public double getTotalPrice(){
        double sum =0;

        for (Item item : itemsList) {
            sum += item.getTotalPrice();
        }
        return formatDecimalDigits(sum);
    }

    private double formatDecimalDigits(double sum) {
        return Math.ceil(sum * 20)/20;
    }

    public void sendReceipt(){
        StringBuilder sb = new StringBuilder();
        for(Item item: itemsList){
            sb.append(item.getDetails()).append("\n");
        }
        sb.append("Sales Tax: ").append(getTotalSalesTax()).append("\n")
                .append("Total: ").append(getTotalPrice());

        File outputFile = new File("receipt.txt");
        try (FileWriter fw = new FileWriter(outputFile);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(sb.toString());
            bw.newLine();
        }catch(Exception e){
            e.getMessage();
        }
    }

}

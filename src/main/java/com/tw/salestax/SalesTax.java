package  com.tw.salestax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class SalesTax {

    private final List<Item> itemsList;

    DecimalFormat df;
    public SalesTax(List<Item> items) {
        this.itemsList = items;
        df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
    }

    public void addItems(Item item){
        if(item != null) {
            itemsList.add(item);
        }
    }

    public double getTotalSalesTax(){
        double sum =0;

        for (Item item : itemsList) {
            sum += item.calculateTax();
        }
        double result = Double.parseDouble(df.format(sum));
        return result;
    }

    public double getTotalPrice(){
        double sum =0;

        for (Item item : itemsList) {
            sum += item.getTotalPrice();
        }
        double result = Double.parseDouble(df.format(sum));
        return  result;
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

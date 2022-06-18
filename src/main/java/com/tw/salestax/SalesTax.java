package  com.tw.salestax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SalesTax {

    private List<Item> itemsList;

    DecimalFormat df = new DecimalFormat("0.00");
    public SalesTax(List<Item> items) {
        this.itemsList = items;
    }

    public void addItems(Item item){
        if(item != null) {
            itemsList.add(item);
        }
    }

    public double getTotalSalesTax(){
        double sum =0;
        ListIterator<Item> iterator = itemsList.listIterator();

        while( iterator.hasNext()){
            sum += iterator.next().calculateBasicSalesTax();
        }
        double result = Double.parseDouble(df.format(sum));
        return result;
    }

    public double getTotalPrice(){
        double sum =0;
        ListIterator<Item> iterator = itemsList.listIterator();


        while( iterator.hasNext()){
            sum += iterator.next().getTotalPrice();
        }
        double result = Double.parseDouble(df.format(sum));
        return  result;
    }

    public void displayItems(){
        StringBuilder sb = new StringBuilder();
        for(Item item: itemsList){
            sb.append(item.getDetails()).append("\n");
        }
        sb.append("Sales Tax: ").append(getTotalSalesTax()).append("\n")
                .append("Total: ").append(getTotalPrice());

        File outputFile = new File("output.txt");
        try (FileWriter fw = new FileWriter(outputFile);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(sb.toString());
            bw.newLine();
        }catch(Exception e){
            e.getMessage();
        }
    }

}

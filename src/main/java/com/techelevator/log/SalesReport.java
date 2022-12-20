package com.techelevator.log;

import com.techelevator.items.Item;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SalesReport {

    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private List<Item> sales;
    private double revenue;
    private static int MAX_STOCK=5;

    public SalesReport(List<Item> sales) {
        this.sales = sales;
        this.revenue = 0.0;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void generateSalesReport(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm");
        Calendar cal = Calendar.getInstance();
        String formattedDate = dateFormat.format(cal.getTime());

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(formattedDate + "_Sales.txt", true))) {
            for (Item item:sales) {
                logWriter.println(item.getName() + " | " + (MAX_STOCK-item.getQuantity()));
            }
            logWriter.println("**TOTAL SALES** $" + decimalFormat.format(revenue));
        } catch (FileNotFoundException e) {
            System.err.println("Error: Sales file not found");
        }
    }
}


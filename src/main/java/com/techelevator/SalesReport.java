package com.techelevator;

import com.techelevator.items.Item;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SalesReport {

        private List<Item> sales;
        private double revenue;
        private static int MAX_STOCK=5;

    public SalesReport(List<Item> sales) throws IOException {
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
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String formattedDate = dateFormat.format(cal.getTime());

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(formattedDate + " Sales.txt", true))) {
            for (Item item:sales) {
                logWriter.println(item.getName() + " | " + (MAX_STOCK-item.getQuantity()));
            }
            logWriter.println("**TOTAL SALES** $" + revenue);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Sales file not found");
        }

    }
    }


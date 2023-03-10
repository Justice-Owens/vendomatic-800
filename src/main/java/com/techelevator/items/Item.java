package com.techelevator.items;

import java.text.DecimalFormat;
import java.text.Format;

public class Item {

    //VARIABLES AND OBJECTS
    private static final int MAX_QUANTITY = 5;
    private String name, selection;
    private double price;
    private int quantity;
    protected DecimalFormat decimalFormat = new DecimalFormat("0.00");

    //CONSTRUCTOR
    public Item(String selection, String name, double price) {
        this.selection = selection;
        this.name = name;
        this.price = price;
        this.quantity = MAX_QUANTITY;

    }


    //GETTERS AND SETTERS
    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //METHODS FOR ITEM FUNCTIONALITY
    public String dispense(double balance){ // added parameter to allow for display of balance AT
        return "";
    }


    public String display(){
        if(quantity > 0) {
            return selection + "  |  " + name + "  |  $" + decimalFormat.format(price) + "  |  " + quantity;
        } else {
            return selection + "  |  SOLD OUT";
        }
    }
}

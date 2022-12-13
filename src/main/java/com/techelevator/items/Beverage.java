package com.techelevator.items;

public class Beverage extends Item{

    public Beverage(String selection, String name, double price) {
        super(selection, name, price);
    }

   @Override
    public String dispense(double balance) {
        return super.getName() + "  |  Price $" + decimalFormat.format(super.getPrice()) + " | Balance Remaining $"
                + decimalFormat.format(balance) + "\n Glug Glug, Yum!"; // AT

   }


}

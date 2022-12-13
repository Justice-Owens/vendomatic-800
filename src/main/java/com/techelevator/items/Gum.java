package com.techelevator.items;

public class Gum extends Item{

    public Gum(String selection, String name, double price) {
        super(selection, name, price);
    }

    @Override
    public String dispense(double balance) {
        return super.getName() + "  |  Price $" + decimalFormat.format(super.getPrice()) + " | Balance Remaining $"
                + decimalFormat.format(balance) + "\n Chew Chew, Yum!"; // AT

    }


}

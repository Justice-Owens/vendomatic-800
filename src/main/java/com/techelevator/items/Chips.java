package com.techelevator.items;

public class Chips extends Item{

    public Chips(String selection, String name, double price) {
        super(selection, name, price);
    }

    @Override
    public String dispense(double balance) {
        return super.getName() + "  |  Price $" + decimalFormat.format(super.getPrice()) + " | Balance Remaining $"
                + decimalFormat.format(balance) + "\n Crunch Crunch, Yum!"; // AT

    }


}

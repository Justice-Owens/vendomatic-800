package com.techelevator.items;

public class Candy extends Item{


    public Candy(String selection, String name, double price) {
        super(selection, name, price);
    }

    @Override
    public String dispense(double balance) {
        return super.getName() + "  |  Price $" + decimalFormat.format(super.getPrice()) + " | Balance Remaining $"
                + decimalFormat.format(balance) + "\n Munch Munch, Yum!"; // AT

    }


}

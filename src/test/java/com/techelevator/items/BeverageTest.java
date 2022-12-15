package com.techelevator.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeverageTest {
    Beverage test = new Beverage("Selection", "Name", 1.00);

    @Test
    public void dispenseTest(){
        assertEquals("Input: dispense(0.50)", "Name  |  Price $1.00 | Balance Remaining $0.50\n Glug Glug, Yum!", test.dispense(0.50));
    }
}
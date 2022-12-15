package com.techelevator.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChipsTest {
    Chips test = new Chips("Selection", "Name", 1.00);

    @Test
    public void dispenseTest(){
        assertEquals("Input: dispense(0.50)", "Name  |  Price $1.00 | Balance Remaining $0.50\n Crunch Crunch, Yum!", test.dispense(0.50));
    }
}

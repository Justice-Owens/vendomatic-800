package com.techelevator.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    Item test = new Item("Selection", "Name", 0.75);

    @Test
    public void displayTest(){
        assertEquals("Input: display()", "Selection  |  Name  |  $0.75  |  5", test.display());
    }

}
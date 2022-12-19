package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineCLITest {
    Menu testMenu = new Menu(System.in, System.out);
    VendingMachineCLI test = new VendingMachineCLI(testMenu);

    @Test
    public void feedMoneyTest(){
        test.feedMoney("$5");
        Assert.assertTrue("Input: feedMoney(\"$5\")", test.getBalance() == 5);
    }

    @Test
    public void purchaseTest(){
        test.setup();
        test.setBalance(1.45);
        assertEquals("Input: purchase(\"A2\")", "Stackers  |  Price $1.45 | Balance Remaining $0.00\n Crunch Crunch, Yum!", test.purchase("A2"));
        assertEquals("Input: purchase(\"\")", "*** Invalid Selection ***", test.purchase(""));
        assertEquals("Input: purchase(\"A3\")", "Insufficient Balance", test.purchase("A3"));

        test.setBalance(100);
        test.purchase("A2");
        test.purchase("A2");
        test.purchase("A2");
        test.purchase("A2");

        assertEquals("Input: A2.quantity == 0 -> purchase(\"A2\")", "That item is sold out. Please make another selection.", test.purchase("A2"));
    }

    @Test
    public void finishTransactionTest(){
        test.setBalance(0.50);
        assertEquals("Input: finishTransaction(0.50)", "Here is your change >>>\n" +
                "2 quarters\n" +
                "0 dimes\n" +
                "0 nickels", test.finishTransaction());
        test.setBalance(0.00);
        assertEquals("Input: finishTransaction(0.00)", "Here is your change >>>\n" +
                "0 quarters\n" +
                "0 dimes\n" +
                "0 nickels", test.finishTransaction());
    }
}

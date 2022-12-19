package com.techelevator.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VMLogger {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public VMLogger (){}

    public void logTransaction(String transactionMessage, double amount, double newBalance) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Calendar cal = Calendar.getInstance();
        String formattedDate = dateFormat.format(cal.getTime());

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream("Log.txt", true))) {
            logWriter.println(formattedDate + " " + transactionMessage + " $" +decimalFormat.format(amount) + " $" + decimalFormat.format(newBalance));
        } catch (FileNotFoundException e) {
            System.err.println("Error: Log file not found");
        }
    }
}

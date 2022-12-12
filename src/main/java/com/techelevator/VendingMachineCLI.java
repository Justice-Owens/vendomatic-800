package com.techelevator;

import com.techelevator.items.*;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

//TODO FINISH PURCHASE MENU PROCESSES
//TODO OVERRIDE METHODS IN ITEM CHILD CLASSES
//TODO ADD LOGGING FUNCTIONALITY
//TODO OPTIONAL SALES REPORT FUNCTION

public class VendingMachineCLI {

	//CONSTANTS
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH};
	private static final String FEED_MONEY_MENU_OPTION_ONE = "$1";
	private static final String FEED_MONEY_MENU_OPTION_FIVE = "$5";
	private static final String FEED_MONEY_MENU_OPTION_TEN = "$10";
	private static final String[] FEED_MONEY_MENU_OPTIONS = {FEED_MONEY_MENU_OPTION_ONE, FEED_MONEY_MENU_OPTION_FIVE, FEED_MONEY_MENU_OPTION_TEN};

	//VARIABLES
	private Menu menu;
	private List<Item> inventory = new ArrayList<>();
	private double balance;
	private double revenue;
	private String[] menuSelectionOptions;
	private DecimalFormat decimalFormat = new DecimalFormat("0.00");
	private Scanner userIn = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.balance = 0;
		this.revenue = 0;
	}

	public void run() {

		setup();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					System.out.print(System.lineSeparator() + "Current Money Provided: $" + decimalFormat.format(balance));
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				switch(choice){
					case PURCHASE_MENU_OPTION_FEED_MONEY:
						choice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
						feedMoney(choice);
						break;
					case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
						displayInventory();
						String selection = userIn.nextLine();
						purchase(selection);
						break;
					case PURCHASE_MENU_OPTION_FINISH:
						break;
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}
		}
	}

	//SCANS CSV INVENTORY FILE AND GENERATES NEW INVENTORY ON RUN
	public void setup(){
		try(Scanner source = new Scanner(new File("vendingmachine.csv"))) {
			while (source.hasNextLine()) {
				String line = source.nextLine();
				String[] item = line.split("\\|");
				String itemType = item[3];


				switch (itemType) {
					case "Chip":
						inventory.add(new Chips(item[0], item[1], Double.parseDouble(item[2])));
						break;
					case "Candy":
						inventory.add(new Candy(item[0], item[1], Double.parseDouble(item[2])));
						break;
					case "Drink":
						inventory.add(new Beverage(item[0], item[1], Double.parseDouble(item[2])));
						break;
					case "Gum":
						inventory.add(new Gum(item[0], item[1], Double.parseDouble(item[2])));
						break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		menuSelectionOptions = new String[inventory.size()];
		for(int i = 0; i < menuSelectionOptions.length; i++){
			menuSelectionOptions[i] = inventory.get(i).display();
		}
	}

	//ADDS MONEY TO VENDING MACHINE BALANCE
	public void feedMoney(String choice){
		switch(choice){
			case FEED_MONEY_MENU_OPTION_ONE:
				balance +=1;
				break;
			case FEED_MONEY_MENU_OPTION_FIVE:
				balance +=5;
				break;
			case FEED_MONEY_MENU_OPTION_TEN:
				balance +=10;
				break;
		}
	}

	//DISPLAYS INVENTORY IN CONSOLE
	public void displayInventory(){
		for(Item item: inventory){
			System.out.println(item.display());
		}
	}

	//SUBTRACTS THE VALUE OF THE ITEM FROM THE BALANCE FED INTO THE MACHINE AND CALLS THE ITEMS DISPENSE() METHOD WHICH WILL PRINT
	//TO THE CONSOLE AN ITEM SPECIFIC PHRASE.
	public void purchase(String selection){
		for(Item item: inventory){
			if(item.getSelection().equals(selection)){
				balance -= item.getPrice();
				revenue =+ item.getPrice();
				item.dispense();
			}
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

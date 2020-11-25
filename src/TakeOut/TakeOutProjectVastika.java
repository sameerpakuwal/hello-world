package TakeOut;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TakeOutProjectVastika {
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void dispalyMainMenu() {

		System.out.println("1. Italian");
		System.out.println("2. Chinese");
		System.out.println("3. American");

	}

	public static void displayItalianFoodMenu() {
		System.out.println("1. Lasagna Tray - Feeds 5 - 17.99\n" + "2. Pizza Pack - Feeds 7 - 15.99\n"
				+ "3. Gazpacho Soup, salad and bread sticks pack - Feeds 4 - 12.99");

	}

	public static void displayChineseFoodMenu() {
		System.out.println("1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - 18.99\n"
				+ "2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - 18.99\n"
				+ "3. Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - 10.99");
	}

	public static void displayAmericanFoodMenu() {
		System.out.println("1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - 21.99\n"
				+ "2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 -\n"
				+ "22.99\n" + "3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - 26.99");
	}

	public static int determineTrays(int people, int feeds) {
		int tray = people/feeds;
		if (people%feeds==0) 
		{
		return tray;}
		else return tray+1;
		
	}

	public static double getSubtotal(double price, int trays) {
		double subtotal = trays * price;
		return subtotal;
	}

	public static double getTax(double subtotal, double taxrate) {
		double tax = subtotal * (taxrate / 100);
		return tax;
	}

	public static double getTip(double subtotal, double tipRate) {
		double tip = subtotal * (tipRate / 100);
		return tip;
	}

	public static double getGrandTotal(double subtotal, double tax, double tip) {
		double grandTotal = subtotal + tax + tip;
		return grandTotal;
	}

	public static double pricePerPerson(double grandTotal, int people) {
		double pricePerPerson = grandTotal / people;
		return pricePerPerson;

	}

	public static int determineLeftOvers(int feeds, int trays, int people) {
		int leftOvers = (trays * feeds) - people;

		return leftOvers;

	}

	public static void main(String[] args) {

		int feeds = 0;
		double price = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("How many people in this order?");
		int people = input.nextInt();
		if (people < 10) {
			System.out.println("Order size of less than 10 people. Cannot Prooceed.");
			System.exit(1);
		}
		System.out.println("Great!!");
		System.out.println("What type of food would you like to order?");

		
		String c = null;
		
		
		
		do {
			dispalyMainMenu();
			System.out.println("Enter 'i' for Italian");
			System.out.println("Enter 'c' for Chinese");
			System.out.println("Enter 'a' for American");

			char choice = input.next().charAt(0);
			
			switch (choice) {
			case 'i':
				System.out.println("You chose Italian food.");
				displayItalianFoodMenu();
				System.out.println("Which food tray would you like to order?");
				System.out.println("Enter choice number 1, 2 or 3.");
				int choice1 = input.nextInt();

				if (choice1 == 1) {
					feeds = 5;
					price = 17.99;
					
				}

				if (choice1 == 2) {
					feeds = 7;
					price = 15.99;
					

				}
				if (choice1 == 3) {
					feeds = 7;
					price = 15.99;
					
				}

				break;

			case 'c':
				System.out.println("You chose Chinese food.");
				displayChineseFoodMenu();
				System.out.println("Which food tray would you like to order?");
				System.out.println("Enter choice number 1, 2 or 3.");
				int choice2 = input.nextInt();

				if (choice2 == 1) {
					feeds = 7;
					price = 18.99;
					
				}

				if (choice2 == 2) {
					feeds = 7;
					price = 18.99;
					
					
				}
				if (choice2 == 3) {
					feeds = 5;
					price = 10.99;
					
				}
				break;

			case 'a':
				System.out.println("You chose American food.");
				displayAmericanFoodMenu();
				System.out.println("Which food tray would you like to order?");
				System.out.println("Enter choice number 1, 2 or 3.");
				int choice3 = input.nextInt();

				if (choice3 == 1) {
					feeds = 8;
					price = 21.99;
					
				}

				if (choice3 == 2) {
					feeds = 5;
					price = 22.99;
					
				}
				if (choice3 == 3) {
					feeds = 10;
					price = 26.99;
					
				}

				break;
				
				
			default:
				System.out.println("Wrong choice! ");
				System.exit(0);
			}
			
			System.out.println("Do you want to order again: if yes press y if no press n");
			c = input.next();
		} while (c.equalsIgnoreCase("y"));
		System.out.println("New feed is"+feeds);

		int trays = determineTrays(people, feeds);

		System.out.println();

		System.out.println("The output is as below :");
		System.out.println();

		System.out.println("You need " + trays + " trays.");
		System.out.println("Feeds: " + feeds);

		double subTotal = getSubtotal(price, trays);
		System.out.println("Price for " + people + "people (" + trays + " trays) : $" + subTotal);

		final double taxRate = 7;
		double tax = getTax(subTotal, taxRate);
		System.out.println("Tax : $" + df2.format(tax));

		final int tipRate = 15;
		double tip = getTip(subTotal, tipRate);
		System.out.println("Tip :$ " + df2.format(tip));

		double grandTotal = getGrandTotal(subTotal, tax, tip);
		System.out.println("Total (food,tax,tip) :$ " + df2.format(grandTotal));

		double pricePerPerson = pricePerPerson(grandTotal, people);
		System.out.println("Price per person :$" + df2.format(pricePerPerson));

		int leftOvers = determineLeftOvers(feeds, trays, people);
		System.out.println("Left over servings for the delivery person :" + leftOvers);
	}
}

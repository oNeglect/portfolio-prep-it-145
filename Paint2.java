//Lawrence Arundel 6-3 Assignment

import java.util.Scanner;

public class Paint2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		double wallHeight = 0.0;
		double wallWidth = 0.0;
		double wallArea = 0.0;
		double gallonsPaintNeeded = 0.0;
		int cansNeeded = 0;
		boolean isValid = false;
		final double squareFeetPerGallons = 350.0;

		// Implement a do-while loop to ensure input is valid
		// Prompt user to input wall's height
		do {
			isValid = true;
			System.out.println("Enter wall height (feet): ");
			if (scnr.hasNextDouble()) {
				wallHeight = scnr.nextDouble();
				if (wallHeight <= 0) {
					System.out.println("Invalid Input, numbers only greater than zero.");
					isValid = false;
				}
			} else {
				System.out.println("Invalid Input " + scnr.nextLine());
				isValid = false;
			}
		} while (!isValid);




		// Implement a do-while loop to ensure input is valid
		// Prompt user to input wall's width
		do {
			isValid = true;
			System.out.println("Enter wall width (feet): ");
			if (scnr.hasNextDouble()) {
				wallWidth = scnr.nextDouble();
				if (wallWidth <= 0) {
					System.out.println("Invalid Input, numbers only greater than zero.");
					isValid = false;
				}
			} else {
				System.out.println("Invalid Input " + scnr.nextLine());
				isValid = false;
			}
		} while (!isValid);

		// Calculate and output wall area
		wallArea = wallHeight * wallWidth;
		System.out.println("Wall area: " + wallArea +   " square feet");

		// Calculate and output the amount of paint (in gallons) needed to paint the wall
		gallonsPaintNeeded = wallArea/squareFeetPerGallons;
		System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
		System.out.println("Cans needed: "+ Math.ceil(gallonsPaintNeeded) + " can(s)");
	}
}

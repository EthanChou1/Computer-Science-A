/**	The RoachMotel class uses user input to determine the number of roaches
 *	in a lab and kitchen, and will double the population. After doubling
 *	the population, it will use pesticide to decrease the population.
 *	@author Ethan Chou
 *	Collaborators: none
 *	Teacher Name: Mrs. Bailey
 *	Period 1
 *	Due Date: 9-30-2019
 */

import java.util.Scanner;

public class RoachMotel
{
	public static void main(String[] args)
	{
		/*
		 * 70-point version
		 */

		// Using the default constructor, declare and instantiate a
		// RoachPopulation object to represent the roach population
		// in the computer lab.
		// Display the initial population using the accessor method.
		RoachPopulation roachLab = new RoachPopulation();
		System.out.print("My lab has an initial population of ");
		System.out.print(roachLab.getRoaches() + " roaches.");
		System.out.println();
		System.out.println();

		// Using the starting population provided by the user and 1-parameter
		// constructor, declare and instantiate a RoachPopulation object to
		// represent the roach population in your kitchen.
		// Display initial population using the accessor method.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter starting population of the kitchen (an integer): ");
		int initialPopulation = scan.nextInt();
		RoachPopulation roachKitchen = new RoachPopulation(initialPopulation);
		System.out.print("My kitchen has an initial population of " );
		System.out.print(roachKitchen.getRoaches() + " roaches.");
		System.out.println();
		System.out.println();



		/*
		 * 85-point version
		 */

		// Wait for the kitchen population to double and display the results
		System.out.println("Waiting for the kitchen population to grow...");
		roachKitchen.waitForDoubling();
		System.out.println("My kitchen now has " + roachKitchen.getRoaches() + " roaches.");
		System.out.println();

		// Wait for the lab population to double and display the results
		System.out.println("Waiting for the lab population to grow...");
		roachLab.waitForDoubling();
		System.out.println("My lab now has " + roachLab.getRoaches() + " roaches.");
		System.out.println();



		/*
		 * 100-point version (uncomment section below)
		 */

		// Spray insecticide in the kitchen and display the results
		System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
		double kitchenSpray = scan.nextDouble();
		System.out.print("My kitchen now has ");
		System.out.print((roachKitchen.getRoaches() - roachKitchen.spray(kitchenSpray)));
		System.out.print(" roaches");
		System.out.print(" after killing " + roachKitchen.getRoaches() + " roaches.");
		System.out.println();
		System.out.println();



		// Spray insecticide in the lab and display the results
		System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
		double labSpray = scan.nextDouble();
		System.out.print("My lab now has ");
		System.out.print((roachLab.getRoaches() - roachLab.spray(labSpray)));
		System.out.print(" roaches");
		System.out.print(" after killing " + roachLab.getRoaches() + " roaches.");
		System.out.println();
		System.out.println();


	}
}


/**
 *	The DayOfGiving class scans a file and creates an array consisting of the
 *	donor's name, recipient's name, donor's age, and amount. It also calculates the
 *	average of all the donations, find the dodnor who donated the most, and 
 *	changes the amount that certain people donate.
 *	@author Ethan Chou
 *	Collaborators: None
 *	Teacher Name: Mrs. Bailey
 *	Period: 1
 *	Due Date: 1-15-2020
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class DayOfGiving
{
	public static void main( String[] args)
	{
		// Test the methods using the first input file
		testMethods("westGiving.txt");

		System.out.println("******************************************************\n");

		// Test the methods using the second input file
		testMethods("wolfGiving.txt");
	}

	/** Creates an array by scanning the input file
	 *  @param inputFile the file that is being scanned and organized into an array
	 *	@return the newly created array
	 */
	public static Donation[] loadDonations(String inputFile)
	{
		// Check if the file exists
		File input = new File(inputFile);
		if (!input.exists())
		{
			System.out.println(inputFile
				+ " not found. Check with your teacher.");
			System.out.println("Ending program");
			System.exit(0);
		}

		try
		{
			// Declare and create a Scanner object for the input File object
			Scanner scan = new Scanner(input);


			// Read in the number of donations on the first line of
			// the file. Remember to flush the end-of-line character.
			int donator = scan.nextInt();
			scan.nextLine();

			// Declare and create an array of Donation objects using the
			// number of donations read from the file.
			Donation groups[] = new Donation[donator];


			// In a loop, read in each set of donation information.
			// Create a Donation object and store it in your array.
			// Remember to flush the end-of-line character AFTER reading the amount.
			for (int idx = 0; idx < groups.length; idx++)
			{
				String donor = scan.nextLine();
				String recipient = scan.nextLine();
				int age = scan.nextInt();
				double amount = scan.nextDouble();
				scan.nextLine();
				groups[idx] = new Donation(donor, age, recipient, amount);
			}
			// Return your new array HERE
			return groups;
		}
		catch (IOException exc)
		{
			System.out.println(exc.getMessage());
			System.out.println("Ending program");
			System.exit(0);
		}
		return null;
	}

	/** Prints donations on a separate line for each one
	 *  @param donations the array that is being read
	 */
	public static void showDonations(Donation[] donations)
	{
		// replace statement with code to print each donation on a separate line
		for (int idx = 0; idx < donations.length; idx++)
		{
			System.out.println(donations[idx]);
		}
		System.out.println();
	}

	/** Calculates the average donation out of the array
	 *  @param donations the array that is being read
	 *	@return the average amount of the donations
	 */
	public static double calcAverageDonation(Donation[] donations)
	{
		double sum = 0;
		for (int idx = 0; idx < donations.length; idx++)
		{
			sum += donations[idx].getAmount();
		}
		double average = sum / donations.length;
		return average;
	}

	/** Calculates the number of people within a certain age range
	 *  @param donations the array that is being read
	 *	@param minAge the minimum age of the age range
	 *	@param maxAge the maximum age of the age range
	 *	@return the number of people within the given age range
	 */
	public static int calcNumInAgeRange(Donation[] donations, int minAge, int maxAge)
	{
		int count = 0;
		for (int idx = 0; idx < donations.length; idx++)
		{
			if (donations[idx].getAge() <= maxAge && donations[idx].getAge() >= minAge)
			{
				count++;
			}
		}
		return count;
	}

	/** Updates the donation amount for the listed donor
	 *  @param donations the array that is being read
	 *	@param donor the name of the donor
	 *	@param bigCheck the amount to change to
	 *	@return the number of times the donation was changed
	 */
	public static int updateDonation(Donation[] donations, String donor, double bigCheck)
	{
		int count = 0;
		for (int idx = 0; idx < donations.length; idx++)
		{
			if (donations[idx].getDonor().equals(donor))
			{
				donations[idx].changeAmount(bigCheck);
				count++;
			}
		}
		return count;
	}

	/** Finds the donor that donated the biggest amount
	 *  @param donations the array that is being read
	 *	@return the donor who donated the most
	 */
	public static String getBiggestDonationRecipient(Donation[] donations)
	{
		double temp = donations[0].getAmount();
		int tempTwo = 0;
		String recipient;
		for (int idx = 0; idx < donations.length; idx++)
		{
			if(temp < donations[idx].getAmount())
			{
				tempTwo = idx;
			}
			temp = donations[tempTwo].getAmount();
		}
		recipient = donations[tempTwo].getRecipient();
		return recipient;
	}

	/** Tests the methods for a given file
	 *  @param fileName name of file to read
	 */
	public static void testMethods(String fileName)
	{
		System.out.println("Test with file: " + fileName);

		// Populate array of Donation objects
		Donation[] heroGiving = loadDonations(fileName);

		// Display the donations
		showDonations(heroGiving);

		// Calculate the average amount of all donations
		double avgAmount = calcAverageDonation(heroGiving);
		System.out.printf("Average Donation Amount: $%,.2f %n%n", avgAmount);

		// Determine the number of donors in range [13, 215]
		int numYoungDonors = calcNumInAgeRange(heroGiving, 13, 25);
		System.out.println("Number of younger donors: " + numYoungDonors);

		// Determine the number of donors in range [60, 110]
		int numOlderDonors = calcNumInAgeRange(heroGiving, 60, 110);
		System.out.println("Number of older donors: " + numOlderDonors);
		System.out.println();

		// Change the donation amount for all donations from the given donor
		int numChanged = updateDonation(heroGiving, "Wonder Woman", 25_000);
		System.out.println("Changed " + numChanged + " donations from \"Wonder Woman\"");

		// Change the donation amount for all donations from the given donor
		numChanged = updateDonation(heroGiving, "The Avengers", 3_333);
		System.out.println("Changed " + numChanged + " donations from \"The Avengers\"");
		System.out.println();

		System.out.println("After updating:");
		showDonations(heroGiving);

		// Find the recipient of the largest donation amount
		String recipient = getBiggestDonationRecipient(heroGiving);
		System.out.println("Recipient of largest donation: " + recipient);
		System.out.println();

	}

}
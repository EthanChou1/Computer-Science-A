/**
 * The BodyMassIndex Class uses the BMI formula to  calculate a person's BMI from their
 * weight in kilograms and their height in centimeters
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 9-18-2019
 */

import java.util.Scanner;

public class BodyMassIndex
{
	// Define constants for unit conversions

	public static final double CENTIMETERS_TO_METERS = 100.0;
	public static final double KG_PER_POUNDS = 0.453592;
	public static final double CENTI_PER_INCH = 2.54;

	// Do not make any changes to the main!
	public static void main(String[] args)
	{
		// 80-point version
		// Input user's weight and height in metric units and calculate BMI
		calculateMetricBMI();
		System.out.println();

		// 100-point version
		// Input user's weight and height in imperial units and calculate BMI
		calculateImperialBMI();
		System.out.println();
	}

	/** Asks for the user's weight in kilo and height in centimeters.
	 *	It will convert the inputted data using the BMI formula to calculate
	 *	the user's BMI
	 */
	public static void calculateMetricBMI()
	{
		// complete for 80 pt version
		// Asks for weight in Kilo
		Scanner readerKilo = new Scanner(System.in);
		System.out.print("Placeholder");
		int placeHolder = readerKilo.nextInt();
		System.out.println();

		// Asks for height in Centimeters
		Scanner readerCenti = new Scanner(System.in);
		System.out.print("Enter your height in centimeters: ");
		int heightCenti = readerCenti.nextInt();
		System.out.println();

		//Displays BMI
		getBMI(weightKilo, heightCenti);

		//Adds space between Metric and Imperial
		System.out.println();
		System.out.println();

	}


	/** Calculates the BMI using the formula and final constant
	 *	Prints out the BMI using format
	 */
	public static double getBMI(int weightKG, int heightCM)
	{
		// complete for 80 pt version
		double calculateBMI = weightKG/(Math.pow((heightCM/CENTIMETERS_TO_METERS),2));
		System.out.println("A body mass index of 20 - 25 is considered \"normal\"");
		System.out.printf("Your BMI is %.2f", calculateBMI);
		return calculateBMI;
	}

	/** Asks for the user's weight in pounds and height in inches.
	 *	It will convert the inputted data using the BMI formula to calculate
	 *	the user's BMI
	 */
	public static void calculateImperialBMI()
	{
		// complete for 100 pt version
		//Asks for weight in pounds
		Scanner readerPound = new Scanner(System.in);
		System.out.print("Enter your weight in pounds: ");
		int weightPound = readerPound.nextInt();
		System.out.println();

		// Asks for height in inches
		Scanner readerInch = new Scanner(System.in);
		System.out.print("Enter your height in inches: ");
		int heightInch = readerInch.nextInt();
		System.out.println();

		//Converts the imperial measures
		convertPoundsToKG(weightPound);
		convertInchesToCM(heightInch);

		//Displays BMI
		getBMI(convertPoundsToKG(weightPound), convertInchesToCM(heightInch));

		//Adds space after Imperial
		System.out.println();
		System.out.println();

	}

	/** It converts the value from pounds to kilograms.
	 *	It will return the value
	 */
	public static int convertPoundsToKG(int numPounds)
	{
		// complete for 100 pt version
		int convertPound = (int) Math.round(numPounds * KG_PER_POUNDS);
		return convertPound;
	}

	/**	It converts the value from inches to centimeters
	 *	It will return the value
	 */
	public static int convertInchesToCM(int numInches)
	{
		// complete for 100 pt version
	 	int convertInch =  (int) Math.round(numInches * CENTI_PER_INCH);
		return convertInch;
	}
}
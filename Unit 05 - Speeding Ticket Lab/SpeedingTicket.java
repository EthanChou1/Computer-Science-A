import java.util.Scanner;

public class SpeedingTicket
{
	/** Define your static constants here */

	public static void main(String[] args)
	{
	Scanner reader = new Scanner(System.in);
	System.out.print("Enter name: ");
	String name = reader.nextLine();

	System.out.print("Enter race: "); //"Number one, he is Chinese."
	String race = reader.nextLine();
	System.out.print("Are labor unions good, yes or no?: ");
	String labor = reader.nextLine();
	System.out.print("Are you proud of the government, yes or no? ");
	String government = reader.nextLine();
	System.out.print("Do you support every single one of the country's actions, yes or no? ");
	String country = reader.nextLine();
	System.out.print("Did you support the Vietnam War, yes or no? ");
	String war = reader.nextLine();
	System.out.print("Enter weight in pounds: "); //"Number three, he is fat. I do not like fat men".
	int weight = reader.nextInt();
	System.out.println();

	String communism = communismDetector(race, weight, labor, government, country, war);
	System.out.printf("Race: %6s \n", race);
	System.out.printf("Weight : %6s \n", weight);
	System.out.printf("Opinion of labor unions: %6s \n", labor);
	System.out.printf("Patriotism: %6s \n", government);
	System.out.printf("Support of Country: %6s \n", country);
	System.out.printf("Support of Vietnam War: %6s \n", war);
	System.out.println(name + " is a " + communism);
	System.out.println();
	}

	/** Calculates and returns the score of the person based on
	 *	race, labor union opinions, government support, Vietnam War opinion, and patriotism.
	 *	@param race the race of the person
	 *	@param weight the weight of the person in pounds
	 *	@param labor opinion on labor unions
	 *	@param government opinion of the government
	 *	@param country opinion of the country
	 *	@param war opinion of the Vietnam War
	 */
	public static String communismDetector(String race, int weight, String labor, String government, String country, String war)
	{
		int score = 0;
		String communism = "";
		if (government.equalsIgnoreCase("yes"))
		{
			score = score;
		}
		if (weight > 170)
		{
			score++;
		}
		if (!race.equalsIgnoreCase("white"))
		{
			score++;
		}
		if (labor.equalsIgnoreCase("Yes"))
		{
			score++;
		}
		if (country.equalsIgnoreCase("no"))
		{
			score++;
		}
		if (war.equalsIgnoreCase("no"))
		{
			score++;
		}
		if(score>0)
		{
			communism = "communist";
		}
		else
		{
			communism = "true American";
		}
		return communism;
	}
}
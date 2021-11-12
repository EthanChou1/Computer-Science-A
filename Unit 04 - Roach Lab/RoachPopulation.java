/**	The RoachPopulation class simulates the rise and fall of a
 *	roach population by using a base population of 10
 *	@author Ethan Chou
 *	Collaborators: none
 *	Teacher Name: Mrs. Bailey
 *	Period 1
 *	Due Date: 9-30-2019
 */


public class RoachPopulation
{
	private static final int DEFAULT_POPULATION = 10;
	private static final int PESTICIDE = 100;
	private int numRoaches;		// The roach population

	/** Default constructor, initializes the population to 10
	 */
	public RoachPopulation()
	{
		numRoaches = DEFAULT_POPULATION;
	}

	/** Overloaded Constructor, initializes the population to paramter
	 */
	public RoachPopulation(int popRoach)
	{
		numRoaches = popRoach;
	}

	/** Provides the current roach population
	 *  @return number of roaches remaining
	 */
	public int getRoaches()
	{
		return numRoaches;
	}

	/** Doubles the current roach population
	 */
	public void waitForDoubling()
	{
		numRoaches = numRoaches * 2;
	}

	/**	Decreases the curren roach population
	 *	@param pesticide how strong the insecticide is
	 *	@return the number of roaches killed
	 */
	public int spray(double pesticide)
	{
		int deadRoaches = (int) Math.ceil(numRoaches * (pesticide / PESTICIDE));
		numRoaches = deadRoaches;
		return deadRoaches;
	}
}

/**
 * The BugLandRunner class purpose is to create a pattern using bugs and rocks shown in the lab instructions
 *
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Mrs. Bailey
 * Period: 1
 * Due Date: 9-3-2019
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.grid.Location;
import java.util.Random;

public class BugLandRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();

		// Comment each grouping of code. Example: creating randomly located bugs

		//Bug code

		//First bug
		Bug red = new Bug();
		red.setDirection(135);
		Location loc = new Location(0,4);
		world.add(loc ,red);

		//First bug with different color
		Bug colorBoi = new Bug(Color.CYAN);
		colorBoi.setDirection(225);
		loc = new Location(4,9);
		world.add(loc, colorBoi);

		//New location for different bug
		Bug colorBoi2 = new Bug(Color.GREEN);
		colorBoi2.setDirection(45);
		loc = new Location(5,0);
		world.add(loc, colorBoi2);

		//Final location for different bug
		Bug colorBoi3 = new Bug(Color.YELLOW);
		colorBoi3.setDirection(315);
		loc = new Location(9,5);
		world.add(loc, colorBoi3);

		//Rock code, places rocks in a diagonal pattern. One diagonal for each color.

		//First red rock in first diagonal
		Rock redRock = new Rock(Color.RED);
		loc = new Location(0,5);
		world.add(loc, redRock);

		//Second red Rock in first diagonal
		Rock redRock2 = new Rock(redRock.getColor());
		loc = new Location(1,6);
		world.add(loc, redRock2);

		//third red rock in first diagonal
		Rock redRock3 = new Rock(redRock.getColor());
		loc = new Location(2,7);
		world.add(loc, redRock3);

		//Final red rock in first diagonal
		Rock redRock4 = new Rock(redRock.getColor());
		loc = new Location(3,8);
		world.add(loc, redRock4);

		//First Cyan Rock in second diagonal
		Rock cyanRock = new Rock(Color.CYAN);
		loc = new Location(5,9);
		world.add(loc, cyanRock);

		//Second Cyan Rock in second diagonal
		Rock cyanRock2 = new Rock(cyanRock.getColor());
		loc = new Location(6,8);
		world.add(loc, cyanRock2);

		//Third Cyan Rock in second diagonal
		Rock cyanRock3 = new Rock(cyanRock.getColor());
		loc = new Location(7,7);
		world.add(loc, cyanRock3);

		//Final Cyan Rock in second diagonal
		Rock cyanRock4 = new Rock(cyanRock.getColor());
		loc = new Location(8,6);
		world.add(loc, cyanRock4);

		//First Yellow Rock in third diagonal
		Rock yellowRock = new Rock(Color.YELLOW);
		loc = new Location(9,4);
		world.add(loc, yellowRock);

		//Second Yellow Rock in third diagonal
		Rock yellowRock2 = new Rock(yellowRock.getColor());
		loc = new Location(8,3);
		world.add(loc, yellowRock2);

		//Third Yellow Rock in third diagonal
		Rock yellowRock3 = new Rock(yellowRock.getColor());
		loc = new Location(7,2);
		world.add(loc, yellowRock3);

		//Final Yellow Rock in third diagonal
		Rock yellowRock4 = new Rock(yellowRock.getColor());
		loc = new Location(6,1);
		world.add(loc, yellowRock4);

		//First Green Rock in final diagonal
		Rock greenRock = new Rock(Color.GREEN);
		loc = new Location(4,0);
		world.add(loc, greenRock);

		//Second Green Rock in final diagonal
		Rock greenRock2 = new Rock(greenRock.getColor());
		loc = new Location(3,1);
		world.add(loc, greenRock2);

		//Third green Rock in final diagonal
		Rock greenRock3 = new Rock(greenRock.getColor());
		loc = new Location(2,2);
		world.add(loc, greenRock3);

		//Final green rock in final diagonal
		Rock greenRock4 = new Rock(greenRock.getColor());
		loc = new Location(1,3);
		world.add(loc, greenRock4);

		//Bonus bug
		Bug randomBugBoi = new Bug(Color.WHITE);

		//Randomizes bonus bug's direction, needs to import java.util.random, don't know if that's allowed
		Random rand = new Random();
		int randInt = rand.nextInt(359);
		randomBugBoi.setDirection(randInt);

		//Adds bonus bug
		world.add(randomBugBoi);

		//Finds direction and location of bonus bug and displays it
		int direction = randomBugBoi.getDirection();
		loc = randomBugBoi.getLocation();
		System.out.println("Direction: " + direction);
		System.out.println("Location: " + loc);

		// show the world - DO NOT DELETE THIS!!!!
		world.show();
	}
}
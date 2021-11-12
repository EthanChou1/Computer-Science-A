/**
 * The CircleComponent Class creates a circle of the same size
 * but in different locations 100 times.
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 11-8-2019
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class CircleComponent extends JComponent
{
	public static final int MAX_DIAMETER = 50;
	public static final int MIN_DIAMETER = 20;
 	public static final int MIN_COORD = 0;
 	public static final int MAX_LOOP = 100;

	/** Draws a circle 100 times in a different location and color
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;

		for (int num = 1; num <= MAX_LOOP; num++)
		{
			Ellipse2D.Double circle = generateCircle();

			g2.setColor(getRandomColor());
			g2.draw(circle);
			g2.fill(circle);
		}
	}

	/*	Generates a circle with a randomized location and size
	 *	@return the circle's dimensions and location
	 */
	private Ellipse2D.Double generateCircle()
	{
		int width = getWidth();
		int height = getHeight();
		int diameter;
		diameter = (int) (Math.random()*(MAX_DIAMETER + 1 - MIN_DIAMETER)) + MIN_DIAMETER;
		int xCoord = getRandomInteger(MIN_COORD, width - diameter);
		int yCoord = getRandomInteger(MIN_COORD, height - diameter);
		Ellipse2D.Double circle;
		circle  = new Ellipse2D.Double(xCoord, yCoord, diameter, diameter);
		return circle;
	}

	/*	Generates a random integer for the circle's
	 *	size
	 *	@param min the minimum value for the random integer
	 *	@param max the maximum value for the random integer
	 *	@return the integer
	 */
	private int getRandomInteger(int min, int max)
	{
		int num = (int) (Math.random()*(max + 1 - min)) + min;
		return num;
	}

	/*	Generates a random color based on the RGB values
	 *	@return the randomized color
	 */
	private Color getRandomColor()
	{
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		Color col = new Color(red, green, blue);
		return col;
	}

}
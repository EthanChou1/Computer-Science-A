/**
 * The RectangleComponent class generates solid rectangles nested inside the other
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 11-8-2019
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
	public static final int MIN_COORD = 0;
	public static final int NEW_SIZE = 20;
 	public static final int MAX_LOOP = 100;
 	public static final int NESTED_RECT = 2;
 	public static final int MIN_HEIGHT = 5;
 	public static final int MIN_WIDTH = 10;

	/** Draws progressively smaller rectangles in the frame,
	 *	nesting them together
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		int newXCoord = MIN_COORD;
		int newYCoord = MIN_COORD;

		Rectangle rect = new Rectangle(MIN_COORD, MIN_COORD, width, height);
		g2.setColor(getRandomColor());
		g2.fill(rect);
		g2.draw(rect);

		while (rect.getWidth() >= MIN_WIDTH && rect.getHeight() >= MIN_HEIGHT)
		{
			newXCoord = MIN_COORD + newXCoord + NEW_SIZE;
			newYCoord = MIN_COORD + newYCoord + NEW_SIZE;
			width = width - (NEW_SIZE * NESTED_RECT);
			height = height - (NEW_SIZE * NESTED_RECT);

			rect = new Rectangle(newXCoord, newYCoord, width, height);
			g2.setColor(getRandomColor());
			g2.fill(rect);
			g2.draw(rect);
		}
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
		return col; // replace this statement
	}
}
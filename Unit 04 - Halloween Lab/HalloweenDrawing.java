/** The HalloweenDrawing class contains the methods that create the
 *	house, windows, door, and pumpkin with a face
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 10-4-2019
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class HalloweenDrawing extends JComponent
{
	private Graphics2D g2;
	private int width;
	private int height;

	/** Draw a house, a pumpkin, and a greeting
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Convert g back to its Graphics2D self
		g2 = (Graphics2D)g;

		// Get size of component window
		width = getWidth();
		height = getHeight();

		// Draw house
		drawHouse();

		// Draw pumpkin
		drawPumpkin();

		// Draw greeting
		g2.setColor(Color.red);
		g2.drawString("Happy Halloween!", 20, 20);

	}

	/**	Draws the house and roof with outlines. The house is filled in.
	 */
	public void drawHouse()
	{
		//Base of the house
		g2.setColor(Color.lightGray);
		int locX = 50;
		int locY = 100;
		int houseWidth = width / 3;
		int houseHeight = 200;
		Rectangle house = new Rectangle(locX, locY, houseWidth, houseHeight);
		g2.fill(house);
		g2.setColor(Color.black);
		g2.draw(house);
		//Roof
		// Variable to shorten code
		double roofTop = (houseWidth + 100)/ 2;
		Line2D.Double firstDiag = new Line2D.Double(50, 100, roofTop , (locY / 2));
		g2.draw(firstDiag);
		Line2D.Double secondDiag = new Line2D.Double(50 + houseWidth, 100, roofTop , (locY / 2));
		g2.draw(secondDiag);
		drawHouseFeatures(80, 175, 50, 75);
	}

	/** Draws the windows and door of the house
	 *	@param houseX the x coordinate of the windows
	 *	@param houseY the y coordinate of the windows
	 *	@param houseWidth the width of the window
	 *	@param houseHeight the height of the window
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
		//Window Code
		g2.setColor(Color.cyan);
		Rectangle window = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		g2.fill(window);
		g2.setColor(Color.black);
		g2.draw(window);

		//Second Window
		int locX2 = houseX + 150;
		Rectangle window2 = new Rectangle(locX2, houseY, houseWidth, houseHeight);
		g2.setColor(Color.cyan);
		g2.fill(window2);
		g2.setColor(Color.black);
		g2.draw(window2);

		//Door
		int locDoorX = houseX + 75;
		int doorHeight = houseHeight + 50;
		Rectangle door = new Rectangle(locDoorX, houseY, houseWidth, doorHeight);
		g2.setColor(Color.red);
		g2.fill(door);
		g2.setColor(Color.black);
		g2.draw(door);

		//Embellishments
		//Bush 1
		int bushY = 260;
		int bushX = 210;
		int bushWidth = 95;
		int bushHeight = 40;
		Rectangle bush = new Rectangle(bushX, bushY, bushWidth, bushHeight);
		g2.setColor(Color.green);
		g2.fill(bush);
		g2.setColor(Color.black);
		g2.draw(bush);

		//Bush 2
		int bushY2 = 260;
		int bushX2 = 55;
		int bushWidth2 = 95;
		int bushHeight2 = 40;
		Rectangle bush2 = new Rectangle(bushX2, bushY2, bushWidth2, bushHeight2);
		g2.setColor(Color.green);
		g2.fill(bush2);
		g2.setColor(Color.black);
		g2.draw(bush2);

		//Chimney
		int chimneyY = 30;
		int chimneyX = 80;
		int chimneyWidth = 40;
		int chimneyHeight = 65;
		Rectangle chimney = new Rectangle(chimneyX, chimneyY, chimneyWidth, chimneyHeight);
		g2.setColor(Color.lightGray);
		g2.fill(chimney);
		g2.setColor(Color.black);
		g2.draw(chimney);
	}

	/** Creates the pumpkin shape and stem with outlines
	 */
	public void drawPumpkin()
	{
		//Shape
		g2.setColor(Color.orange);
		double pumpLocX = 400;
		double pumpLocY = 100;
		Ellipse2D.Double pumpkin;
		pumpkin = new Ellipse2D.Double(pumpLocX, pumpLocY, 225, 175);
		g2.fill(pumpkin);
		g2.setColor(Color.black);
		g2.draw(pumpkin);
		//Stem
		g2.setColor(Color.green);
		int stemLocX = 500;
		int stemLocY = 75;
		Rectangle stem = new Rectangle(stemLocX, stemLocY, 25, 40);
		g2.fill(stem);
		g2.setColor(Color.black);
		g2.draw(stem);
		//Pumpkin Face
		drawPumpkinFace(425, 150, 40, 40);
	}

	/** Draws the pumpkin face, which is OwO
	 *	@param pumpkinX the x coordinate of the eye
	 *	@param pumpkinY the y coordinate of the eye
	 *	@param pumpkinWidth the width of the eye
	 *	@param pumpkingHeight the height of the eye
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
	{
		//Left Eye
		g2.setColor(Color.black);
		Ellipse2D.Double leftEye;
		leftEye = new Ellipse2D.Double(pumpkinX, pumpkinY, pumpkinWidth, pumpkinHeight);
		g2.fill(leftEye);
		//Right Eye
		int newEyeLocX = pumpkinX + 140;
		Ellipse2D.Double rightEye;
		rightEye = new Ellipse2D.Double(newEyeLocX, pumpkinY, pumpkinWidth, pumpkinHeight);
		g2.fill(rightEye);
		//Mouth
		int mouthLocX = pumpkinX + 45;
		int mouthLocX2 = mouthLocX + 20;
		int mouthLocY = pumpkinY + 85;
		int mouthLocX3 = mouthLocX + 40;
		int mouthLocY2 = pumpkinY + 50;
		int mouthLocX4 = mouthLocX3 + 20;
		Line2D.Double firstPartMouth;
		firstPartMouth = new Line2D.Double(mouthLocX, pumpkinY + 50, mouthLocX2, mouthLocY);
		g2.draw(firstPartMouth);
		//Second part of mouth
		Line2D.Double secPartMouth;
		secPartMouth = new Line2D.Double(mouthLocX2, mouthLocY, mouthLocX3 , mouthLocY2);
		g2.draw(secPartMouth);
		//Repeat the pattern
		Line2D.Double thirdPartMouth;
		thirdPartMouth = new Line2D.Double(mouthLocX3, mouthLocY2, mouthLocX4, mouthLocY);
		g2.draw(thirdPartMouth);
		Line2D.Double fourthPartMouth;
		fourthPartMouth = new Line2D.Double(mouthLocX4, mouthLocY, mouthLocX4 + 20, mouthLocY2);
		g2.draw(fourthPartMouth);
	}
}
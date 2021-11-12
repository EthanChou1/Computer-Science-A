
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
	public static final double MAX_DIAMETER = 61;
	public static final double MIN_DIAMETER = 1;
	public static final int COLOR = 255;
	public static final int MAX_LOOP = 1000;
	private ArrayList<Ellipse2D.Double> circleArray;

	public CirclesComponent()
	{
		circleArray = new ArrayList<Ellipse2D.Double>();
	}

	/**
	 *  Generate and draw all of the circles
	 *  @param g the graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}

	private void generateCircles()
	{
		circleArray = new ArrayList<Ellipse2D.Double>();
		for(int idx = 0; idx <MAX_LOOP; idx++)
		{
			double diameter;
			diameter = Math.random()*(MAX_DIAMETER - MIN_DIAMETER) + MIN_DIAMETER;
			double xCoord = Math.random()*(getWidth() - diameter);
			double yCoord = Math.random()*(getHeight() - diameter);

			Ellipse2D.Double newCircle;
			newCircle = new Ellipse2D.Double(xCoord, yCoord, diameter, diameter);
			if(!circleIntersects(newCircle))
			{
				circleArray.add(newCircle);
			}
		}
	}

	private void drawCircles(Graphics2D g2)
	{
		for (int idx = 0; idx < circleArray.size(); idx++)
		{
			Ellipse2D.Double circles = circleArray.get(idx);
			int red = (int) (Math.random()*COLOR);
			int green = (int) (Math.random()*COLOR);
			int blue = (int) (Math.random()*COLOR);
			Color col = new Color(red, green, blue);
			g2.setColor(col);
			g2.draw(circles);

		}
	}

	// 100-point Version
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		for (int idx = 0; idx < circleArray.size(); idx++)
		{
			Ellipse2D.Double checkCircle = circleArray.get(idx);
			double xCoord = Math.pow(checkCircle.getCenterX() - circle.getCenterX(), 2);
			double yCoord = Math.pow(checkCircle.getCenterY() - circle.getCenterY(), 2);
			double distance = Math.sqrt(xCoord + yCoord);
			double radius = (checkCircle.getWidth()/2) + (circle.getWidth()/2);
			if(distance < radius)
			{
				return true;
			}
		}
		return false;
	}
}
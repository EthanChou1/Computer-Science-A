/** The HallowennLab Class calls the HalloweenDrawing class to create
 *	a drawing of a house with two windows, one door, and a pumpkin with a face
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 10-4-2019
 */

import javax.swing.JFrame;

public class HalloweenLab
{
	/** frame dimensions */
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Ethan Chou 1st Period");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(10, 10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Draw shapes
		HalloweenDrawing drawing = new HalloweenDrawing();
		frame.add(drawing);

		// Show it
		frame.setVisible(true);
	}
}
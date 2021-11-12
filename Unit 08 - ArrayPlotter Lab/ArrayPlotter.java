/**
 *	The ArrayPlotter class creates a 2d array in Java's gridworld
 *	according to the rows and columns inputted. It also creates several patterns
 *	by using 2d arrays.
 *	@author Ethan Chou
 *	Collaborators: None
 *	Teacher Name: Mrs. Bailey
 *	Period: 1
 *	Due Date: 1-23-2020
 */
public class ArrayPlotter
{
	/** The Array Plotter Graphical User Interface. */
	private ArrayPlotterGUI gui;

	/** The Color Array.  The element values indicate how to color a grid cell:
	 *  - true: Color the cell with the Drawing Color.
	 *  - false: Color the cell with the Background Color.
	 */
	private boolean[][] colorArray;


	/** Constructs an Array Plotter */
	public ArrayPlotter()
	{
		gui = new ArrayPlotterGUI(this);
		colorArray = null;
	}

	/** Initialize this's Color Array to a new 2D array of boolean values
	 *  with the given dimensions.
	 *  @param rows the number of rows in the new array.
	 *  @param cols the number of columns in the new array.
	 *  Postcondition: All of the Color Array's elements have the value false.
	 */
	public void initializeColorArray(int rows, int cols)
	{
		colorArray = new boolean[rows][cols];
	}

	/** Removes all objects from the grid. */
	public void onClearGridButtonClick()
	{
		// REPLACE showMessageDialog call with correct code.
		for (int row = 0; row < colorArray.length; row++)
		{
			for(int col = 0; col < colorArray[row].length; col++)
			{
				colorArray[row][col] = false;
			}
		}
		gui.update(colorArray);
	}

	/** Fills in all the cells of the grid using a row-major traversal. */
	public void onRowMajorFillButtonClick()
	{
		// REPLACE showMessageDialog call with correct code.
		for (int row = 0; row < colorArray.length; row++)
		{
			for(int col = 0; col < colorArray[row].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}

	/** Fills in all the cells of the grid using a column-major traversal. */
	public void onColMajorFillButtonClick()
	{
		// REPLACE showMessageDialog call with correct code.
		for (int row = 0; row < colorArray[0].length; row++)
		{
			for(int col = 0; col < colorArray.length; col++)
			{
				colorArray[col][row] = true;
				gui.update(colorArray);
				System.out.println(col + " " + row);
			}
		}
	}

	/** Fills in the grid by going in a diagonal. */
	public void onMainDiagonalFillButtonClick()
	{
		// REPLACE showMessageDialog call with correct code.
		for (int row = 0; row < Math.min(colorArray.length, colorArray[0].length); row++)
		{
			colorArray[row][row] = true;
			gui.update(colorArray);
		}
	}

	/** Fills a row from left to right.
	 *	@param row fills in the grid with a color
	 */
	private void fillRowLeftToRight (boolean[] row)
	{
		for(int rows = 0; rows < row.length; rows++)
		{
			row[rows] = true;
			gui.update(colorArray);
		}
	}

	/** Fills a row from right to left.
	 *	@param row fills in the grid with a color
	 */
	private void fillRowRightToLeft (boolean[] row)
	{
		for(int rows = row.length - 1; rows >= 0; rows--)
		{
			row[rows] = true;
			gui.update(colorArray);
		}
	}

	/** Fills in all the cells of the grid by going left to right on even rows
	 *	and going right to left on odd rows.
	 */
	public void onSerpentineFillButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
		{
			if ((row % 2) == 0)
			{
				fillRowLeftToRight(colorArray[row]);
			}
			else fillRowRightToLeft(colorArray[row]);
		}
	}

	/** Fills the grid in a triangle pattern. */
	public void onMainTriangleFillButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
		{
			for (int col = 0; col < colorArray[0].length; col++)
			{
				if (row >= col)
				{
					colorArray[row][col] = true;
					gui.update(colorArray);
				}
			}
		}
	}

	/** Fills in all the cells of the grid using a column-major traversal
	 *	in reverse order.
	 */
	public void onReverseColMajorFillButtonClick()
	{
		for (int col = colorArray[0].length - 1; col >= 0; col--)
		{
			for (int row = colorArray.length - 1; row >= 0; row--)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}

	/** Fills in the grid with a triangle pattern but starting at the right side
	 *	of the grid and going in a row-major traversal
	 */
	public void onOtherTriangleFillButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
		{
			for (int col = colorArray[0].length - row - 1; col < colorArray[0].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}

	/** main method that creates the grid plotter application. */
	public static void main(String[] args)
	{
		ArrayPlotter mainObject = new ArrayPlotter();
	}
}

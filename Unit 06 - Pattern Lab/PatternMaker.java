/**
 *
 *
 * @author
 * Collaborators:
 * Teacher Name:
 * Period:
 * Due Date:
 */

import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class PatternMaker
{
	/** Dimensions for the different worlds */
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;

	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;

	public static final int COLUMN_SHIFT = 9;

	/** Draw the different patterns. Comment others out while working on a single pattern.
	 *  Uncomment calls to completed patterns before turning in.
	 */
	public static void main(String[] args)
	{
		drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}


	public static void drawPattern1(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		for (int row = 0; row < NUM_ROWS_NUMBER_GRID; row ++)
		{
			for (int column = 0; column <= row; column ++)
			{
				Location myLoc = new Location(row, column);
				world.add(myLoc, column);

			}
		}

		world.show();
	}


	public static void drawPattern2(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		Location loc = new Location(0, 0);
		world.add(loc, Color.black);

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 0; column <= row; column ++)
			{
				loc = new Location(row, column);
				world.add(loc, Color.black);

			}
		}

		loc = new Location(0, numCols - 1);
		world.add(loc, Color.magenta);
		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row++)
		{
			for (int column = 0; column <= NUM_COLS_COLOR_GRID - 1; column++)
			{
				loc = new Location(row , column);
				world.add(loc, Color.magenta);

			}
		}

		loc = new Location(numRows - 1, numCols - 1);
		world.add(loc, Color.black);

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 0; column <= row; column ++)
			{
				loc = new Location(row, column);
				world.add(loc, Color.black);

			}
		}

		loc = new Location(numRows - 1, 0);
		world.add(loc, Color.cyan);

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 0; column <= row - 1; column ++)
			{
				loc = new Location(row , column);
				world.add(loc, Color.cyan);

			}
		}


		world.show();
	}


	public static void drawPattern3(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		Location loc = new Location(numRows - 1, 0);

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 0; column <= NUM_COLS_COLOR_GRID; column +=3)
			{
				loc = new Location(row , column);
				world.add(loc, Color.red);

			}
		}

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 1; column <= NUM_COLS_COLOR_GRID - 2; column +=3)
			{
				loc = new Location(row , column);
				world.add(loc, Color.white);
			}
		}

		for (int row = 0; row < NUM_ROWS_COLOR_GRID; row ++)
		{
			for (int column = 2; column <= NUM_COLS_COLOR_GRID - 1; column +=3)
			{
				loc = new Location(row , column);
				world.add(loc, Color.blue);
			}
		}


		world.show();
	}


	public static void drawPattern4(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		Location loc = new Location(numRows - 1, 0);

		int triangle = NUM_ROWS_COLOR_GRID / 2;
		int columnHalf = NUM_COLS_COLOR_GRID / 2;

		for (int row = triangle; row >= 0; row --)
		{
			for (int column = 0; column <= row; column ++)
			{
				loc = new Location(row, column + COLUMN_SHIFT);
				world.add(loc, Color.cyan);

			}
		}

		for (int row = triangle; row >= 0; row --)
		{
			for (int column = 0; column <= row; column ++)
			{
				loc = new Location(column + COLUMN_SHIFT, row);
				world.add(loc, Color.cyan);

			}
		}

		for (int row = triangle; row >= 0; row --)
		{
			for (int column = columnHalf; column > 0; column --)
			{
				loc = new Location(row, column);
				System.out.print("*");
				world.add(loc, Color.cyan);

			}
			System.out.println();
		}

		world.show();
	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesLab
{
	public static void main(String[] args)
	{
		try
		{
			// run 70-point version
			processIntegers("test1.txt", "output1.txt");
			System.out.println();

			// run 85-point version
			testLines("test2a.txt", "output2a.txt");

			// run 85-point version
			testLines("test2b.txt", "output2b.txt");
			System.out.println();

			// run 100-point version - good data
			extractSubstrings("test3a.txt", "output3a.txt");

			// run 100-point version - bad data
			extractSubstrings("test3b.txt", "output3b.txt");
			System.out.println();
		}
		catch (Exception exc)
		{
			System.out.println("Exception occurred: " + exc.getMessage());
			exc.printStackTrace();
		}
	}

	public static void processIntegers(String inFile, String outFile) throws FileNotFoundException
	{
		try
		{
			String line = inFile;
			Scanner reader = new Scanner(new File(line));
			PrintWriter export = null;
			if (reader.hasNextLine())
			{
				reader.nextLine();
				export = new PrintWriter(outFile);
				while (reader.hasNextInt())
				{
					int small = reader.nextInt();
					int large = reader.nextInt();
					int temp = reader.nextInt();
					if(temp > large)
					{
						large = temp;
					}
					if(small > large)
					{
						large = small;
					}
					if(temp < small)
					{
						small = temp;
					}
					if (large < small)
					{
						small = large;
					}
					reader.nextLine();
					export.println(small + "  " + large);
				}
				export.flush();
				System.out.println();
				reader.close();
			}
			else
			{
				System.out.println("There are no integers");
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error processing file: " + exception);
		}
		System.out.println("Smallest and largest integers from " + inFile
			+ " written to " + outFile);
	}

	public static void testLines(String inFile, String outFile) throws FileNotFoundException
	{
		try
		{
			String line = inFile;
			Scanner reader = new Scanner(new File(line));
			PrintWriter export = null;
			String firstWord = reader.nextLine();
			if (reader.hasNextLine())
			{
				export = new PrintWriter(outFile);
				while (reader.hasNextLine())
				{
					String text = reader.nextLine();
					String firstWordCap = firstWord.toUpperCase();
					int the = text.indexOf(firstWord);
					if (the != -1 || text.compareTo(firstWordCap) == 32)
					{
						export.println(text);
					}
				}
				export.flush();
				System.out.println();
				reader.close();
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error processing file: " + exception);
		}
		System.out.println("Lines from " + inFile + " written to " + outFile);
	}

	public static void extractSubstrings(String inFile, String outFile)
	{
		try
		{
			String line = inFile;
			Scanner reader = new Scanner(new File(line));
			PrintWriter export = null;
			if(reader.hasNextLine())
			{
				export = new PrintWriter(outFile);
				while (reader.hasNextLine())
				{
					int firstIndex = reader.nextInt();
					int secondIndex = reader.nextInt();
					String substring = reader.nextLine();
					String trim = substring.trim();
					export.println(getSubstring(firstIndex, secondIndex, trim));
				}
				export.flush();
				reader.close();
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error processing file: " + exception);
		}
		catch (StringIndexOutOfBoundsException exception)
		{
			System.out.println("Error processing file: " + exception);
		}
		catch (IllegalArgumentException exception)
		{
			System.out.println("Error processing file: " + exception);
		}
		System.out.println("Requested substrings from " + inFile + " written to " + outFile);
	}

	private static String getSubstring(int index1, int index2, String text)
	{
		String newString = "";
		String trim = "";
		try
		{
			if (index1 < index2 || index1 == index2)
			{
				newString = ":" + text.substring(index1, index2) + ":";
				trim = newString.trim();
			}
			else if(index1 < 0 || index2 > text.length()-1 || index1 > index2 || index2 < 0)
			{
				newString = "Error in file test3b.txt: "
				+ "Invalid indexes [" + index1 + "," + index2 +
				"] for \"" + text + "\"";
			}
		}
		catch (StringIndexOutOfBoundsException exception)
		{
				newString = "Error in file test3b.txt: "
				+ "Invalid indexes [" + index1 + "," + index2 +
				"] for \"" + text + "\"";
		}
		return newString;
	}
}
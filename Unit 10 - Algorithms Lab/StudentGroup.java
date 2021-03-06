
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentGroup
{
	// Maximum number of students stored in array
	private final static int MAX_STUDENTS = 200;

	// Instance variables
	private Student[] students;	// array of Student objects
	private int numStudents;	// number of actual objects in array

	/** Constructs an empty student group with capacity for MAX_STUDENTS
	 */
	public StudentGroup()
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
	}

	/** Constructs a student group with capacity for MAX_STUDENTS
	 *  and populates it with the student data found in the given file
	 *  @param fileName name of file containing student data
	 */
	public StudentGroup(String fileName)
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
		readFile(fileName);
	}

	public Student findByName(String name)
	{
		Student stuName = null;
		for(int idx = 0; idx < numStudents; idx++)
		{
			String studentName = students[idx].getName();
			if(studentName.equals(name))
			{
				stuName = students[idx];
				return stuName;
			}
		}
		return null;
	}

	public void sortByName()
	{
		for(int idx = 1; idx < numStudents; idx++)
		{
			Student key = students[idx];
			int position = idx;
			while (position > 0 && key.getName().compareTo(students[position - 1].getName()) < 0)
			{
				students[position] = students[position - 1];
				position--;
			}
			students[position] = key;
		}
	}

	public void sortByID()
	{
		for(int start = 0; start < numStudents - 1; start++)
		{
			int min = start;
			for(int index = start; index < numStudents; index++)
			{
				if(students[index].getID() < students[min].getID())
				{
					min = index;
				}
			}
			Student temp = students[start];
			students[start] = students[min];
			students[min] = temp;
		}
	}

	public Student findByID(int id)
	{
		int low = 0;
		int high = numStudents - 1;
		while (low <= high)
		{
			int middle = (low + high) / 2;
			int idStudent = students[middle].getID();
			if (idStudent == id)
			{
				return students[middle];
			}
				else if(idStudent < id)
				{
					low = middle + 1;
				}
					else if (idStudent > id)
					{
						high = middle - 1;
					}
		}
		return null;
	}

	/** Provides the group of students
	 *  @return the group of students as a string
	 */
	@Override
	public String toString()
	{
		String str = "[";
		for (int index = 0; index < numStudents; index++)
		{
			str += students[index].toString();
			if (index == numStudents - 1)
				str += "]";
			else
				str += ",\n ";
		}
		return str;
	}

	/** Reads student entries from a given file and stores them in the array
	 *  @param fileName name of file containing student data in format
	 *         LAST<space>FIRST<space>ID<space>GPA
	 */
	private void readFile(String fileName)
	{
		try
		{
			// Open file for reading
			Scanner scan = new Scanner(new FileReader(fileName));

			// Continue reading and adding students until  no more entries
			// Entries are in form LAST<space>FIRST<space>ID<space>GPA
			while (scan.hasNextLine())
			{
				String inputStr = scan.nextLine();
				Scanner strScan = new Scanner(inputStr);
				String lastName = strScan.next();
				String firstName = strScan.next();
				int id = strScan.nextInt();
				double gpa = strScan.nextDouble();

				Student stu = new Student(lastName, firstName, id, gpa);
				students[numStudents] = stu;
				numStudents++;
			}
			scan.close();
		}
		catch (IOException e)
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
	}
}
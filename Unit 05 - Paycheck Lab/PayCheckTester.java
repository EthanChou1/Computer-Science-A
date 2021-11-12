

import java.util.Scanner;

public class PayCheckTester
{
	public static void main(String[] args)
	{
		// Input name and type of worker
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter employee's name: ");
		String name = scan.nextLine();

		System.out.print("Enter M (Manager) or S (Sales Clerk): ");
		String type = scan.next();
		System.out.println();

		boolean isManager = type.equalsIgnoreCase("m");

		// Declare and instantiate a Paycheck object
		PayCheck employee = new PayCheck(name, isManager);

		// Set the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);

		// Change the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);
	}

	/** Updates worker's weekly hours and sales with information
	 *  input by the user
	 *  @param scan the Scanner to use to get input from user
	 *  @param worker the Paycheck to update
	 */
	public static void changeHoursAndSales(Scanner scan, PayCheck worker)
	{
		System.out.print("Enter total number of hours worked: ");
		double hours = scan.nextDouble();
		worker.setHours(hours);

		System.out.print("Enter total sales generated: ");
		double sales = scan.nextDouble();
		worker.setSales(sales);
		System.out.println();

		// Update PayCheck object's hours and sales
	}

	public static void displayWages(PayCheck worker)
	{
		if (worker.isManager())
		{
			System.out.printf("Manager " +
			worker.getName() + ": " + worker.getHours() + " hours, " +
			"$" + "%.2f" + " in sales", worker.getSales());
		}
		else
		{
			System.out.printf("Sales Clerk " +
			worker.getName() + ": " + worker.getHours() + " hours, " +
			"$" + "%.2f" + " in sales", worker.getSales());
		}
		System.out.println();
		System.out.printf("Total wages: " + "$" + "%.2f", worker.calcWages());
		System.out.println();
		System.out.println();
	}
}
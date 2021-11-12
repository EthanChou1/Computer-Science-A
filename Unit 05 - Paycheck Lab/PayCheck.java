

public class PayCheck
{
	/* Static Constants Go Here */
	public static final int HOURS_WORKED = 40;
	public static final double BASIC_WAGE = 9.75;
	public static final double OVERTIME = BASIC_WAGE * 1.5;
	public static final double MANAGER = 100.00;
	public static final double COMMISSION_LVL1 = 0.05;
	public static final double COMMISSION_LVL2 = 0.08;
	public static final double COMMISSION_LVL3 = 0.13;
	public static final double SALE_VOLUME_1 = 99.99;
	public static final double SALE_VOLUME_2 = 299.99;
	public static final double SALE_VOLUME_3 = 300.00;

	/* Instance variables */
	private String employee;
	private double hoursWorked;
	private boolean isManager;
	private double weeklySales;

	/**
	 *  Creates a PayCheck object for an employee given the name and
	 *  whether or not this employee is a manager.
	 *  @param name the name of the employee
	 *  @param manager indicates whether or not this is a manager
	 *     (true if a manager, false if a sales clerk)
	 */
	public PayCheck(String name, boolean manager)
	{
		employee = name;
		isManager = manager;
		hoursWorked = 0;
		weeklySales = 0;
	}


	public double calcWages()
	{
		double wage;
		wage = getHours() * BASIC_WAGE;
		if (getHours() > HOURS_WORKED)
		{
			wage = (HOURS_WORKED * BASIC_WAGE) + (OVERTIME * (getHours() - HOURS_WORKED));
		}
		if (isManager)
		{
			wage = wage + MANAGER;
		}
		wage = wage + calcCommission();
		return wage;
	}

	private double calcCommission()
	{
		double sales;
		sales = getSales();
		if (sales <= SALE_VOLUME_1)
		{
			sales = (getSales() * COMMISSION_LVL1);
		}
		if (sales <= SALE_VOLUME_2 && sales >= SALE_VOLUME_1)
		{
			sales = (getSales() * COMMISSION_LVL2);
		}
		if (sales >= SALE_VOLUME_3)
		{
			sales = (getSales() * COMMISSION_LVL3);
		}
		return sales;
	}

	/** Retrieves the employee's name
	 *  @return the name of this employee
	 */
	public String getName()
	{
		return employee;
	}

	/** Reports whether or not this employee is a manager
	 *  @return true if this employee is a manager, false otherwise
	 */
	public boolean isManager()
	{
		return isManager;
	}

	/** Retrieves the number of hours worked
	 *  @return the number of hours worked this pay period
	 */
	public double getHours()
	{
		return hoursWorked;
	}

	/** Resets the number of hours worked to newHours
	 *  @param newHours the number of hours worked this pay period
	 */
	public void setHours(double newHours)
	{
		hoursWorked = newHours;
	}

	/** Retrieves the total amount of sales generated
	 *  @return the total amount of sales generated this pay period
	 */
	public double getSales()
	{
		return weeklySales;
	}

	/** Resets the amount of sales generated to newSales
	 *  @param newSales the total amount of sales generated this pay period
	 */
	public void setSales(double newSales)
	{
		weeklySales = newSales;
	}
}
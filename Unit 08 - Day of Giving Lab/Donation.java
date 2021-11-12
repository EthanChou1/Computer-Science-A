/**
 *  Donation.java
 *  Represents a donation made to a charitable organization. Each donation
 *  maintains the name of the donor, the donor's age, the name of the recipient
 *  of the gift, and the amount of the donation.
 *  Provides ability to retrieve information about the donation and to change
 *  the amount of the donation. 
 *  @author Tracy Ishman
 *  Date: 01-09-2020
 */

public class Donation 
{
	/** Name of the donor */
	private String donor;
	
	/** Age of the donor */
	private int age;
	
	/** Name of the charitable foundation receiving gift */
	private String recipient;
	
	/** Amount of the donation */
	private double amount;

	/** Constructs a donation with the given donor, donor's age, recipient, and amount
	 *  @param donor the name of person making donation
	 *  @param donorAge the age of the donor
	 *  @param recipient the name of charitable organization receiving the donation
	 *  @param amount the amount of money being donated
	 */
	public Donation(String donor, int donorAge, String recipient, double amount) 
	{
		this.donor = donor;
		this.age = donorAge;
		this.recipient = recipient;
		this.amount = amount;
	}

	/** Retrieves the donor's name
	 *  @return the name of the person making donation
	 */
	public String getDonor()
	{
		return donor;
	}

	/** Retrieves age of this donor
	 *  @return the donor's age
	 */
	public int getAge()
	{
		return age;
	}
	
	/** Retrieves the recipient's name
	 *  @return the name of the organization receiving the donation
	 */
	public String getRecipient()
	{
		return recipient;
	}

	/** Retrieves the amount of the donation
	 *  @return the amount donated
	 */
	public double getAmount()
	{
		return amount;
	}
	
	/** Changes the amount of the donation to newAmount
	 *  @param newAmount the new amount of the donation
	 */
	public void changeAmount(double newAmount)
	{
		amount = newAmount;
	}

	/** Retrieves the donation's information as a string
	 *  @return the donation information
	 */
	@Override
	public String toString()
	{
		return String.format("%s (%d) $%,.2f to \"%s\"", donor, age, amount, recipient);
	}	
}
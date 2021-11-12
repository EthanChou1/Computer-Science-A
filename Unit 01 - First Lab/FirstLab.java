/**
 * The FirstLab class: Write a program to print your name in a box, your neighbor's name in a box, and include a face or picture
 *
 * @author Ethan Chou
 * Collaborators: Michael Chen, Larry Davis
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 8-21-2019
 */

public class FirstLab
{
	public static void main(String[] args)
	{
		// Write the code HERE to print your name and then the
		// names and positive statement about your neighbors

		System.out.print("\\===============================================\\");
		System.out.println("\n\\\t\t\"Ethan Chou\"\t\t\t\\");
		System.out.print("\\===============================================\\");
		System.out.println("\n\\\t   Michael Chen: Good at math\t\t\\");
		System.out.print("\\===============================================\\");
		System.out.println("\n\\   Larry Davis: Good at computer programming   \\");
		System.out.print("\\===============================================\\\n");



		// This calls the bonus method to draw your silly face/picture
		bonus();
	}

	/** Draws a silly face or picture
	 */
	public static void bonus()
	{
		// Write the code HERE to display a silly face or picture
		System.out.println("\n\\===================================================================\\\n\\\t\t\t\t\t\t\t\t    \\");
		System.out.println("\\                  ,----------------,              ,---------,      \\");
		System.out.println("\\             ,-----------------------,          ,\"        ,\"|      \\");
		System.out.println("\\           ,\"                      ,\"|        ,\"        ,\"  |      \\");
		System.out.println("\\          +-----------------------+  |      ,\"        ,\"    |      \\");
		System.out.println("\\          |  .-----------------.  |  |     +---------+      |      \\");
		System.out.println("\\          |  |                 |  |  |     | -==----'|      |      \\");
		System.out.println("\\          |  |                 |  |  |     |         |      |      \\");
		System.out.println("\\          |  |                 |  |  |/----|`---=    |      |      \\");
		System.out.println("\\          |  |                 |  |  |   ,/|==== ooo |      ;      \\");
		System.out.println("\\          |  |                 |  |  |  // |(((( [33]|    ,\"       \\");
		System.out.println("\\          |  `-----------------'  |,\" .;'| |((((     |  ,\"         \\");
		System.out.println("\\          +-----------------------+  ;;  | |         |,\"           \\");
		System.out.println("\\             /_)______________(_/  //'   | +---------+             \\");
		System.out.println("\\        ___________________________/___  `,                        \\");
		System.out.println("\\       /  oooooooooooooooo  .o.  oooo /,   \\,\"-----------          \\");
		System.out.println("\\      / ==ooooooooooooooo==.o.  ooo= //   ,`\\--{)B     ,\"          \\");
		System.out.println("\\     /_==__==========__==_ooo__ooo=_/'   /___________,\"            \\");
		System.out.println("\\     `-----------------------------'\t\t\t\t    \\\n\\\t\t\t\t\t\t\t\t    \\");
		System.out.println("\\===================================================================\\\n");
	}
}
package model;

/**
 * This class is a Child of Employee. 
 * An employee which is a Cook has duties exclusively in the kitchen.
 * @author Phillip Witkin
 *
 */
public class Hostess extends Employee {
	
	/**
	 * Constructor
	 * Uses constructor of Parent class Employee
	 * @param fname The first name of the employee 
	 * @param lname The last name of the employee
	 */
	public Hostess(String fname, String lname) {
		super(fname, lname);
	}

}

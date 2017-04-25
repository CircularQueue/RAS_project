package model.employee;

/**
 * this class allows the cook to extend in to the employee 
 * it allows the the other employees to know when the food is ready 
 * it also allows this class to go in to the employees class and take all the 
 * information that is needed for this class 
 * @author Christina Sadhu
 */
public class Cook extends Employee{
	
	/**
	 * Constructor
	 * Uses constructor of Parent class Employee
	 * @param fname The first name of the employee 
	 * @param lname The last name of the employee
	 */
	public Cook(String fname, String lname) {
		super(fname, lname);
	}

	

}

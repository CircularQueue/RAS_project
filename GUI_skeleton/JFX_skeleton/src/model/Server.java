package model;

import java.util.ArrayList;

/**
 * A Child class of Employee representing a server. 
 * An employee which is a Server is responsible for taking Orders, and delivering cooked food to tables.
 * @author Phillip Witkin
 *
 */
public class Server extends Employee{
	
	/**
	 * Constructor
	 * Uses constructor of Parent class Employee
	 * @param fname The first name of the employee 
	 * @param lname The last name of the employee
	 */
	public Server(String fname, String lname) {
		super(fname, lname);
		
	}

	/**
	* This method shows all of the tables that the server is responsible for attending.
	* These are those tables where the table's employeeID is the same as the employee's ID
	* 
	*@return An ArrayList of all the tables in this server's section
	*/
	public ArrayList<Table> getAllTablesServed(){
		return null;
	}             
	 

}

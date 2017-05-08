package model.employee;



import java.util.HashMap;



/**

 * Contains employeeID, and the name of the employees first and last name 

 * class name employee

 * description: this class would allow employees to input their id name how many hours they are assigned to what

 * days they are working and if they are suppose to be working that day.

 * @author Christina Sadhu

 */

public class Employee {

	



	private int employeeID;

	private String employeeType;

	private String name;

	private boolean workingNow;

	

	private HashMap<String, Double[]> assignedHours;

	

	

	/**

	 * Constructor

	 * @param fname The employee's first name

	 * @param lname The employee's last name

	 * this will allow access to the employees first and last name

	 */

	public Employee (String fname, String lname){

            this.name = fname+" "+lname;

        }

	

	/**

	 * Sets the name of the employee

	 * @param fname The employee's first name

	 * @param lname The employee's last name

	 */

	public void setEmployeeName(String fname, String lname){

            this.name = fname+" "+lname;

        }

	

	/**

	 * Gets the employee name

	 * @return The full name of the employee

	 */

	public String getEmployeeName(){

            return this.name;

        }

	 

	

	/**

	 * by having an employee id it allows them to log in and out of the system

	 * it also shows their full name when clocking in and out so they know how many hours this person has worked

	 * @return The employeeid

	 */

	public int getemployeeID(){

            return this.employeeID;

        }

	

	/**

	 * Allows the employeeID to be set, to match database records

	 * @param employeeID The employee's ID 

	 */

	public void setEmployeeID(int employeeID){

            this.employeeID = employeeID;

        }

	   

	 

	/**

	 * Set's which of the employee types the employee is in the system 

	 * @param employeetype One of the Child classes of Employee - Manager, Cook, Server, Hostess

	 */

	public void setEmployeeType(String employeetype){

            this.employeeType = employeetype;

        }

    

	/**

	 * Get's which type of employee Child class this employee belongs to

	 * @return The type of employee

	 */

	public String getEmployeeType(){

            return this.employeeType;

        }

	

	/**

	 * Allows the name of the employee to be changes

	 * @param name The name of the employee

	 */

	public void setName(String name){

            this.name = name;

        }

    

	/**

	 * Gets the full employee name

	 * @return The name of the employee

	 */

	public String getname(){return this.name;}

	 

	

	/**

	 * This method shows when the employee is scheduled to work

	 * @return A HashMap of Day as String to starting and ending times as a Double[] 

	 */

	public HashMap<String, Double[]> getAssignedHours(){return assignedHours;};

	

	 

	 /**

	  * this method would allow the workers to know that they are working now on certain shifts

	  *  @return If the employee is working

	  */

	public boolean getWorkingNow(){

            return this.workingNow;

	}

	 

	 /**

	  * This method allows the employee to clock in and clock out

	  * @param working True if the employee is clocking in, false when clocking out

	  */

	public void setWorkingNow(boolean working){

             this.workingNow = working;

        }

}


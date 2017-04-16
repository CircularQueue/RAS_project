package model;

import java.util.HashMap;
/** 
 * A Child class of Employee
 * Contains some special functions reserved only for Managers
 * @author Christina Sadhu.
*/

public class Manager extends Employee {
	/**
	 * Constructor
	 * Uses constructor of Parent class Employee
	 * @param fname The first name of the employee 
	 * @param lname The last name of the employee
	 */
	public Manager(String fname, String lname){
		super(fname, lname);
	}
	
	/**
	 * this method would basically allow the manager to add the employee in to the system. 
	 * it will also allow the manager to create a profile with an employee id for this new worker
	 * @param name The name of the new employee
	 */
	public void addemployee(String name){}
	
	
	 /** 
	  * this method finds an employee and removes them from the database
	  * @param employeeID The employeeID of the employee to be removed 
	  * @return The employee from the system that no longer works there 
	  */ 
	 public Employee removeEmployee(int employeeID){
		 return null;
	 }
	 
	 /**
	  * this method grabs the employees name and sets
	  * the employee on a certain day that they want to work
	  * @param name The employee name whose shift to update
	  * @param day The day of the shift
	  * @param start The shift start time
	  * @param end The shift end time
	  */
	 public void setAssignedHours(String name, String day, double start, double end){} 
	 
	 /**
	  * this method retrieves all the time stat and time end hours for all employees 
	  * it is a string where the employee name and double[] represents 
	  *  two numbers when they start and when they finish
	  * @return employees and hours worked 
	  * 
	  */
	 public HashMap<String, Double[]> getAllShifts()
		{
			return new HashMap<String, Double[]>();
		}
		
	 /** This method will show what day of the week employees are working 
	 * @param day is the day of the week 
	 * @return this method returns the day of the week each employee has been assigned to 
	 */
	public HashMap<Double, Double> getShiftsOnDay(String day){
		return new HashMap<Double, Double>();	
	}
	
		/**
		* Finds an employee's information from the database
		*@param name The name of the employee to be found
		*@return The Employee returned, so that their information can be displayed
		*/
	 public Employee findEmployeeInformation(String name){
		 return null;
	 }
	 
	 /**
	  * Update's some of an existing employee's data
	  * @param empData An Employee object, where the non-empty attributes are used to replace an Employee with the same employeeID
	  * @return An employee with the updated attributes
	  */
	 public Employee updateEmployee(Employee empData){
		 return null;
	 }
}

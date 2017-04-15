import java.util.HashMap;
/** @author christinasadhu
*class name: Manager extends to employee 
*description:Base class for types of employees
 Contains employeeID, and the name of the employees first and last name 
*/

public class Manager extends Employee {

	public Manager(String fname, String lname){
		super(fname, lname);
	}
	/**
	 * this method would basically allow the manager to add the employee in to the system. 
	 * it will also allow the manager to create a profile with an employee id for this new worker
	 * @param name
	 */
	public void addemployee(string name);
	
	
	 /** 
	  * this method finds an employee and removes them from the database 
	  * @param remove the employees from the system they no longer work there 
	  */ 
	 public Employee removeEmployee(){
		 return"";
	 }
	 /**
	  * this method retrieves all the time stat and time end hours for all employees 
	  * it is a string where the employee name presumable double represents 
	  *  two numbers when they start and when they finish
	  * @param employees and hours worked 
	  * 
	  */
	 public HashMap<String, Double[]> getAllShifts()
		{
			return new HashMap<String, Double[]>();
		}
		/*this method will show what day of the week employees are working 
		 * @param is the day of the week 
		 * this method returns the day of the week each employee has been assigned to 
		 */
		public HashMap<Double, Double> getShiftsOnDay(String day){
			return new HashMap<Double, Double>();
			
		}
		/**
		* --put description here (finds an employee’s information from the database)--
		*@param name – The name of the employee to be found
		*@return The Employee returned, so that their information can be displayed
		*/
	 public Employee findEmployeeInformation(string name);
	 "return null"
}

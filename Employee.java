import java.util.Hashmap;
import java.util.Set;
/**
 * 
 * @author christinasadhu
 *class name: Employees 
 *description this class sets a the schedule depending on the availablilty, requested time
 *and the shifts that are taken
 */
/**Base class for types of employees
 * Contains employeeID, and the name of the employees first and last name 
 * class name employee
 * descroption: this class would allow employees to input their id name how many hours they are assigned to what
 * days they are working and if they are suppose to be working that day.
 */
public class Employee {
	

	private employeeID;
	private employeeType;
	private name;
	public getAllTablesServed;
	public getTablesCleaned;
	public seatCustomers;
	public getAllFoodReady;
	private HashMap<String, Double[]> assignedHours;
	private boolean workingNow;
	
	/**
	 * 
	 * @param fname
	 * @param lname
	 * this will allow access to the employees first and last name
	 */
	public Employee (String fname, String lname);
	  public void setEmployee(String fname,lname){}
	    public String getEmployee(){}
	 
	
	
	/**
	 * by having an employee id it allows them to log in and out of the system
	 * it also shows their full name when clocking in and out so they know how many hours this person has worked
	 * @param employeeid
	 */
	private getemployeeID(int employeeid);
	  public void setEmployeeID(in employeeID){}
	    public int getEmployeeID(){}
	 
	
	/**
	 * 
	 */
	private employeetype(String);
	public void setemployeetype(String employeetype){}
    public String getemployeetype(){}
	
	/**
	 * this method grabs the employees name and sets
	 * the employee on a certain day that they want to work
	 * @param name
	 */
	private getname(String name);
	public void setgetname(String getname){}
    public String getname(){}
	 
	

	 private HashMap<String, Double[]> assignedHours;
	"returns assignedhours";
	 
	 /**
	  * this method would allow the workers to know that they are working now on certain shifts
	  *  it will also allow the managers to know which employees were assigned which shifts and 
	  *  when they are suppose to be working 
	  *  @param workingNow
	  */
	 private boolean workingNow;
	 "returns null";
	 	 
	}
	
}

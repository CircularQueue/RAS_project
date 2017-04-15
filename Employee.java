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
	private getAllTablesServed;
	private getTablesCleaned;
	private seatCustomers;
	private getAllFoodReady;
	private HashMap<String, Double[]> assignedHours;
	private boolean workingNow;
	
	/**
	 * 
	 * @param fname
	 * @param lname
	 * this will allow access to the employees first and last name
	 */
	public Employee (String fname, String lname);
		"return"
	
	
	/**
	 * by having an employee id it allows them to log in and out of the system
	 * it also shows their full name when clocking in and out so they know how many hours this person has worked
	 * @param employeeid
	 */
	private getemployeeID(int employeeid);
	"return employeeid";
	public final void setemployeeid(int employeeid)
	this.setemployeeid(employeeid); 
	
	
	/**
	 * 
	 */
	private employeetype(String);
	"returns employeetype";
	
	/**
	 * this method grabs the employees name and sets
	 * the employee on a certain day that they want to work
	 * @param name
	 */
	private getname(String name);
	"return";
	public final viod setname(String name) 
	
	/**
	 * this has the server attend to all the table and layout their food after it has been cooked 
	 * it also allows the server to take their orders and attend to all the cutomers needs when needed
	 * the servers hands the food out to specific people
	 * @param getAllTablesServed
	 * 
	 */
	private getAllTablesServed;
	"return service";
		
	/**
	 * @param getTablesCleaned
	 * the busboy cleans all the tables
	 * the busboy has it set up for the next customer that is ready to be seated at the table
	 *
	 */
	private getTablesCleaned;
	"return"
	Set<alltbalescleaned>
	
	/**
	 * the hostess brings the customers to the empty table
	 * the hostess then seat the customers at the table 
	 * @param seatCustomer
	 */
	private seatCustomers;
	"return seatCustomer"
	/**
	 * once the server takes the customers order 
	 * they will then send the order back in to the kitchen for the cooks 
	 * the cooks then will prepare the food for customers and alert the server when the food is ready
	 * once the food is already the server then serves the food to the customer
	 */
	private getAllFoodReady;
	"retun food"
	/**
	 * this allows the manager to assign the amount of hours to be worked by each employee 
	 *they can be assigned a certain day with a certain amount of hours that they would be working for that day 
	 *
	 */
	 private HashMap<String, Double[]> assignedHours;
	"returns assignedhours";
	 
	 /**
	  * this method would allow the workers to know that they are working now on certain shifts
	  *  it will also allow the managers to know which employees were assigned which shifts and 
	  *  when they are suppose to be working 
	  */
	 private boolean workingNow;
	 "returns workingnow";
	 	 
	}
	
}

package model.employee;

import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnectionJDBC;
import model.table.Table;

/**
 * This class has JDBC database level implementations of all the methods in EmployeeManagement
 * @author phillipwitkin
 *
 */
public class EmployeeManagementJDBC {
	   
	   static Connection conn = null;
	
	/**
	 * Constructor
	 */
	public EmployeeManagementJDBC() {
		EmployeeManagementJDBC.conn = ConnectionJDBC.getDB();
	}

	/**
	 * this method would basically allow the manager to add the employee in to the system. 
	 * it will also allow the manager to create a profile with an employee id for this new worker
	 * @param name The name of the new employee; the employeeID will be determined upon database action.
	 * @return The new employee, with an employeeID consistent with its corresponding database entry
	 */
	public Employee addemployee(String name){return null;}
	
	
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
	  * @return employees and hours worked , as a hash map with a key String representing the day, and a Double array representing start and stop times
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
	 
		/**
		* This method shows all of the tables that a server is responsible for attending.
		* These are those tables where the table's employeeID is the same as the employee's ID
		* @param serverID The ID of the server whose tables we want to see
		*@return An ArrayList of all the tables in this server's section
		*/
		public ArrayList<Table> getAllTablesServed(int serverID){
			return null;
		}
		

		public Employee findEmployeeInformation(int employeeID){
			Employee foundEmployee = null;
			
			PreparedStatement stmtPrep = null;
			ResultSet rs = null;
			try {
				
				stmtPrep = conn.prepareStatement("SELECT * FROM Employees WHERE employeeID = ?");
				stmtPrep.setInt(1, employeeID);
				rs = stmtPrep.executeQuery();

				while (rs.next()){
					String empName = rs.getString("Employee_name");
					String empType = rs.getString("Employee_Type");
					Boolean workingNow = new Boolean(rs.getBoolean("working_now"));
//			    	
			    	
			    	foundEmployee = new Employee(empName, empType, workingNow);
			    	
			    	
			    	System.out.println("serverID: " + employeeID + ", name " + empName);
				}
				
			} catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
			
			return foundEmployee;
		}

}

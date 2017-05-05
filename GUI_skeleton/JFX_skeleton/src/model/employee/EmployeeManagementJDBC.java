package model.employee;


import java.util.ArrayList;
import java.util.HashMap;

import model.ConnectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class has JDBC database level implementations of all the methods in EmployeeManagement
 * @author christina sadhu 
 *
 */
public class EmployeeManagementJDBC {
	   
	  private static Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private ConnectionJDBC cjdbc = new ConnectionJDBC();
	

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
	 * @throws ClassNotFoundException 
	 */
	public Employee addemployee(Employee employeetoAdd) 
	{        
		
		String sql = "INSERT INTO Employees" + "(Employee_name, Employee_type, working_now)" + " VALUES " + "(\'" + employeetoAdd.getEmployeeName() + "\', \'" + employeetoAdd.getEmployeeType() + "\', " + employeetoAdd.getWorkingNow() + ");";
		
		try{
//			conn = ConnectionJDBC.getDB();
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate();
			
			int affectedRows = st.executeUpdate();
			if (affectedRows == 0) {
			throw new SQLException("Creating user failed, no rows affected.");
			}
			// get key from last insert
			Integer employeeID = null;
			try (ResultSet keySet = st.getGeneratedKeys()) {
				if (keySet.next()) {
					employeeID = new Integer (keySet.getInt(1));
				}
				else {
					employeetoAdd.setEmployeeID(employeeID);
				}                                   
			}              
			
		} catch (SQLException ex){
			                        // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		              
		}                   
			                    
			
			return employeetoAdd;
		
		
	}
	// get ID of newly inserted db row
    // check to see that insert was sucesseful

                  
    
//        try
//        {
//        	String sqlstatement = "'" + EmployeetoAdd.getemployeeID()
//        						   + "', '"
//        						   + EmployeetoAdd.getEmployeeName()
//        						   +"', '"
//        						   + EmployeetoAdd.getEmployeeType()
//        						   +"', '"
//        						   + EmployeetoAdd.getWorkingNow()
//        		
                   // get ID of newly inserted db row
                     // check to see that insert was sucesseful
               //*  int affectedRows = stmtPrep.executeUpdate();
                // if (affectedRows == 0) 
                 //{
                   //  throw new SQLException("Creating user failed, no rows affected.");
                // }
                 // get key from last insert
                // Integer employeeID;
                 //try (ResultSet keySet = stmtPrep.getGeneratedKeys()) 
                 //{
                  //??   if (rs.next()) 
                    // {
                 //       employeeID = new Integer (rs.getInt(1));
                 //    }
                // else 
               //  {
                    //           employeeID.setEmployeeID(employeeID);
                                                            
                   //            catch (SQLException ex){
                                  // handle any errors
                    //             System.out.println("SQLException: " + ex.getMessage());
                      //           System.out.println("SQLState: " + ex.getSQLState());
                  //                System.out.println("VendorError: " + ex.getErrorCode());
                //  }
                ///               // get attributes from employee
                      //         String status = Employee.getstatus();
                      //         Integer empID = Employee.getemployeeID();
                       //        Integer occupancy = Employee.getMaxOccupancy(); */            
     
//	
	
	 /** 
	  * this method finds an employee and removes them from the database
	  * @param employeeID The employeeID of the employee to be removed 
	  * @return The employee from the system that no longer works there 
	 * @throws ClassNotFoundException 
	  * 
	  */ 
	 public Employee removeEmployee(String employeeName) 
	 {
		 String sql = "DElETE FROM Employees where employeeName= " + employeeName + ";";
		 
		 Employee removeEmployee= findEmployeeInformation(employeeName);
		 
		 try{
//			 conn = ConnectionJDBC.getDB();
			 st = conn.prepareStatement(sql);
			 st.executeUpdate(sql);
			 return removeEmployee;
		 }
		 catch(SQLException e){
			 System.out.print(e.getStackTrace());
		 }
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
			//HashMap<String, Double[] >getAllShifts = new HashMap<>();
			// map get all the days and times that the employees will be working 
			//HashMap<String,Double> getAllShifts = new HashMap<>();
			
			//PreparedStatement stmtPrep = null;
			//ResultSet rs = null;
			
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
		 * @throws ClassNotFoundException 
		*/
	 public Employee findEmployeeInformation(String name) {
		 
//		 String query = "SELECT * FROM Employees WHERE Employee_name = \'" + name + "\';";
//		 try{
////			 conn = ConnectionJDBC.getDB();
//			 st = conn.prepareStatement(query);
//			 rs = st.executeQuery(query);
//			 while(rs.next()){
//				 return new Employee(rs.getString("Employee_name"), rs.getString("Employee_type"), rs.getBoolean("working_now"));
//			 }
//		 }
//			 catch(SQLException e){
//				 System.out.println(e.getStackTrace());
//			 }
//		 return null;
//		 }
		 
			Employee foundEmployee = null;
//			
			PreparedStatement stmtPrep = null;
			ResultSet rs = null;
			try {
//				
				stmtPrep = conn.prepareStatement("SELECT * FROM Employees WHERE Employee_name = ?");
				stmtPrep.setString(1, name);
				rs = stmtPrep.executeQuery();
//
				while (rs.next()){
					String statusUpdate = rs.getString("Employee_name");
					Integer empID = new Integer(rs.getInt("employeeID"));
					Boolean workingNow = new Boolean( rs.getBoolean("working_now") );
			    	String employee_type = rs.getString("Employee_type");
			    	
			    	foundEmployee = new Employee(statusUpdate, employee_type, workingNow);
			    	foundEmployee.setEmployeeID(empID);
			    	foundEmployee.setWorkingNow(workingNow);
			    	foundEmployee.setEmployeeType(employee_type);
			    	
				}
				
			} catch (SQLException ex)
			{
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
			
			return foundEmployee;
		
	}
	 
	 /**
	  * Update's some of an existing employee's data
	  * @param empData An Employee object, where the non-empty attributes are used to replace an Employee with the same employeeID
	  * @return An employee with the updated attributes
	  */
	 public Employee updateEmployee(Employee empData){
		 Employee updatedEmployee = null;
			
			PreparedStatement stmtPrep = null;
			ResultSet rs = null;
			
			try {
				
				stmtPrep = conn.prepareStatement("UPDATE Employee SET Employee_status = ? WHERE empdata = ?");// INNER JOIN Employees WHERE employees.empdata = Employees.employeename");
//				rs = stmtPrep.executeUpdate();
//				stmtPrep.setString(1, empData);
//				stmtPrep.setInt(2,empData);
				// execute insert SQL stetement
				stmtPrep.executeUpdate();
				
			} catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
			

		return null;
		
	 }
	 
		

		/**
		* This method shows all of the tables that a server is responsible for attending.
		* These are those tables where the table's employeeID is the same as the employee's ID
		* @param serverID The ID of the server whose tables we want to see
		*@return An ArrayList of all the tables in this server's section
		*/
//		public ArrayList<Table> getAllTablesServed(int serverID){
//			return null;
//		}
		


}

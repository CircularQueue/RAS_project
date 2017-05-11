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

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.ConnectionJDBC;
import model.table.Table;

/**
 * This class has JDBC database level implementations of all the methods in EmployeeManagement
 * @author phillipwitkin
 *
 */
public class EmployeeManagementJDBC {
	   
	   static Connection conn = null;
	   Statement stmt;
	
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
	public Employee addemployee(String name){
		Employee employeetoAdd = new Employee(name);
		String sql = "INSERT INTO Employees" + "(Employee_name, Employee_type, working_now)" + " VALUES " + "(\'" + employeetoAdd.getEmployeeName() + "\', \'" + employeetoAdd.getEmployeeType() + "\', " + employeetoAdd.getWorkingNow() + ");";
		PreparedStatement prepstmt;
		try{
//			conn = ConnectionJDBC.getDB();
			prepstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			
			int affectedRows = prepstmt.executeUpdate();
			
			if (affectedRows == 0) {
			throw new SQLException("Creating user failed, no rows affected.");
			}
			// get key from last insert
			Integer employeeID = null;
			try (ResultSet keySet = prepstmt.getGeneratedKeys()) 
			{
				if (keySet.next()) 
				{
					employeeID = new Integer (keySet.getInt(1));
				}
				else 
				{
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
	
	/**
	 * this method would basically allow the manager to add the employee in to the system. 
	 * it will also allow the manager to create a profile with an employee id for this new worker
	 * @param name The name of the new employee; the employeeID will be determined upon database action.
         * @param type
         * @param bool
	 * @return The new employee, with an employeeID consistent with its corresponding database entry
	 */
	public Employee addemployee(String name,String type,int bool){
            String[] names = name.split(" ");
            Employee emp = new Employee(names[0],names[1]);
            emp.setEmployeeType(type);
            emp.setName(name);
            emp.setWorkingNow((bool != 0));
            
            // getting ID from databse
            int id = this.getIDfromDB();
            
            emp.setEmployeeID(id);
            
            //adding employee into database
            
            try{
                stmt = conn.createStatement();
                String query;
                query = "INSERT INTO employees VALUES (" + "'" +emp.getemployeeID()+ "','" +emp.getEmployeeName()+ "','"+emp.getEmployeeType()+"','"+bool+"')";
                
                int result = stmt.executeUpdate(query);
                if(result>0)
                    JOptionPane.showMessageDialog(null, "Data Successfully Saved","INFO", 1);
                }catch(MySQLIntegrityConstraintViolationException ex){
                    JOptionPane.showMessageDialog(null,"Duplicate Entry ","Error",0);
                }catch(SQLException | HeadlessException ex){
                    JOptionPane.showMessageDialog(null,"Error Executing the Query","Error", 0);
                    
                }
           
            return emp;
        
        }
	
	
	 /** 
	  * this method finds an employee and removes them from the database
	  * @param employeeID The employeeID of the employee to be removed 
	  * @return The employee from the system that no longer works there 
	  */ 
	 public Employee removeEmployee(int employeeID){
		 
		 Employee toDelete = this.findEmployeeInformation(employeeID);
		 
		 
		 try{
             stmt = conn.createStatement();
             String query = "DELETE FROM employees WHERE employeeID='"+employeeID+"'";
             int result = stmt.executeUpdate(query);
             if(result>0){
                 JOptionPane.showMessageDialog(null, "Record deleted Successfully","INFO",3);
                 
             }
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error in SQL or record not found","ERROR",0);
             ex.printStackTrace();
         }
         
         return toDelete;
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
			try{
                stmt = conn.createStatement();
                int bool=0;
                if(empData.getWorkingNow()){
                    bool = 1;
                }else{
                    bool = 0;
                }
                String query = "UPDATE employees SET Employee_name='"+empData.getEmployeeName()+"',"+"Employee_type='"+empData.getEmployeeType()+"',"+"working_now='"+bool+"' WHERE employeeID='"+empData.getemployeeID()+"'";
                int result = stmt.executeUpdate(query);
                if(result>0){
                    JOptionPane.showMessageDialog(null,"Data Updated Successfully","Information",1);
                }
            }catch(HeadlessException | SQLException ex){
                JOptionPane.showConfirmDialog(null,"Error in SQL","Error",0);
            
            }
            return empData;
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


		public int getIDfromDB(){
	            int id=0;
	            try {
	                stmt = conn.createStatement();
	                String query = "SELECT MAX(employeeID) FROM employees";
	                ResultSet rs = stmt.executeQuery(query);
	                rs.next();
	                id = rs.getInt(1);
	                id = id +1;
	                System.out.println(id);
	            } catch (SQLException ex) {
	                System.out.println("Error in SQL");
	            }
	            
	            return id;
	        
	        }
}

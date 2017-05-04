package model.table;

import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ConnectionJDBC;
import model.employee.Employee;

/**
 * This class contains the JDBC functionality for the TableList class.
 * @author Phillip Witkin
 *
 */
public class TableListJDBC {

	   
	   static Connection conn = null;
	/**
	 * Constructor;
	 * Establishes a database connection.
	 */
	public TableListJDBC(){
		TableListJDBC.conn = ConnectionJDBC.getDB();
	}
	
	/**
	 * Adds a table to the restaruant's layout
	 * @param tbl The new table to be added. The tableID will only be determined after insertion into the database.
	 * @return Returns the Table object added to the database; it will have an tableID consistent with the entry in the database
	 */
	public Table addTable(Table tbl){
		// get attributes from tbl
		String status = tbl.getStatus();
		Integer empID = tbl.getServerSection();
		Integer occupancy = tbl.getMaxOccupancy();
		// prepare query
		PreparedStatement stmtPrep = null;
		ResultSet rs = null;
		try {
			String sqlInsert = "INSERT INTO 'Tables' (Table_Status, employeeID, max_occupancy) VALUES (?,?,?)";
			// insert a new row into database
			stmtPrep = conn.prepareStatement(sqlInsert,  Statement.RETURN_GENERATED_KEYS);//* FROM Tables WHERE tableID = ?");
			stmtPrep.setString(1, status);
			stmtPrep.setInt(2, empID);
			stmtPrep.setInt(3, occupancy);
			// execute 
			stmtPrep.executeUpdate();

			// get ID of newly inserted db row
			// check to see that insert was sucesseful
		    int affectedRows = stmtPrep.executeUpdate();
		    if (affectedRows == 0) {
		        throw new SQLException("Creating user failed, no rows affected.");
		    }
		    // get key from last insert
		    Integer tableID;
		    try (ResultSet keySet = stmtPrep.getGeneratedKeys()) {
		        if (rs.next()) {
		           tableID = new Integer (rs.getInt(1));
				    // set the tbl object's ID to the new Id key from the database
		           tbl.setTableID(tableID);
		        }
		        else {
		        	throw new SQLException("Creating user failed, no ID obtained.");
		        }	
		    }
		    
		}catch (SQLException ex){
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
		}	
				
		return tbl;
				
	}
		        
		            
		        
	
	
	/**
	 * 
	 * @param tableID The ID of the table to remove
	 * @return The removed table
	 */
	public Table removeTable(int tableID){
		
		Table table = this.searchTableDetails(tableID);
		if (table == null){
			return null;
		}
		
		PreparedStatement stmtPrep = null;
		
		try {
			
			stmtPrep = conn.prepareStatement("DELETE Tables WHERE tableID = ?");// INNER JOIN Employees WHERE Tables.tableID = Employees.employeeID");
			stmtPrep.setInt(1, tableID);
			// execute insert SQL stetement
			stmtPrep.executeUpdate();
			
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		return table;
	}
	
	/**
	 * Assigns a group of tables to specific employee
	 * @param emp The employee that the tables are being assigned to
	 * @param tables An arrayList of tables which belong to the employee 
	 */
	public void createServerSection(int employeeID, ArrayList<Table> tables){
		
		PreparedStatement stmtPrep = null;
//		ResultSet rs = null;
		
		try {
			
			stmtPrep = conn.prepareStatement("UPDATE Tables SET employeeID = ? WHERE tableID = ?");// INNER JOIN Employees WHERE Tables.tableID = Employees.employeeID");

			for (Table table : tables){
				stmtPrep.setInt(1, employeeID);
				stmtPrep.setInt(2, table.getTableID());
				// execute update SQL stetement
				stmtPrep.executeUpdate();
			}

			
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
	}
	
	/**
	 * See all the tables in the section of a specific server
	 * @param employeeID The ID of the employee whose tables we want to check
	 * @return The Tables in the section of the employee whose ID matches employeID
	 */
	public ArrayList<Table> getTablesInSection(int employeeID){
		
		PreparedStatement stmtPrep = null;
		ResultSet rs = null;
		
		// array of tables in the section to be returned
		ArrayList<Table> sectionTables = new ArrayList<>();
		
		try {
			// prepare query
			stmtPrep = conn.prepareStatement("SELECT * FROM Tables WHERE employeeID = ?");// INNER JOIN Employees WHERE Tables.tableID = Employees.employeeID");
			rs = stmtPrep.executeQuery();
			stmtPrep.setInt(1, employeeID);
			
			// iterate through results
		    while (rs.next()){
		    	// get all the column attributes for each row r
		    	String status = rs.getString("Table_status");		    	
		    	Integer empID = new Integer(rs.getInt("employeeID"));
		    	Integer tableID = new Integer( rs.getInt("tableID") );
		    	Integer occupancy = new Integer(rs.getInt("max_occupancy"));
		    	
		    	System.out.println("Found.... TableID: " + tableID + ", serverID: " + empID + ", occupancy: " + occupancy + ", stats: " + status);
		    	// make a table object from the row's attributes
		    	Table table = new Table(tableID, occupancy);
		    	table.setServerSection(empID);
		    	table.updateTableStatus(status);
		    	
		    	// add it to the section array
				sectionTables.add(table);
				
		    }
		    
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return sectionTables;
	}
	
	/**
	 * View all of the server sections
	 * @return A hashMap of employeeID's and tables, with an Employee object as the key and a Table array as the value
	 * 
	 */
	public HashMap<Integer, ArrayList<Table> > viewServerSections(){
		
		HashMap<Integer, ArrayList<Table> > sections = new HashMap<>();
		// map tableID to Table
		HashMap<Integer, Table> allTables = new HashMap<>();
		
		PreparedStatement stmtPrep = null;
		ResultSet rs = null;
		
		try {
			
			stmtPrep = conn.prepareStatement("SELECT * FROM Tables");// INNER JOIN Employees WHERE Tables.tableID = Employees.employeeID");
			rs = stmtPrep.executeQuery();
			
			ArrayList<Table> tblArr;
		    while (rs.next()){
		    	//System.out.println("PartName: " + rs.getString("Part_Description"));
//		    	String empId = rs.getString("employeeID");
//		    	String tableId = rs.getString("tableID");
//		    	String max_oc = rs.getString("max_occupancy");
		    	String status = rs.getString("Table_status");
		    	
		    	Integer empID = new Integer(rs.getInt("employeeID"));
		    	Integer tableID = new Integer( rs.getInt("tableID") );
		    	Integer occupancy = new Integer(rs.getInt("max_occupancy"));
		    	
		    	System.out.println("Found.... TableID: " + tableID + ", serverID: " + empID + ", occupancy: " + occupancy + ", stats: " + status);
//		    	int empID = Integer.parseInt(empId);
//		    	int tableID = Integer.parseInt(tableId);
//		    	int occupancy = Integer.parseInt(max_oc);
		    	
		    	Table table = new Table(tableID, occupancy);
		    	table.setServerSection(empID);
		    	table.updateTableStatus(status);
		    	
				if (!sections.containsKey(empID)){
					tblArr = new ArrayList<>();
					tblArr.add(table);
					sections.put(empID,  tblArr );
				} else {
					tblArr = sections.get(empID);
					tblArr.add(table);
				}
				
//				System.out.println(sections);
//				System.out.println("TableID: " + tableID + ", serverID: " + empID + ", occupancy: " + occupancy + ", stats: " + status);
		    }
		    
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return sections;
	}
	
	/**
	 * Changes a table status to the given new status
	 * @param tableID The ID of the table we want to update
	 * @param status The new status of the table 
	 * @return A copy of the updated table object
	 */
	public Table changeTableStatus(int tableID, String status){
		Table updatedTable = null;
		
		PreparedStatement stmtPrep = null;
		ResultSet rs = null;
		
		try {
			
			stmtPrep = conn.prepareStatement("UPDATE Tables SET Table_status = ? WHERE tableID = ?");// INNER JOIN Employees WHERE Tables.tableID = Employees.employeeID");
//			rs = stmtPrep.executeUpdate();
			stmtPrep.setString(1, status);
			stmtPrep.setInt(2, tableID);
			// execute insert SQL stetement
			stmtPrep.executeUpdate();
			
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		updatedTable = this.searchTableDetails(tableID);
	
		
		return updatedTable;
		
	}
	
	
	/**
	 * This method Searches for a specific table from TableList, so that all of the details can be viewed, or the table updated
	 * @param tableID The ID of the table to be retrieved
	 * @return A Table with the matching tableID
	 */
	public Table searchTableDetails(int tableID){
		Table foundTable = null;
		
		PreparedStatement stmtPrep = null;
		ResultSet rs = null;
		try {
			
			stmtPrep = conn.prepareStatement("SELECT * FROM Tables WHERE tableID = ?");
			stmtPrep.setInt(1, tableID);
			rs = stmtPrep.executeQuery();

			while (rs.next()){
				String statusUpdate = rs.getString("Table_status");
				Integer empID = new Integer(rs.getInt("employeeID"));
//		    	Integer tableID = new Integer( rs.getInt("tableID") );
		    	Integer occupancy = new Integer(rs.getInt("max_occupancy"));
		    	
		    	foundTable = new Table(tableID, occupancy);
		    	foundTable.setServerSection(empID);
		    	foundTable.updateTableStatus(statusUpdate);
		    	
		    	System.out.println("TableID: " + tableID + ", serverID: " + empID + ", occupancy: " + occupancy + ", stats: " + statusUpdate);
			}
			
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		return foundTable;
		
	}
	
	
	
	
	
	
	
	
	/**
	 * This is used in order to modify seating. It links together many tables together through a virtual ID into one new table, with a combined number of seats for larger parties.
	 * @param linkedTables An arrayList of tables which we want to combine together 
	 * @return One Table aggregated from the  
	 */
	public Table combineTables(ArrayList<Table> linkedTables){
		return null;
	}

	/**
	 * This is used in order to modify seating. It splits up table linked together back into several smaller tables.
	 * @param combinationTable The combined table that we want to split up
	 * @return An ArrayList of individual tables 
	 */
	public ArrayList<Table> splitTable(Table combinationTable){
		return null;
	}
	

}

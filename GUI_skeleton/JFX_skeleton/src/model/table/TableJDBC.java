package model.table;

import java.util.ArrayList;
import java.util.HashMap;


import model.employee.Employee;

/**
 * This class contains the JDBC functionality for the Table and TableList class.
 * It implements the CommonJDBC interface, with some additional methods specific for Tables
 * @author Phillip Witkin
 *
 */
public class TableJDBC {

	/**
	 * Constructor;
	 * Establishes a database connection.
	 */
	public TableJDBC(){
		
	}
	
	/**
	 * Adds a table to the restaruant's layout
	 * @param tbl The new table to be added
	 */
	public void addTable(Table tbl){
		
	}
	
	/**
	 * 
	 * @param tableID The ID of the table to remove
	 * @return The removed table
	 */
	public Table removeTable(int tableID){
		return null;
	}
	
	/**
	 * Assigns a group of tables to specific employee
	 * @param emp The employee that the tables are being assigned to
	 * @param tables An arrayList of tables which belong to the employee 
	 */
	public void createServerSection(Employee emp, ArrayList<Table> tables){
		
	}
	
	/**
	 * See all the tables in the section of a specific server
	 * @param emp The employee whose tables we want to check
	 * @return The Tables in the section of emp
	 */
	public ArrayList<Table> getTablesInSection(Employee emp){
		return null;
	}
	
	/**
	 * View all of the server sections
	 * @return A hashMap of employees and tables, with an Employee object as the key and a Table array as the value
	 * 
	 */
	public HashMap<Employee, Table[]> viewServerSections(){
		return null;
	}
	
	/**
	 * This method Searches for a specific table from TableList, so that all of the details can be viewed, or the table updated
	 * @param tableID The ID of the table to be retrieved
	 * @return A Table with the matching tableID
	 */
	public Table searchTableDetails(int tableID){
		return null;
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

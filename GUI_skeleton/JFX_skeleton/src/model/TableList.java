package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author phillipwitkin
 * Contains all of the tables used. 
 * Serves as a container for the table layout in the restaurant
 */
public class TableList {

	HashMap<Integer, Table> tables;
	
	/**
	 * Constructor
	 * Retrieves all of the tables from the database
	 */
	public TableList(){
		
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

	
	
	
}

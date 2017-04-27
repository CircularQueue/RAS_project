package model.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.employee.Employee;

/**
 * This is collection class for Table, and contains all of the tables used. 
 * Serves as a container for the table layout in the restaurant
 * @author Phillip Witkin
 */
public class TableList {

	/**
	 * All tables in the restaurant observable layout
	 */
	private HashMap<Integer, Table> tableLayout;

	private HashMap<Integer, ArrayList<Table> > sections;
	/**
	 * Any Tables combined together under a virtual tableID
	 */
	private HashMap<Integer, Table> tableCombinations;
	
	TableListJDBC tableDB;
	/**
	 * Constructor
	 * Retrieves all of the tables from the database
	 */
	public TableList(){
		this.tableDB = new TableListJDBC();
		// retrieve tables from database
		this.sections =  this.viewServerSections();
		//Set<Map.Entry<Employee, Table[]>> sectionSet = sections.entrySet();
		HashMap <Integer, Table> layout = new HashMap<>();
		for ( Integer empID : sections.keySet() ){
			ArrayList<Table> tables = sections.get(empID);
			for (Table tbl : tables){
				layout.put(tbl.getTableID(), tbl);
			}
			
		}
		this.tableLayout = layout;
	}
	
	public HashMap<Integer, Table> getTableLayout(){
		return this.tableLayout;
	}
	

	
	/**
	 * Adds a table to the restaruant's layout
	 * @param tbl The new table to be added. The tableID will only be determined after insertion into the database.
	 * @return Returns the Table object added to the database; it will have an tableID consistent with the entry in the database
	 */
	public Table addTable(Table tbl){
		return null;
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
	public HashMap<Integer, ArrayList<Table> > viewServerSections(){
		return tableDB.viewServerSections();
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

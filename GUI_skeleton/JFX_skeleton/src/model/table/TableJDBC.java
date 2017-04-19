package model.table;

import java.util.ArrayList;
import java.util.HashMap;

import model.BaseJDBC;
import model.CommonJDBC;
import model.employee.Server;
/**
 * This class contains the JDBC functionality for the Table and TableList class.
 * It implements the CommonJDBC interface, with some additional methods specific for Tables
 * @author Phillip Witkin
 *
 */
public class TableJDBC extends BaseJDBC<Table> implements CommonJDBC<Table>{

	/**
	 * Constructor;
	 * Establishes a database connection.
	 */
	public TableJDBC(){
		
	}
	
	@Override
	public Table finByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Table> findWhere(String SQLWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table update(Table updatedTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table create(Table newTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table deleteByID(int tabkeID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Finds the Server whose employeeID matches the tableID; Identifies the Server section the table belongs to.
	 * @param tableID The ID of the table to search for.
	 * @return A Server object who has a section which includes the table; the Server's employeeID will match the table's employeeID. Returns null if no matching Server can be found.
	 */
	public Server findServerForTable(int tableID){
		return null;
	}
	
	/**
	 * Finds all of the Tables in the section of a Server; any Table where the server's employeeID matches the Table.
	 * @param serverID The employeeID of the Server whose section of tables we want to retrieve
	 * @return All tables in the section of the Server with the given employeeID 
	 */
	public ArrayList<Table> findTablesForServer(int serverID){
		return null;
	}
	
	/**
	 * Gets a complete breakdown of which tables belong to which server section. Each server has at least one table with their employeeID;
	 * this method returns a map of all the servers, and for each server, a list of their tables.
	 * @return A HashMap of Servers and ArrayLists of Tables associated with each Server.
	 */
	public HashMap<Server, ArrayList<Table> > getAllServerSections(){
		return null;
	}
	
	
	
	

}

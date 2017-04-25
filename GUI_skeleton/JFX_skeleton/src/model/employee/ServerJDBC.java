package model.employee;

import java.util.ArrayList;

import model.table.Table;

/**
 * Child of EmployeeJDBC; specialized JDBC methods for Manager
 * @author Phillip Witkin
 *
 */
public class ServerJDBC extends EmployeeJDBC {

	/**
	 * Constructor. Establishes database connection
	 */
	public ServerJDBC() {
		// establish DB connection
	}

	
	/**
	 * Finds a Server by their employeeID
	 * 
	 * @return A server whose employeeID matches the database; returns null if no match is found.
	 */
	public Server finByID(int serverID) {
		return null;
	}

	/**
	 * Returns an EmployeeList of Servers matching the condition of the SQLWhere string
	 */
	@Override
	public EmployeeList<Server> findWhere(String SQLWhere) {
		return null;
	}
	
	/**
	 * Finds all of the Tables in the Server's section
	 * @param serverID The employeeID of the Server
	 * @return an ArrayList of Tables which make up the Server's section
	 */
	public ArrayList<Table> findServerTables(int serverID){
		return null;
	}
}

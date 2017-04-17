package model.employee;

import java.util.ArrayList;

import model.table.Table;

/**
 * Child of EmployeeJDBC; specialized JDBC methods for Manager
 * @author Phillip Witkin
 *
 */
public class ServerJDBC extends EmployeeJDBC {

	public ServerJDBC() {
		// establish DB connection
	}

	
	
	public Server finByID(int serverID) {
		return null;
	}


	public EmployeeList<Server> findWhere(String SQLWhere) {
		return null;
	}
	
	public Server create(Server newEmloyee) {
		return null;
	}
	
	public ArrayList<Table> findServerTables(int serverID){
		return null;
	}
}

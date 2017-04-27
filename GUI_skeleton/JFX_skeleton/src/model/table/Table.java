package model.table;
/**
 * A single table in the restaurant
 */
public class Table {

	/**
	 *The ID associated with the table in the database 
	 */
	private int tableID;
	/**
	 * The employeeID of the server assigned to this table 
	 */
	private int employeeID;
	/**
	 * The maximum number of seats available at the table
	 */
	private int maxOccuppancy;
	/**
	 * The current status of the table (empty/seated/dirty,etc) 
	 */
	private String status;
	
	/**
	 * Default Constructor
	 * Sets tableID, serverSection, and maxOccupancy to 0
	 * Sets status to "empty"
	 */
	public Table(){
		
	}
	
	/**
	 * Constructor, to create a table with just the occupancy
	 * @param occupancy The maximum number of people that can be seated
	 * Sets the tableID
	 */
	public Table(int occupancy){
		
	}
	
	/**
	 * Constructor, to create a table with both the ID and occupancy
	 * @param tableID the ID associated with the Table in the database
	 * @param occupancy the maximum number of people that can be seated at a table
	 * Sets the tableID and maxOccupancy
	 */
	public Table(int tableID, int occupancy){
		
	}
	
	/**
	 * This sets the ID of the table object 
	 * @param tableID The ID associated with a table entry in the database
	 */
	public void setTableID(int tableID){
	}
	
	/**
	 * This gets the ID associated with the table
	 * @return The value of tableID
	 */
	public int getTableID(){
		return this.tableID;
	}
	

	
	/**
	 * Associate the table with the ID of an employee (server) whose section the table belongs
	 * @param serverID the ID of the server whose section includes this table
	 */
	public void setServerSection(int serverID){
		
	}
	
	/**
	 * Gets the ID of the employee server whose section is in the table
	 * @return The Employee ID responsible for serving this table
	 */
	public int getServerSection(){
		return this.employeeID;
	}
	
	
	/**
	 * Set the maximum number of seats the table can hold 
	 * @param max The table's max seating
	 */
	public void setMaxOccupancy(int max){
		
	}
	
	/**
	 * Get the max occupancy of the table
	 * @return The table maxOxxupancy
	 */
	public int getMaxOccupancy(){
		return this.maxOccuppancy;
	}
	
	/**
	 * This will update the status of the table, so that it can be properly utilized by the system 
	 * @param newStatus The updated status of the table
	 */
	public void updateTableStatus(String newStatus){}
	
	/**
	 * Find status of the table
	 * @return The current value of status
	 */
	public String getStatus(){
		return this.status;
	}
	
	
	public String toString(){
		String res = "";
		res += "TableID: " + this.getTableID() + "\n";
		res += "ServerSection employeeID: " + this.getServerSection() + "\n";
		res += "MaxOccupancy: " + this.getMaxOccupancy() + "\n";
		res += "Table Status: " + this.getStatus() + "\n";
		
		return res;
	}
	
	
	
}

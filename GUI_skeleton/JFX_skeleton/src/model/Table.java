package model;

public class Table {
/**
 * A single table in the restaurant
 */
	
	private int tableID;
	private int serverSection;
	private int maxOccuppancy;
	private String status;
	
	/**
	 * Default Constructor
	 * Sets tableID, serverSection, and maxOccupancy to 0
	 * Sets status to "empty"
	 */
	public Table(){
		
	}
	
	/**
	 * Constructor
	 * @param tableID The ID associated with the Table in the database
	 * Sets the tableID
	 */
	public Table(int tableID){
		
	}
	
	/**
	 * Constructor
	 * @param tableID the ID associated with the Table in the database
	 * @param occupancy the maximum number of people that can be seated at a table
	 * Sets the tableID and maxOccupancy
	 */
	public Table(int tableID, int occupancy){
		
	}
	
	/**
	 * Associate the table with the ID of an employee (server) whose section the table belongs
	 * @param serverID the ID of the server whose section includes this table
	 */
	public void setServerSection(int serverID){
		
	}
	
	/**
	 * Set the maximum number of seats the table can hold 
	 * @param max The table's max seating
	 */
	public void setMaxOccupancy(int max){
		
	}
	
	/**
	 * Gets the ID of the employee server whose section is in the table
	 * @return The Employee ID responsible for serving this table
	 */
	public int getServerSection(){
		return this.serverSection;
	}
	
	/**
	 * Get the max occupancy of the table
	 * @return The table maxOxxupancy
	 */
	public int getMaxOccupancy(){
		return this.maxOccuppancy;
	}
	
	/**
	 * Gets the ID associated with the table
	 * @return The tableID
	 */
	public int getTableID(){
		return this.tableID;
	}
	
	/**
	 * Find status of the table
	 * @return The current value of status
	 */
	public String getStatus(){
		return this.status;
	}
	
	
}

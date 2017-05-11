package model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * This class contains the JDBC functionality for the Sales class, which is collection of paid Orders
 * 
 * @author phillipwitkin
 *
 */
public class SalesJDBC {

	/**
	 * Constructor;
	 * Establishes a database connection.
	 */
	public SalesJDBC(){
		
	}
	
	/**
	 * Returns all the paid checks within a time period
	 * @param start The starting time
	 * @param end The ending time
	 * @return An arrayList of Checks which fall withina time period
	 */
	public ArrayList<Order> getSalesForTime(Date start, Date end){
		return null;
	}
	
	/**
	 * Provides the ability to modifify a check
	 * @param orderID The ID of the check to be modifies
	 * @return The Check after it has been modified
	 */
	public Order modifyCheck(int orderID){
		return null;
	}
	
	/**
	 * 
	 * @param orderID The ID of the order for the check to be viewed
	 * @return The check to be viewed
	 */
	public HashMap<String, String> viewCheck(int orderID){
		return null;
	}

}

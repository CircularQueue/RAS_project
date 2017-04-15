package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author phillipwitkin
 * A container for a collection of checks
 */
public class Sales {
	
	ArrayList<Check> checks;
	
	/**
	 * Constructor
	 */
	public Sales(){
		
	}
	
	/**
	 * Returns all the paid checks within a time period
	 * @param start The starting time
	 * @param end The ending time
	 * @return An arrayList of Checks which fall withina time period
	 */
	public ArrayList<Check> getSalesForTime(Date start, Date end){
		return null;
	}
	
	/**
	 * Provides the ability to modifify a check
	 * @param orderID The ID of the check to be modifies
	 * @return The Check after it has been modified
	 */
	public Check modifyCheck(int orderID){
		return null;
	}
	
	/**
	 * 
	 * @param orderID The ID of the order for the check to be viewed
	 * @return The check to be viewed
	 */
	public Check viewCheck(int orderID){
		return null;
	}
	
	
	
}

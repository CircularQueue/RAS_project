package model.order;

import java.util.ArrayList;
import java.util.Date;

import model.BaseJDBC;
import model.CommonJDBC;

/**
 * This class contains the JDBC functionality for the Sales class, which is collection of paid Orders
 * It implements the CommonJDBC interface, with some additional methods specific for Sales
 * 
 * @author phillipwitkin
 *
 */
public class SalesJDBC extends BaseJDBC<Order> implements CommonJDBC<Order>{

	/**
	 * Constructor;
	 * Establishes a database connection.
	 */
	public SalesJDBC(){
		
	}
	
	@Override
	public Order finByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> findWhere(String SQLWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order updatedEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order newEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This method searches the database for all paid orders with today's date
	 * @return An ArrayList of Orders which were paid today
	 */
	public ArrayList<Order> findSalesForToday(){
		return null;
	}
	
	/**
	 * This method searches the database for all paid Orders in a date range
	 * @param start The starting date
	 * @param stop The ending date
	 * @return An ArrayList of Orders paid between start and end dates
	 */
	public ArrayList<Order> findSalesInDateRange(Date start, Date stop){
		return null;
	}

}

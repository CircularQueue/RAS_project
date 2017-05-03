import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * Order List
 * This is the collection of orders.  The underlining data structure is an Array List.  It is a mirror class of the
 * the OrderListJDBC class.
 * @author Benjamin Xerri
 *
 */
public class OrderList {
	//private Order ord;
	private OrderListJDBC ord;
	 
	

	/**
	 * Constructor for the Order List
	 * 
	 */
	public OrderList()
	{
		ord = new OrderListJDBC();
	}
	
	
	/**
	 * 
	 * Adds an order to the order list
	 * @param o Takes in a singular order to be placed in the order list
	 * @return boolean Returns True for a successful insert, false if the order was not inserted 
	 * @throws SQLException 
	 */
	public boolean placeOrder(Order o,OrderItems...args) throws SQLException{
		ord.placeOrder(o, args);
		return true;

	}	
		/*
			for(int i = 0;i < args.length;i++){
				try {
				ord.placeOrder(o,args[i]);
			}
			catch (SQLException e) {
				System.out.println("Error inserting multiple items");
				e.printStackTrace();
				return false;
				}
			}
			return true;
		}
	*/

	/**
	 * Updates an existing order, already in the order list
	 * @param orderID,orderToChange Takes in an order that will be updated, and the new order that will replace it
	 * @return boolean Returns true for a successful update, false if the order was not updated.
	 */
	public boolean updateOrder(int orderID, Order orderToChange){return true;}
	
	/**
	 * Takes in order id to pay that specific order.
	 * communicated with order Entity to change the status of an order. 
	 * Method communicates with table entity to clear a table if the order status was successfully changed.
	 *  
	 * @param orderId Takes in the order ID
	 * @return Order Returns the newly updated order with a changed order status, or null if the order could not be updated.  
	 */
	
	public Order payOrder(int orderId)
	{
		
	
		/** This method takes the table id and change the table status to need cleaning; invoked within payOrder Method. 
		 * 
		 * @param table_id
		 * @return true/false
		 */
		// once the order is payed it should be cleared from orders and Order_items; 
		
		Table.clearTable(0);
		Order ret = ord.payOrder(orderId);
		//deleteOrder(orderId);
		return ret;
	}
	
	
	/**
	 * Calls the JDBC method to delete the order.
	 * @param orderID The order of 
	 * @return Order Returns the order if it was successfully deleted, otherwise null
	 */
	public Order cookOrder(int orderID){return null;}
	
	/**
	 * Search if an order exists.
	 * @param orderId Search by order Id.
	 * @return True if the order is found.
	 */
	public Order searchOrder(int orderId)
	{
		Order ret = ord.searchOrder(orderId);	
		return ret;
		
	}
	
	/**
	 * Removes an order for the database
	 * @param orderID The order id
	 * @return Order Returns the order object if it was deleted, or null if the order was not found.
	 */
	public Order deleteOrder(int orderID)
	{
		Order ret = ord.deleteOrder(orderID);	
		System.out.println("Deleted order is: ");
		return ret;
		
	}
	
	
	/**
	 * Displays the Order List
	 * @return String Returns a string representation of the order.
	 */
	@Override public String toString()
	{
		String s ="";return s;
		
	}
}
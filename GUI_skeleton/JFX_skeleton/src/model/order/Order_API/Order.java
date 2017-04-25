import java.util.ArrayList;

/** 
 *Order Class
 *This class Represents a singular order that will be placed into RAS database.  It contains a unique ID to ensure that no 2 orders are
 *mistaken for one another.  
 * 
 * @author Ben Xerri
 * @version 1.0
 */
public class Order {
	private int orderId; //holds order Id -p.k
	private int serverId; //holds server Id associated with the order.  -f.k
	private int tableId; //holds table Id associated with the table. -f.k
	private ArrayList<Items> items; //list of items in the order
	private int orderStatus; //order status: 0 = un-cooked: 1 = cooked
	private double orderTotal;
	private int numItems;
	
	
	/**
	 * Constructor for the Order
	 * @param orderId Unique Order Id
	 * @param serverId Server Id associated with the order
	 * @param tableId Table Id associated with the order
	 * @param Items List of items in the order
	 * @param orderStatus status of the order
	 * @param orderTotal total price of the order
	 */
	public Order(int orderId,int serverId,int tableId,int orderStatus, Double orderTotal){
		this.orderId = orderId;
		this.serverId = serverId;
		this.tableId = tableId;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
	}
	public Order(int orderId,int serverId,int tableId,int orderStatus, Double orderTotal,int numItems){
		this.orderId = orderId;
		this.serverId = serverId;
		this.tableId = tableId;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
		this.numItems = numItems;
	}
	
	/**
	 * Sets the Order ID.
	 * @param newOrderNumber Takes in an integer to set the Order ID to.
	 * @return True if the order was successfully changed, false if it wasn't.
	 */
	public boolean setOrderID(int newOrderNumber) {
			return true;
    }
	/**
	 * Gets the order Id.	
	 * @return Returns the Order ID
	 */
	public int getOrderId(){
			return orderId;
	}
		    	
	/**
	 * Sets the server ID associated with the order.  For example, you need to change who is currently serving the table.
	 * @param serverIdToChange Takes in an integer to change to Server ID associated with this order
	 * @return Returns true if the value was successfully changed, false otherwise.
	 */
	public boolean setServerIdInOrder(int serverIdToChange){
		return true;
	}
	
	/**
	 * Gets the Id of the server responsible for the order.
	 * @return The server Id
	 */
	public int getServerIdInOrder(){
		return serverId;
	}
	
	/**
	 * Sets the table Id associated with the order
	 * @param newTableId Takes in an integer to change to Table ID associated with this order
	 * @return True if the value was successfully changed, false otherwise.
	 */
	public boolean setTableIdInOrder(int newTableId){ //sets table ID associated with order. I.e. the table moves .
		return true;
	}
	
	/**
	 * Gets the table Id associated with the order.
	 * @return Table ID of order
	 */
	public int getTableIdinOrder() {
		return tableId;
	}
	
	 
	/**
	 * 
	 * @return The items in the Order
	 */
	public ArrayList<Items> getOrderItems() {
			return items;
	} 
	
	public int getItems(){
		return numItems;
	}
	
	/**
	 * Sets the items of this order
	 * @param items The items to change in the order
	 * @return If the order items were successfully changed.
	 */
	public boolean setOrderItems(Items[] items) {
	  		return true;
	}
	
	/**
	 * Changes the status of the order
	 * @param id The status you would like the order to be changed to.
	 * @return If the order status was successfully changed.
	 */
	public boolean setOrderStatus(int id){
		return true;
	}
	 
	/**
	 *   	
	 * @return The current order's status.
	 */
	public int getOrderStatus() {
				return orderStatus;
	}
	/**
	 * Sets the total of the Order.	
	 * @param orderTotal
	 * @return True if the total was successfully changed.
	 */
	public boolean setOrderTotal(Double orderTotal) {
	  		return true;
  	}
	
	/**
	 * 
	 * @return The total value of the current order.
	 */
	public double getOrderTotal() {
	  		return orderTotal;
  	}
	
	public String toString(){
		String s="";
		return s;
	}
        
    
 }

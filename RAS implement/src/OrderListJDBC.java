import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * OrderListJDBC
 * Used for implementing the database connection to order list.  It will connect to RAS database.  The OrderListJDBC class will be a
 * mirror class of the OrderList class.
 * @author benjaminxerri
 *
 */
public class OrderListJDBC  
{
		private ArrayList<Order> orderList;
		private ArrayList<OrderItems> orderListItems;
		private HashMap<Integer,Order> orders;
		private HashMap<Integer, OrderItems> orderItems;
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/RAS";
/*
 * 	Connection myConn = DriverManager.getConnection(url, "root", "shergill91");	
		String price = "UPDATE from order_items where orderid =?";
		PreparedStatement myStmt = myConn.prepareStatement(price);
		myStmt.setInt(1, orderId);
		myStmt.executeUpdate();
 */
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "shergill91";
	   
	   static Connection conn = null; //hold connection
	/**Constructor for OrderList JDBC
	 * The connection is created here
	 * 
	 */
	public OrderListJDBC() 
	{
		orderList = new ArrayList<Order>();
		orderListItems = new ArrayList<OrderItems>();
		conn = getDB();
	}
	/**
	 * JDBC method that handles the database logic of placing the order.
	 * @param o The order that will be added to the database.
	 * @return true of the order was placed, false otherwise
	 * @throws SQLException 
	 */
	public boolean placeOrder(Order o, OrderItems...args) throws SQLException
	{
		
	 	
	 	String insertTableSQL = "INSERT INTO Orders (orderId,serverId,tableId,orderStatus,orderTotal) VALUES (?,?,?,?,?)";
	 	String insertOrderItems = "INSERT INTO Order_Items (orderId,order_item_id,Seat_Number,item_name,item_price,item_description)"
	 			+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
	 	try 
	 	{
	 		
	 		stmt = conn.prepareStatement(insertTableSQL);
	 		
	 		stmt.setInt(1, o.getOrderId()); //randomly generated
	 		stmt.setInt(2, o.getServerIdInOrder()); //who logs in
	 		stmt.setInt(3, o.getTableIdinOrder()); //what table they click
	 		stmt.setInt(4, o.getOrderStatus()); //0 to start automatically
	 		stmt.setDouble(5, o.getOrderTotal()); //starts at 0, then generated by calculated item_id and updated
	 		//stmt.setBlob(6, (Blob) o.getOrderItems()); //o.getOrderItems() When order items is fixed
	 		stmt.execute();
	 		System.out.println("Order Added");
	 		
	 	}catch(Exception e){
	 		System.err.println(e);
	 		return false;
	 	}
	 	
		for(int i =0; i < args.length;i++){
			try {
	 		stmt = conn.prepareStatement(insertOrderItems);
	 		stmt.setInt(1, o.getOrderId()); //randomly generated
	 		stmt.setInt(2, args[i].getID()); //who logs in
	 		stmt.setInt(3, args[i].getSeatNumber());
	 		stmt.setString(4, args[i].getName()); //what table they click
	 		stmt.setDouble(5, args[i].getPrice()); //0 to start automatically
	 		stmt.setString(6, args[i].getDescription()); //starts at 0, then generated by calculated item_id and updated

	 		
	 		stmt.execute();
	 		System.out.println("Order Items Added");
	 		
			
		 		
		 	}
			catch(Exception e)
			{
		 		System.err.println(e);
		 		return false;
		 	}

		}
		
	/*
		String str = o.toString() + " " + args[0].toString();
	 	orderList.add(o);
	 	orderListItems.add(args[0]);
	 	*/
		return true;
	}	

	/**
	 * Handles Database logic to update an existing order, already in the order list
	 * @param orderID,orderToChange Takes in an order that will be updated, and the new order that will replace it
	 * @return boolean Returns true for a successful update, false if the order was not updated.
	 */
	public boolean updateOrder(int orderID, Order orderToChange)
	{
		return true;
		
	}
	
	/**
	 * Takes in order id to pay that specific order.
	 * communicated with order Entity to change the status of an order. 
	 * Method communicates with table entity to clear a table if the order status was successfully changed.
	 *  
	 * @param orderId Takes in the order ID
	 * @return Order Returns the newly updated order with a changed order status, or null if the order could not be updated.  
	 */
	/*
	 * 
	 */
	public Order payOrder(int orderId)
	{
		/** This method takes the table id and change the table status to need cleaning; invoked within payOrder Method. 
		 * 
		 * @param table_id
		 * @return true/false
		 */
		Order searchOrder = searchOrder(orderId);
		if(searchOrder==null)
		{
			//System.out.println("Order not found");
			return null;
		}
		else
			
		try
		{
			
			String getTotal = " select sum(item_price) from order_items where orderid =" + orderId;
			PreparedStatement myStmt1 = conn.prepareStatement(getTotal);
			ResultSet result = myStmt1.executeQuery();
		     result.next();
		     String sum = result.getString(1);
		     //System.out.println("The Sum is = "+sum);
		     DecimalFormat two = new DecimalFormat(".##");
		     double temp = Double.parseDouble(sum);
		     double sum1 = Math.round(temp*100);
		     sum1= sum1/100;
			
			//System.out.println("Inside payOrder Begining");
		String update = "UPDATE orders set orderstatus=?, ordertotal = ? where orderid =?";
		PreparedStatement myStmt = conn.prepareStatement(update);
		myStmt.setInt(1,1);
		myStmt.setDouble(2,sum1);
		myStmt.setInt(3,orderId);
		myStmt.executeUpdate();
		
		//order total generate.
		/*
		 * count total for order id on the itemPrice column. 
		 */
		Table.clearTable(0);
		Table.clearTable(0);
		//System.out.println("in payorder in JDBC");
		}
		catch(Exception e)
		{
	 		System.err.println(e);
	 	}
		
		Order ordFound = searchOrder(orderId);
		return ordFound;
	}
	
	/**
	 * Handles Database logic to remove an order from the order table in the database.
	 * @param orderID The order id
	 * @return Order Returns the order object if it was deleted, or null if the order was not found.
	 */
	public Order deleteOrder(int orderID)
	{
		Order searchOrder = searchOrder(orderID);
		if(searchOrder==null)
		{
			//System.out.println("Order not found");
			return null;
		}
		else
		{
			deleteOrderItem(orderID);
			try
			{
				System.out.print("Inside delete in JDBC");
				String deleteOrders = "DELETE from orders where orderid = " +orderID;
				PreparedStatement delete1 = conn.prepareStatement(deleteOrders); 
				delete1.executeUpdate();
				// Delete from order_items as well. 	
			}
			catch(Exception e)
			{
		 		System.err.println(e);
		 	}
		}
		
		return searchOrder;
		
	}
	
	public Order deleteOrderItem(int orderID)
	{
		Order searchOrder = searchOrder(orderID);
		if(searchOrder==null)
		{
			//System.out.println("Order not found");
			return null;
		}
		else
			
		try
		{
			String deleteOrderItems = "DELETE from order_items where orderid = " +orderID;
			PreparedStatement delete2 = conn.prepareStatement(deleteOrderItems); 
			delete2.executeUpdate();
		}
		catch(Exception e)
		{
	 		System.err.println(e);
	 	}
		return searchOrder;
	}
	
	/**
	 * 
	 * Handles Database logic to search if an order exists.
	 * @param orderId Search by order Id.
	 * @return Returns the order that was found, or null of the order was not found.
	 */
	/*
	 * Handle null order
	 * 
	 */
	public Order searchOrder(int orderId)
	{
		int orderId1=0; int serverId=0; int tableId=0; int orderStatus=0; Double orderTotal=.0;
		// search order then get the order attributes.
		try
		{
			//System.out.println("in search ordeer");
		String searchOrder = "Select orderid, serverid, tableid, orderstatus, ordertotal from Orders where orderid ="+orderId;
		PreparedStatement myStmt = conn.prepareStatement(searchOrder);
//		myStmt.setInt(1,orderId);
		ResultSet myRs = myStmt.executeQuery(searchOrder);
		
		while(myRs.next())
		{
			//System.out.println("The order id is" + myRs.getString("orderid") + "  order_item_id is:" + myRs.getString("Ordertotal") +" Server id is "+ myRs.getString("ServerId") );
			// I should take the results and put it in order object. 
		orderId1 = Integer.valueOf(myRs.getString("orderid"));
		serverId= Integer.valueOf(myRs.getString("serverid"));
		tableId = Integer.valueOf(myRs.getString("tableid"));
		orderStatus = Integer.valueOf(myRs.getString("orderstatus"));
		orderTotal = Double.parseDouble(myRs.getString("ordertotal"));
		//select orderid, serverid, tableid, orderstatus, ordertotal from orders;
		}
		}
		catch(Exception e)
		{
	 		System.err.println(e);
	 		
	 	}

		if(orderId1!=orderId)
		{
			return null; 
		}
		else
		{
			Order orderDetails = new Order (orderId1, serverId, tableId, orderStatus, orderTotal);
		return orderDetails;
		}
		}
	
	/**
	 * Sets the total of the Order.	
	 * @param orderTotal
	 * @return True if the total was successfully changed.
	 */
	public boolean setOrderTotal(int orderId) 
	{
	  		return true;
  	}
	
	
	/**
	 * Handles database logic to displays the Order List
	 * @return String Returns a string representation of the order.
	 */
	@Override public String toString()
	{
		
		String s="";
		return s;	
	}
	
	public static Connection getDB() {
		   
		   Connection db_connection = null;
		
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		   }
		   catch(ClassNotFoundException se){ //Catches if you don't have your JDBC driver
			      //Handle errors for JDBC
			      se.printStackTrace();
		   }
		   try {
			   db_connection = DriverManager.getConnection(DB_URL,USER,PASS); //get connection to Database
			   return db_connection;
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
		   }
		   
		   return db_connection;
	   }
}

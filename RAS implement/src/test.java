public class test {

	public static void main(String[] args) 
	{
		OrderList ord= new OrderList();
		
		try{
			ord.placeOrder(new Order(21,13,55,0,28.2), new OrderItems(21,2,33,"Tacos",44.2,"Mexican Food"),
					new OrderItems(21,1,12,"Chicken", 28.50, "Chicken food"), new OrderItems(21,3,15,"Salmon",28.50,"Tasty Fish"));
					
			// pay order test for order id  =2.
			//Order output = ord.payOrder(2);
			// Delete Order test with Id = 21
			Order deleteOrder = ord.deleteOrder(21);
			/**
			 * ord.placeOrder(new Order(21,13,55,0,28.2), new OrderItems(21,2,33,"Tacos",44.2,"Mexican Food"),
		new OrderItems(21,1,12,"Chicken", 28.50, "Chicken food"), new OrderItems(21,3,15,"Salmon",28.50,"Tasty Fish"));
			 */
			
			System.out.println("The Order details are " +deleteOrder.toString());
		}
		catch(Exception e)
		{
			
		}
		
	}

}

//int orderId, int seatNumber, int orderItemId,String itemName,double itemPrice,String itemDescription
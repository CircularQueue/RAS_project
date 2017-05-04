import java.util.*;
public class test 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		OrderList ord= new OrderList();
		String options = "Press 1 to Pay an Order.";
		options+="\nPress 2 to Search an order.";
		options+="\nPress 3 to Delete an order.";
		options+="\nPress 0 to Quit.";
		//options+="Press 4 to see Database";
		System.out.println(options);
		int input = scan.nextInt();
		while (input!=0)
		{
			while (input ==1)
			{
				System.out.println("Please enter the order id to Pay for ");
				int orderId= scan.nextInt();
				try
				{
					Order output = ord.payOrder(orderId);
					if(output==null)
					{
						System.out.println("Order not found");
					}
					else
						
					System.out.println("The Paid Order details:" +output.toString());
					
				}
				catch(Exception e)
				{
					
				}
				
				System.out.println("\n"+options);
				input=scan.nextInt();
			}
			while (input==2)
			{
				System.out.println("Please enter the order id to search for ");
				int orderId= scan.nextInt();
				try
				{
					Order output = ord.searchOrder(orderId);
					if(output==null)
					{
						System.out.println("Order not found");
					}
					else
						
					System.out.println("Searched Order details:" +output.toString());
					
				}
				catch(Exception e)
				{
					
				}
				System.out.println("\n"+options);
				input=scan.nextInt();
			}
			while (input==3)
			{
				System.out.println("Please enter the order id Delete ");
				int orderId= scan.nextInt();
				try
				{
					Order output = ord.deleteOrder(orderId);
					if(output==null)
					{
						System.out.println("Order not found");
					}
					else
					
					System.out.println("Deleted Order details:" +output.toString());
					
				}
				catch(Exception e)
				{
					
				}
				System.out.println("\n"+options);
				input=scan.nextInt();
			}
			
		}
		System.out.println("Good bye");
	
		try
		{
			///ord.placeOrder(new Order(21,13,55,0,28.2), new OrderItems(21,2,33,"Tacos",44.2,"Mexican Food"),
					//new OrderItems(21,1,12,"Chicken", 28.50, "Chicken food"), new OrderItems(21,3,15,"Salmon",28.50,"Tasty Fish"));
		
				//insert into order_items  values (2,15, 5,"Salmon", 28.5, "Tasty Fish"); // 
	
			// pay order test for order id  =2.
			//Order output = ord.payOrder(21);
			// Delete Order test with Id = 21
			//Order deleteOrder = ord.deleteOrder(21);
			/**
			 * ord.placeOrder(new Order(3,13,55,0,28.2), new OrderItems(3,2,33,"Tacos",44.2,"Mexican Food"),
		new OrderItems(3,1,12,"Chicken", 28.50, "Chicken food"), new OrderItems(3,3,15,"Salmon",28.50,"Tasty Fish"));
			 **/
			// change all the 21's. 
			//ord.placeOrder(new Order(3,14,85,0,31.2),new OrderItems(3,33,8,"Tacos",44.2,"Mexican Food"));
			//System.out.println("The Order details are " +deleteOrder.toString());
		}
		catch(Exception e)
		{
			
		}
	}

}
/*
 * Update Total - when the order is goes inside order 
 * delete items from order_items. 
 * show payOrder
 * change status on hashmap as well. 
 */
//int orderId, int seatNumber, int orderItemId,String itemName,double itemPrice,String itemDescription
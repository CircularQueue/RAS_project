public class OrderItems extends MenuItem {
	private int orderId;
	private int seatNumber;

	public OrderItems(int orderId, int seatNumber, int orderItemId,String itemName,double itemPrice,String itemDescription){
		
		super(orderItemId,itemName,itemPrice,itemDescription);
		this.orderId = orderId;
		this.seatNumber = seatNumber;
	
	}
	
	public int getSeatNumber(){
		return seatNumber;
	}
	

}
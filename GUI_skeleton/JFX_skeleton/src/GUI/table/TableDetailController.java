package GUI.table;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.order.Order;
import model.order.OrderItems;
import model.order.OrderList;
import model.table.Table;

public class TableDetailController extends BorderPane {

//	@FXML TextArea tableID;
//	@FXML TextArea occupancy;
//	@FXML TextArea tableStatus;
//	@FXML TextArea employee;
//	
//	@FXML Button backToLayoutBtn1;
//	
//	@FXML TextArea orderID;
//	@FXML TextArea orderStatus;
	
//	@FXML TableColumn<OrderItemData, String> menuItemID;
//	@FXML TableColumn<OrderItemData, String> orderItemDescription;
//	@FXML TableColumn<OrderItemData, String> orderItemPrice;
//	@FXML TableColumn<OrderItemData, String> orderItemSeat;
//	
//	@FXML Button backToLayoutBtn2;
//	@FXML Button placeOrder;
//	
//	@FXML TableView<OrderItemData> orderItemTable;
//	ObservableList<OrderItemData> tableList = FXCollections.observableArrayList(); ;
	
	Stage stage;
	
	Table table;
	Order order;
	
	OrderList orderList;
	
	TableDetailControllerOrd conOrd;
	TableDetailControllerTbl contTbl;

	
	public static class OrderItemData{
			
			final SimpleStringProperty orderId; //error from not naming getters correctly
			final SimpleStringProperty seatNumber;
			final SimpleStringProperty menuItemId;
			final SimpleStringProperty name;
			final SimpleStringProperty price;
			final SimpleStringProperty desc;
			
			public OrderItemData(OrderItems item) {
				//String s = Integer.toString(item.getOrderItemsId());
				this.orderId = new SimpleStringProperty(Integer.toString(item.getOrderItemsId()));
			//	this.oId = new SimpleIntegerProperty(item.getOrderItemsId());
				this.seatNumber = new SimpleStringProperty(String.valueOf(item.getSeatNumber())); //<- this is not converting it to a string
				this.menuItemId = new SimpleStringProperty(String.valueOf(item.getID()));
				this.name = new SimpleStringProperty(item.getName());
				this.price = new SimpleStringProperty(Double.toString(item.getPrice()));
				this.desc = new SimpleStringProperty(item.getDescription());
			}
				
			public String getOrderId() { //these getters have to be named properly, i.e get getOrderId() , not getOrdId
				return orderId.get();
			}
			
			public String getSeatNumber() {
				return this.seatNumber.get();
			}
	
			public String getItemId() {
				return this.menuItemId.get();
			}
	
			public String getName() {
				return this.name.get();
			}
	
			public String getPrice() {
				return this.price.get();
			}
	
			public String getDesc() {
				return this.desc.get();
			}
			
			public void setOrderId(String num){
				this.orderId.set(num);
			}
			public void setSeatNumber(String num) {
				this.seatNumber.set(num);
			}
			
			public void setPrice(String val) {
				this.price.set(val);
			}
			public void setDesc(String description){
				this.desc.set(description);
			}
			
		}
	
	
	

	public TableDetailController(Stage stage) {
		this.stage = stage;
		
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableDetailView.fxml"));
//        // make sure that FX root construct is checked in scene builder
//        fxmlLoader.setRoot(this);
//        // leave controller blank in scene builder, or set it to this class
//        // this allows us to overide that setting and reuse the scene as a template for others
//        fxmlLoader.setController(this);
//        
//        try {
//        	// load fxml file
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
        
        this.orderList = new OrderList();
        this.conOrd = new TableDetailControllerOrd();
        this.contTbl = new TableDetailControllerTbl();
        
//        this.displayTableDetails();
        
	}

	
	
	public void setTable(Table table){
		this.table = table;
		int orderID = this.orderList.getOrderIdByTable(this.table.getTableID());
		Order ord = this.orderList.searchOrder(orderID);
		
		this.setOrder(ord);
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	
//	private void displayTableDetails(){
//		HashMap<Integer, List<OrderItems>> allOrderItems = orderList.getOrderItems();
//		List<OrderItems> orderItems = allOrderItems.get(this.order.getOrderId());
//		
//		menuItemID.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("orderId"));
//		orderItemDescription.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("seatNumber"));
//		orderItemPrice.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("itemId"));
//		orderItemSeat.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("name"));
////		itemPriceCell.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("price"));
////		itemDescriptionCell.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("desc"));
//		for (OrderItems oi : orderItems){
//			this.tableList.add(new OrderItemData(oi));
//		}
//		
//		System.out.println("Setting Table");
//		orderItemTable.setItems(tableList);
//	}
}

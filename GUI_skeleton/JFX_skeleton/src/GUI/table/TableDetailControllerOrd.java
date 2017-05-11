package GUI.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import GUI.order.application.ServerHomeController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

public class TableDetailControllerOrd extends BorderPane{
	@FXML TextArea orderID;
	@FXML TextArea orderStatus;
	
	@FXML TableColumn<OrderItemData, String> menuItemID;
	@FXML TableColumn<OrderItemData, String> orderItemDescription;
	@FXML TableColumn<OrderItemData, String> orderItemPrice;
	@FXML TableColumn<OrderItemData, String> orderItemSeat;
	
	@FXML Button backToTableBtn;
	@FXML Button placeOrder;
	
	@FXML TableView<OrderItemData> orderItemTable;
	ObservableList<OrderItemData> tableList = FXCollections.observableArrayList(); ;
	
	Stage stage;
	
	Table table;
	Order order;
	
	OrderList orderList;
	
	public TableDetailControllerOrd(Stage stage) {
		this.stage = stage;
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderTab.fxml"));
        // make sure that FX root construct is checked in scene builder
        fxmlLoader.setRoot(this);
        // leave controller blank in scene builder, or set it to this class
        // this allows us to overide that setting and reuse the scene as a template for others
        fxmlLoader.setController(this);
        
        try {
        	// load fxml file
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
     
        this.orderList = new OrderList();
	}
	
	
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

		public String getMenuItemId() {
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
	
	private void displayTableDetails(){
		
		menuItemID.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("menuItemId"));
		orderItemDescription.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("desc"));
		orderItemPrice.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("price"));
		orderItemSeat.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("seatNumber"));
		
//		HashMap<Integer, List<OrderItems>> allOrderItems = orderList.getOrderItems();
//		
//		for(Entry<Integer, List<OrderItems>> key: allOrderItems.entrySet()){
//			//System.out.println("key: " +key + ": " + "Value: " + orderItems111.get(key));
//			for(OrderItems num : key.getValue()){
//				
//				if (num.getID() == order.getOrderId()){
//					OrderItems o = new OrderItems(num.getOrderItemsId(),num.getSeatNumber(),num.getID(),num.getName(),num.getPrice(),num.getDescription());
//					tableList.add(new OrderItemData(o));
//					
//					
//				}
//			}
//			
//		}
		ArrayList<OrderItems> orderItems = orderList.getUncookedItemsForOrder(this.order.getOrderId());
		
		for (OrderItems oi : orderItems){
			tableList.add(new OrderItemData(oi));
		}
		
		orderItemTable.setItems(tableList);
		
		
		System.out.println("order items: " + orderItems);
		
		
	//	itemPriceCell.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("price"));
	//	itemDescriptionCell.setCellValueFactory(new PropertyValueFactory<OrderItemData,String>("desc"));
//		for (OrderItems oi : orderItems){
//			this.tableList.add(new OrderItemData(oi));
//		}
		
		System.out.println("Setting Table");
		
		
	}
	
	@FXML protected void viewTable(ActionEvent ae){
		TableDetailController tableView = new TableDetailController(this.stage);
		tableView.setTable(this.table);
		Scene previousScene = new Scene(tableView);
		this.stage.setScene(previousScene);
	}
	
	@FXML protected void placeOrder(ActionEvent ae){
		ServerHomeController shc = new ServerHomeController(this.stage);
		Scene nextScene = new Scene(shc);
		this.stage.setScene(nextScene);
	}
	

	public void setOrder(Order order){
		this.order = order;
	    if (this.order != null){
	    	this.orderID.setText(Integer.toString(order.getOrderId()));
	    	this.orderStatus.setText(Integer.toString(order.getOrderStatus()));
	    	
	    	this.displayTableDetails();
//	    	this.placeOrder.setDisable(true);
	    } else {
//	    	this.placeOrder.setDisable(false);
	    }
	}
	
	public void setTable(Table table){
		this.table = table;
	}
}

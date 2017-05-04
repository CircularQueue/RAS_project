package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import order.Order;
import order.OrderItems;

public class ViewOrderController extends BorderPane implements Initializable {
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	@FXML ComboBox<Integer> orderChoice;
	private order.OrderList oi;
	private ObservableList<ViewOrder> list = FXCollections.observableArrayList(); 
	private HashMap<Integer, List<order.OrderItems>> orderItems111;
	private HashMap<Integer, Order> ord;


	@FXML TableView<ViewOrder> tableUser = new TableView<ViewOrder>();
	@FXML TableColumn<ViewOrder, String> orderIdCell;
	@FXML TableColumn<ViewOrder, String> seatNumberCell;
	@FXML TableColumn<ViewOrder, String> itemIdCell;
	@FXML TableColumn<ViewOrder, String> itemNameCell;
	@FXML TableColumn<ViewOrder, String> itemPriceCell;

	
	public ViewOrderController(Stage stage) throws IOException {
		oi = new order.OrderList(); //create a new order list
		orderItems111 = oi.getOrderItems(); //put those items in a hashmap to iterate

		this.stage = stage;
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewOrderController.fxml"));
		    // make sure that FX root construct is checked in scene builder

		    
		    fxmlLoader.setRoot(this);
	        // leave controller blank in scene builder, or set it to this class
	        // this allows us to overide that setting and reuse the scene as a template for others
	        fxmlLoader.setController(this);
	        
	        try {
	        	// load fxml file
	            fxmlLoader.load();
	        }catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
	        getOrderType();
	        initialze();
		}
	
	@FXML public void initialze(){
		
	/*	
		
		orderIdCell.setCellValueFactory(new PropertyValueFactory<ViewOrder,String>("orderId"));
		seatNumberCell.setCellValueFactory(new PropertyValueFactory<ViewOrder,String>("seatNumber"));
		itemIdCell.setCellValueFactory(new PropertyValueFactory<ViewOrder,String>("itemId"));
		itemNameCell.setCellValueFactory(new PropertyValueFactory<ViewOrder,String>("name"));
		itemPriceCell.setCellValueFactory(new PropertyValueFactory<ViewOrder,String>("price"));
		
		for(Entry<Integer, List<OrderItems>> key: orderItems111.entrySet()){
			//System.out.println("key: " +key + ": " + "Value: " + orderItems111.get(key));
			for(OrderItems num : key.getValue()){
				Order o = new Order(num.getOrderItemsId(),num.getSeatNumber(),num.getID(),num.getName(),num.getPrice(),num.getDescription());
				list.add(new ViewOrder(o));
			}
			
		}
		System.out.println("Setting Table");
		tableUser.setItems(list);
		tableUser.setEditable(true);
		*/
	}
	/*
	public ObservableList<PopulateTable> getObservableList(){
		return list;
	}
	
	@FXML protected Integer submitOrder(ActionEvent ae) throws IOException{
		int n = orderChoice.getValue();
		oi.searchOrder(orderId)
		
	}
	*/
	
	@FXML protected void backToHome(ActionEvent ae) throws IOException{
		//instantiate controller here
		ServerHomeController cont = new ServerHomeController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	@FXML protected void loadAbout(ActionEvent ae) throws IOException {
		AboutController cont = new AboutController(stage);
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	
	@FXML protected void getOrderType() throws IOException{
		orderChoice.getItems().addAll(
			    1,
			    2,
			    3
			);
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {


	}
	
	@FXML protected void populateItems(){
		
	}
	
	public static class ViewOrder{
		
		final SimpleStringProperty orderId; //error from not naming getters correctly
		final SimpleStringProperty serverId;
		final SimpleStringProperty tableId;
		final SimpleStringProperty orderStatus;
		final SimpleStringProperty orderTotal;
		
		public ViewOrder(Order o) {
			//String s = Integer.toString(item.getOrderItemsId());
			this.orderId = new SimpleStringProperty(Integer.toString(o.getOrderId()));
		//	this.oId = new SimpleIntegerProperty(item.getOrderItemsId());
			this.serverId = new SimpleStringProperty(String.valueOf(o.getServerIdInOrder())); //<- this is not converting it to a string
			this.tableId = new SimpleStringProperty(String.valueOf(o.getTableIdinOrder()));
			this.orderStatus = new SimpleStringProperty(Integer.toString(o.getOrderStatus()));
			this.orderTotal = new SimpleStringProperty(Double.toString(o.getOrderTotal()));
		}
			
		public String getOrderId() { //these getters have to be named properly, i.e get getOrderId() , not getOrdId
			return orderId.get();
		}
		
		public String getSeatNumber() {
			return this.serverId.get();
		}

		public String getItemId() {
			return this.tableId.get();
		}

		public String getName() {
			return this.orderStatus.get();
		}

		public String getPrice() {
			return this.orderTotal.get();
		}

		
		public void setOrderId(String num){
			this.orderId.set(num);
		}
		/*
		public void setSeatNumber(String num) {
			this.seatNumber.set(num);
		}
		
		public void setPrice(String val) {
			this.price.set(val);
		}
		public void setDesc(String description){
			this.desc.set(description);
		}
		*/
	}
}

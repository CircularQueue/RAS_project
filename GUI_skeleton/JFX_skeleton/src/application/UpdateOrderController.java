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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import order.OrderItems;

public class UpdateOrderController extends BorderPane implements Initializable {
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	private order.Order ord;
	private order.OrderList oi;
	private ObservableList<PopulateTable> list = FXCollections.observableArrayList(); 
	private HashMap<Integer, List<order.OrderItems>> orderItems111;

	@FXML TableView<PopulateTable> tableUser = new TableView<PopulateTable>();
	@FXML TableColumn<PopulateTable, String> orderIdCell;
	@FXML TableColumn<PopulateTable, String> seatNumberCell;
	@FXML TableColumn<PopulateTable, String> itemIdCell;
	@FXML TableColumn<PopulateTable, String> itemNameCell;
	@FXML TableColumn<PopulateTable, String> itemPriceCell;
	@FXML TableColumn<PopulateTable, String> itemDescriptionCell;

	
	public UpdateOrderController(Stage stage) throws IOException {

		this.stage = stage;
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateOrder.fxml"));
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
	     
	        initialze();
		}
	
	@FXML public void initialze(){
		oi = new order.OrderList(); //create a new order list
		orderItems111 = oi.getOrderItems(); //put those items in a hashmap to iterate
		
		
		orderIdCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("orderId"));
		seatNumberCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("seatNumber"));
		itemIdCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("itemId"));
		itemNameCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("name"));
		itemPriceCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("price"));
		itemDescriptionCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("desc"));
		
		for(Entry<Integer, List<OrderItems>> key: orderItems111.entrySet()){
			System.out.println("key: " +key + ": " + "Value: " + orderItems111.get(key));
			for(OrderItems num : key.getValue()){
				OrderItems o = new OrderItems(num.getOrderItemsId(),num.getSeatNumber(),num.getID(),num.getName(),num.getPrice(),num.getDescription());
				list.add(new PopulateTable(o));
			}
			
		}
	
		tableUser.setItems(list);
		
	}
	
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
	
	public void initialize(URL arg0, ResourceBundle arg1) {


	}
	
	@FXML protected void populateItems(){
		
	}
	
	public static class PopulateTable{
		
		final SimpleStringProperty orderId; //error from not naming getters correctly
		final SimpleStringProperty seatNumber;
		final SimpleStringProperty itemId;
		final SimpleStringProperty name;
		final SimpleStringProperty price;
		final SimpleStringProperty desc;
		
		public PopulateTable(order.OrderItems item) {
			//String s = Integer.toString(item.getOrderItemsId());
			this.orderId = new SimpleStringProperty(Integer.toString(item.getOrderItemsId()));
		//	this.oId = new SimpleIntegerProperty(item.getOrderItemsId());
			this.seatNumber = new SimpleStringProperty(String.valueOf(item.getSeatNumber())); //<- this is not converting it to a string
			this.itemId = new SimpleStringProperty(String.valueOf(item.getID()));
			this.name = new SimpleStringProperty(item.getName());
			this.price = new SimpleStringProperty(Double.toString(item.getPrice()));
			this.desc = new SimpleStringProperty(item.getDescription());
		}
		/*
		public populateTable(List<order.OrderItems> items,int key) {
			this.oId = new SimpleStringProperty(Integer.toString(items.get(key).getID()));
			this.seatNum = new SimpleStringProperty(Integer.toString(items.get(key).getSeatNumber()));
			this.iId = new SimpleStringProperty(Integer.toString(items.get(key).getOrderItemsId()));
			this.name = new SimpleStringProperty(items.get(key).getName());
			this.price = new SimpleStringProperty(Double.toString(items.get(key).getPrice()));
			this.desc = new SimpleStringProperty(items.get(key).getDescription());
		}
		 */	
		public String getOrderId() { //these getters have to be named properly, i.e get getOrderId() , not getOrdId
			return orderId.get();
		}
		
		public String getSeatNumber() {
			return this.seatNumber.get();
		}

		public String getItemId() {
			return this.itemId.get();
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
}

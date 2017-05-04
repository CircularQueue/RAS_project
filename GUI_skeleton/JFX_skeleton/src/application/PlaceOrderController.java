package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import order.Order;
import order.OrderList;

public class PlaceOrderController extends BorderPane {
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	@FXML Button getValue;
	@FXML TextArea numSeats;
	@FXML TextArea serverId;
	@FXML TextArea tableId;
	@FXML TextArea errorMessage;
	
	OrderList orderList = new OrderList();
	
	public PlaceOrderController(Stage stage) throws IOException {

		this.stage = stage;
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlaceOrder.fxml"));
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
		}
	
	@FXML protected void getValue(ActionEvent ae) throws IOException{
		boolean isValidOrder = true;
		int num = 0;
		int id = 0;
		int tableInt = 0;
		int serverInt = 0;
		String c = numSeats.getText();
		String server = serverId.getText();
		String table = tableId.getText();
		try{
			 num = Integer.parseInt(c); 
			 serverInt = Integer.parseInt(server);
			 tableInt = Integer.parseInt(table);
		}
		catch(Exception e){
			isValidOrder = false;
			numSeats.clear();
			errorMessage.appendText("*Error");
		}
		
		Order o = new Order(serverInt,tableInt);
		try {
			if (!isValidOrder){
				errorMessage.clear();
				errorMessage.appendText("Can't place order, all forms jmust be valid");
			}
			else{
				orderList.placeOrder(o);
			}
		} catch (SQLException e) {
			System.out.println("Error Placing Order");
			e.printStackTrace();
		}
		
		
		System.out.println(num + "," + server+"," + table );
	
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
}

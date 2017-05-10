package GUI.order.application;

import java.io.IOException;

import GUI.order.application.ViewUncokedOrdersController.OrderItemData;
//import GUI.order.application.ServerHomeController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.order.MenuItem;

/**
 * 
 * @author jaddeep
 *Pay order Scene.  Allows the user to see all the orders and pay for an order that has been cooked.  
 */
public class PayOrderController extends BorderPane {
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	
	public PayOrderController(Stage stage) throws IOException {

		this.stage = stage;
		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PayOrder.fxml"));
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
	
	@FXML protected void quit(ActionEvent ae) throws IOException{
		System.exit(0);
	}
	
	

}

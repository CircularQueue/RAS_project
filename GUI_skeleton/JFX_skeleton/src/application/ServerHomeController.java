package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class ServerHomeController extends BorderPane{
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	private int numClicks;
	
	public ServerHomeController(Stage stage){
		this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServerHome.fxml"));
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
        
        this.numClicks = 0;
		
	}
	
	// method which is called when button click event occurs (set in scene builder)
	@FXML protected void clickButton(ActionEvent ae){
		this.numClicks++;
		textDisplay.setText("Button clicked " + this.numClicks + " times");
	}
	
	@FXML protected void changeSceneUpdateOrder(ActionEvent ae) throws IOException{
		//instantiate controller here
		UpdateOrderController cont = new UpdateOrderController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	
	@FXML protected void changeScenePayOrder(ActionEvent ae) throws IOException{
		//instantiate controller here
		PayOrderController cont = new PayOrderController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	
	@FXML protected void changeScenePlaceOrder(ActionEvent ae) throws IOException{
		//instantiate controller here
		PlaceOrderController cont = new PlaceOrderController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	@FXML protected void changeSceneCookOrder(ActionEvent ae) throws IOException{
		//instantiate controller here
		CookOrderController cont = new CookOrderController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	@FXML protected void loadAbout(ActionEvent ae) throws IOException {
		AboutController cont = new AboutController(stage);
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	
	
}

package application;

import java.awt.Menu;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class MenuController extends BorderPane{

	@FXML Button btn;
	
	@FXML Button btn2;
	
	@FXML Button btn3;
	
	@FXML Button btn4;
	
	protected Stage stage;
	
	public MenuController(Stage stage){
		
		this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
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
		
	}
	
@FXML protected void changeScene(ActionEvent ae){
			ViewController change = new ViewController(this.stage);
			Scene nextScene = new Scene(change);
			System.out.print("Here");
			this.stage.setScene(nextScene);
	}
}
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;

// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class SampleController extends BorderPane{

	@FXML Button btn;
	@FXML TextArea textDisplay;
	
	private int numClicks;
	
	public SampleController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sample.fxml"));
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
}

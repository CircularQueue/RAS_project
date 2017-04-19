package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SecondSceneController extends SampleController {

	public SecondSceneController(Stage stage) {
		super(stage);
	}
	
	// method which is called when button click event occurs (set in scene builder)
	@FXML protected void clickButton(ActionEvent ae){
		this.numClicks++;
		textDisplay.setText("Fuck You " + this.numClicks + " times");
	}

}

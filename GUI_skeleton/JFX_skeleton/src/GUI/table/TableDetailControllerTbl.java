package GUI.table;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class TableDetailControllerTbl extends AnchorPane {

	@FXML TextArea tableID;
	@FXML TextArea occupancy;
	@FXML TextArea tableStatus;
	@FXML TextArea employee;
	
	@FXML Button backToLayoutBtn1;
	
	@FXML TextArea orderID;
	@FXML TextArea orderStatus;
	
	public TableDetailControllerTbl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableDetailView.fxml"));
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

}

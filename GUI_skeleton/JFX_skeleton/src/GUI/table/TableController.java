package GUI.table;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class TableController extends BorderPane {

	@FXML Text tableIDText;
	@FXML Circle tableSelector;
	int tblId;
	
	public TableController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableView.fxml"));
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
	
	public void setTablIdText(int tableID){
		String sID = "";
		sID+= tableID;
		this.tableIDText.setText(sID);
	}
	
	@FXML protected void selectTable(ActionEvent ae){
		
	}
}

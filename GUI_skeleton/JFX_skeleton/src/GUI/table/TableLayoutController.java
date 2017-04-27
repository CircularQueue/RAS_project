package GUI.table;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.table.TableList;

public class TableLayoutController {

	TableList tableList;
	
	Stage stage;
	
	
	
	public TableLayoutController(Stage stage) {
		this.stage = stage;
		this.stage.setTitle("Table Layout");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableLayoutView.fxml"));
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
		
		this.tableList = new TableList();
		
	}

}

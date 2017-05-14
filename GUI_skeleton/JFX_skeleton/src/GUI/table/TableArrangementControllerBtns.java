package GUI.table;

import java.io.IOException;

import GUI.table.TableArrangementController.EnterTableDetailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TableArrangementControllerBtns extends BorderPane{

	Stage stage;
	
	@FXML Button addTblBtn;
	@FXML Button removeTblBtn;
	@FXML Button assignTblBtn;
	
	TableArrangementController tblArrangeCont;
	
	public TableArrangementControllerBtns(Stage stage)  {
		this.stage = stage;
		this.stage.setTitle("Table Options");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableArrangementView.fxml"));
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
	
	@FXML protected void addTable(ActionEvent ae){
		tblArrangeCont.addTable();
	}

	@FXML protected void removeTable(ActionEvent ae){
		tblArrangeCont.removeTable();
	}
	
	@FXML protected void assignTable(ActionEvent ae){
		tblArrangeCont.updateTable();
	}

	
}

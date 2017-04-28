package GUI.table;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.table.Table;

public class TableController extends BorderPane {

	@FXML Text tableIDText;
	@FXML Circle tableCircleOuter;
	@FXML Circle tableCircleInner;
	
	int tblID;
	Table table;
	TableLayoutController tblLayout;
	
	public TableController(TableLayoutController tblLayoutCont){
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
        
        this.tblLayout = tblLayoutCont;

	}
	
	public void setTablIdText(int tableID){
		String sID = "";
		sID += tableID;
		this.tableIDText.setText(sID);
		this.tblID = tableID;
	}
	
	public void setTablIdText(Table table){
		String sID = "";
		sID += table.getTableID();
		this.tableIDText.setText(sID);
		this.tblID = table.getTableID();
		this.table = table;
		// set color based on table employeeID
		this.setEmployeeColor(TableColors.values()[this.table.getServerSection()].color );
	}
	
	public void setEmployeeColor(Color color){
		this.tableCircleOuter.setFill(color);
	}
	
	@FXML protected void clickTable(MouseEvent ae){
		System.out.println("Table circle pressed for table " + this.tblID);
		this.tblLayout.viewTableDetails(this.tblID);
	}
	
	
	

}

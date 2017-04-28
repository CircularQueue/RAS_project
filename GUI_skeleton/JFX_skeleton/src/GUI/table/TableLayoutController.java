package GUI.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.table.Table;
import model.table.TableList;

public class TableLayoutController extends BorderPane{

	TableList tableList;
	
	Stage stage;
	
	@FXML GridPane tableGrid;

	
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
		this.showTables();

	}
	
	private void showTables(){
		HashMap<Integer, ArrayList<Table> > allSections = tableList.viewServerSections();
//		System.out.println("Tables by section:");
		int row=0;
		int col =0;
		Color tColor;
		for ( Integer serverID : allSections.keySet() ){
//			System.out.println("Tables for employeeID: " + serverID);
			tColor = TableColors.values()[serverID].color;
			for ( Table table : allSections.get(serverID)){
				System.out.println("Addding Table...\n" + table);
				
				TableController newTable = new TableController(this);
				newTable.setTablIdText( table.getTableID() );
				newTable.setEmployeeColor(tColor);
				
				GridPane.setConstraints(newTable, col, row);
				this.tableGrid.add(newTable, col, row);
				col++;
				if (col == 4){
					row++;
					col = 0;
				}
			}
			
		}
	}
	
	
	public void viewTableDetails(int tableID){
		System.out.println("Show detail for table " + tableID);
	}

}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.MenuItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import 
// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class ViewController extends BorderPane implements Initializable{
	
	protected Stage stage;
	
	@FXML private TableColumn<MenuItem, String> item_id;
	@FXML private TableColumn<MenuItem, String> item_name;
	@FXML private TableColumn<MenuItem, String> item_price;
	@FXML private Button btn;
	@FXML private TableView<MenuItem> itemTable;
	private ObservableList<MenuItem> data = FXCollections.observableArrayList();
	
	public ViewController(Stage stage){
		this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewMenu2.fxml"));
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
        initializeTable();
	}
	
	public void initializeTable()
	{
		 data.removeAll(data);
	     item_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID() ) ));
	     item_price.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice() ) ));
	     item_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName() ) );
	     item_description.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription() ) );
         MenuItem mu = new MenuItem(001, "Pasta", 3.75, "Pasta food");
         data.add(mu);
         itemTable.getItems().setAll(this.data);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	 //    item_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID() ) ) );
      //   MenuItem mu = new MenuItem();
       //  data.add(mu);
        // ordTable.getItems().setAll(this.data);
	}
		
	}
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import Main.MenuItem;
import Main.MenuJDBC;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
//import 
// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class ViewController extends BorderPane implements Initializable{
	
	protected Stage stage;


	@FXML private TableColumn<MenuItemData, String> item_name;
	@FXML private TableColumn<MenuItemData, String> item_id;
	@FXML private TableColumn<MenuItemData, String> item_price;
	@FXML private TableColumn<MenuItemData, String> item_description;
	@FXML private Button btn;
	@FXML TableView<MenuItemData> itemTable = new TableView<MenuItemData>();
	private ObservableList<MenuItemData> data = FXCollections.observableArrayList();
	private MenuJDBC db;
	
	public static class MenuItemData{
		
		final SimpleStringProperty name;
	    final SimpleStringProperty item_id;
	    final SimpleStringProperty price;
	    final SimpleStringProperty description;
	    public MenuItemData (MenuItem item){
			this.name = new SimpleStringProperty(item.getName());
			this.item_id = new SimpleStringProperty(Integer.toString(item.getID()));
			System.out.println("Here constructor");
			this.price = new SimpleStringProperty(Double.toString(item.getPrice()));
			this.description = new SimpleStringProperty(item.getDescription());
	    }
			
			public String getName(){
				System.out.println("here name");
				return this.name.get();
			}    
			public String getItem_id(){
				System.out.println("here id");
				return this.item_id.get();
			}
			public String getPrice(){
				System.out.println("here price");
				return this.price.get();
			}
			public String getDescription(){
				System.out.println("here des");
				return this.description.get();
			}
	}
	
	public ViewController(Stage stage) throws ClassNotFoundException, SQLException{
		this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewMenu2.fxml"));
        // make sure that FX root construct is checked in scene builder
        fxmlLoader.setRoot(this);
        // leave controller blank in scene builder, or set it to this class
        // this allows us to override that setting and reuse the scene as a template for others
        fxmlLoader.setController(this);
        
        try {
        	// load fxml file
            fxmlLoader.load();
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        initializeTable();
	}
	
	public void initializeTable() throws ClassNotFoundException, SQLException{
		MenuItemData iData;
        item_name.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("name"));
        item_id.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("item_id"));
        item_price.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("price"));
        item_description.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("description"));
        db = new MenuJDBC();
        HashMap<Integer, MenuItem> hm = new HashMap<>();
        hm = db.populateMenu();
        for(Integer key : hm.keySet()){
        	iData = new MenuItemData(hm.get(key));
        	data.add(iData);
        }
        itemTable.setItems(data);
	
	}
	
	public void addItem(){
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	 //    item_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID() ) ) );
      //   MenuItem mu = new MenuItem();
       //  data.add(mu);
        // ordTable.getItems().setAll(this.data);
	}
	}
	
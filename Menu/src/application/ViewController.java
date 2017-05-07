package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

import Main.Menu;
import Main.MenuItem;
import Main.MenuJDBC;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//import 
// Note this is an extension of the container class BorderPane. The fxml must also have that as its root.
public class ViewController extends BorderPane implements Initializable{
	private TableView<MenuItemData> itemTable = new TableView<MenuItemData>();
	private ObservableList<MenuItemData> data = FXCollections.observableArrayList();
	private MenuJDBC db;
	final HBox hb = new HBox();
	VBox vbox;
	
	public static class MenuItemData{
		
		final SimpleStringProperty name;
	    final SimpleStringProperty item_id;
	    final SimpleStringProperty price;
	    final SimpleStringProperty description;
	    private String tempName;
	    private Double tempPrice;
	    private String tempDes;
	    public MenuItemData (MenuItem item){
			this.name = new SimpleStringProperty(item.getName());
			this.item_id = new SimpleStringProperty(Integer.toString(item.getID()));
			this.price = new SimpleStringProperty(Double.toString(item.getPrice()));
			this.description = new SimpleStringProperty(item.getDescription());
			this.tempName = item.getName();
			this.tempPrice = item.getPrice();
			this.tempDes = item.getDescription();
	    }
			
			public String getName(){
				return this.name.get();
			}    
			public String getItem_id(){
				return this.item_id.get();
			}
			public String getPrice(){
				return this.price.get();
			}
			public String getDescription(){
				return this.description.get();
			}
			
			public void setName(String name1){
				this.tempName = name1;
			}
			
			public void setPrice(Double price1){
				this.tempPrice = price1;
			}
			
			public void setDescription(String description){
				this.tempDes = description;
			}
			
			public MenuItem setItem(){
				return new MenuItem(Integer.parseInt(getItem_id()), tempName, tempPrice, tempDes);
			}
	}
	
	public ViewController(Stage stage) throws ClassNotFoundException, SQLException{
        Scene scene = new Scene(new Group());
        stage.setWidth(950);
        stage.setHeight(550);
        initializeTable();
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public void initializeTable() throws ClassNotFoundException, SQLException{
		db=new MenuJDBC();
		Menu menu = new Menu();
		MenuItemData iData;
	    final Label label = new Label("Menu");
        label.setFont(new Font("Arial", 20));
		itemTable.setEditable(true);
		TableColumn <MenuItemData, String> item_name = new TableColumn <MenuItemData, String> ("Item ID");
		TableColumn <MenuItemData, String>  item_id = new TableColumn <MenuItemData, String> ("Item Name");
		TableColumn <MenuItemData, String>  item_price = new TableColumn <MenuItemData, String> ("Item Price");
		TableColumn <MenuItemData, String>  item_description = new TableColumn <MenuItemData, String> ("Item Description");
		itemTable.getColumns().addAll(item_id, item_name, item_price, item_description);
	    item_name.setMinWidth(200);
	    item_id.setMinWidth(100);
	    item_price.setMinWidth(100);
	    item_description.setMinWidth(500);
        item_name.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("name"));
        item_id.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("item_id"));
        item_price.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("price"));
        item_description.setCellValueFactory(new PropertyValueFactory<MenuItemData, String>("description"));
        HashMap<Integer, MenuItem> hm = new HashMap<>();
        hm = db.populateMenu();
        
		item_name.setCellFactory(TextFieldTableCell.forTableColumn());
		
		item_name.setOnEditCommit(
            new EventHandler<CellEditEvent<MenuItemData, String>>() {
                @Override
                public void handle(CellEditEvent<MenuItemData, String> t) {
                    ((MenuItemData) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                    try {
						menu.updateItem(((MenuItemData) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        ).setItem(), Integer.parseInt(((MenuItemData) t.getTableView().getItems().get(
						                t.getTablePosition().getRow())
						                ).getItem_id()));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        );
		
		item_price.setCellFactory(TextFieldTableCell.forTableColumn());
		
		item_price.setOnEditCommit(
	            new EventHandler<CellEditEvent<MenuItemData, String>>() {
	                @Override
	                public void handle(CellEditEvent<MenuItemData, String> t) {
	                    ((MenuItemData) t.getTableView().getItems().get(
	                            t.getTablePosition().getRow())
	                            ).setPrice(Double.parseDouble(t.getNewValue()));
	                    try {
							menu.updateItem(((MenuItemData) t.getTableView().getItems().get(
							        t.getTablePosition().getRow())
							        ).setItem(), Integer.parseInt(((MenuItemData) t.getTableView().getItems().get(
							                t.getTablePosition().getRow())
							                ).getItem_id()));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            }
	        );
		
		item_description.setCellFactory(TextFieldTableCell.forTableColumn());
		
		item_description.setOnEditCommit(
	            new EventHandler<CellEditEvent<MenuItemData, String>>() {
	                @Override
	                public void handle(CellEditEvent<MenuItemData, String> t) {
	                    ((MenuItemData) t.getTableView().getItems().get(
	                            t.getTablePosition().getRow())
	                            ).setDescription(t.getNewValue());
	                    try {
							menu.updateItem(((MenuItemData) t.getTableView().getItems().get(
							        t.getTablePosition().getRow())
							        ).setItem(), Integer.parseInt(((MenuItemData) t.getTableView().getItems().get(
							                t.getTablePosition().getRow())
							                ).getItem_id()));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            }
	        );
        
        itemTable.setItems(data);
        for(Integer key : hm.keySet()){
        	iData = new MenuItemData(hm.get(key));
        	data.add(iData);
        }
        final TextField addItemID = new TextField();
        addItemID.setPromptText("Item ID");
        addItemID.setMaxWidth(item_id.getPrefWidth());
        final TextField addItemName = new TextField();
        addItemName.setMaxWidth(item_name.getPrefWidth());
        addItemName.setPromptText("Item Name");
        final TextField addItemPrice = new TextField();
        addItemPrice.setMaxWidth(item_price.getPrefWidth());
        addItemPrice.setPromptText("Item Price");
        final TextField addItemDescription = new TextField();
        addItemDescription.setMaxWidth(item_description.getPrefWidth());
        addItemDescription.setPromptText("Item Description");
        
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                	MenuItem item = new MenuItem(Integer.parseInt(addItemID.getText()), addItemName.getText(), Double.parseDouble(addItemPrice.getText()), addItemDescription.getText());
					db.insertData(item);
					MenuItemData itemData = new MenuItemData(item);
					data.add(itemData);
					itemTable.refresh();
			        
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                addItemID.clear();
                addItemName.clear();
                addItemPrice.clear();
                addItemDescription.clear();
            }
        });
        
        final TextField removeItem = new TextField();
        removeItem.setMaxWidth(item_id.getPrefWidth());
        removeItem.setPromptText("Item ID");
        
        final Button removeButton = new Button("Remove");
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent e) {
                try {
                	MenuItem item = db.deleteData(Integer.parseInt(removeItem.getText()));
					MenuItemData itemData = new MenuItemData(item);
					data.remove(itemData);
					itemTable.refresh();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                removeItem.clear();
            }
        });
        
        hb.getChildren().addAll(addItemID, addItemName, addItemPrice, addItemDescription, addButton);
        hb.setSpacing(4);
        hb.getChildren().addAll(removeItem, removeButton);
        hb.setSpacing(4);
 
        vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, itemTable, hb);
        
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	 //    item_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID() ) ) );
      //   MenuItem mu = new MenuItem();
       //  data.add(mu);
        // ordTable.getItems().setAll(this.data);
	}
	}
	
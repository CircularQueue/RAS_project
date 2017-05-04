package application;

import java.io.IOException;

import application.UpdateOrderController.PopulateTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import order.OrderList;

public class CookOrderController extends BorderPane {
	Stage stage;
	@FXML Button placeOrder;
	@FXML Button viewOrder;
	@FXML Button payOrder;
	@FXML TextArea textDisplay;
	@FXML Stage window;
	@FXML TextArea cookOrderId;
	@FXML TextArea errorMessage;
	UpdateOrderController oc = new UpdateOrderController(stage);
	private ObservableList<PopulateTable> listCook = FXCollections.observableArrayList(); 
	@FXML TableView<PopulateTable> tableUser = new TableView<PopulateTable>();
	@FXML TableColumn<PopulateTable, String> orderIdCell;
	@FXML TableColumn<PopulateTable, String> seatNumberCell;
	@FXML TableColumn<PopulateTable, String> itemIdCell;
	@FXML TableColumn<PopulateTable, String> itemNameCell;
	@FXML TableColumn<PopulateTable, String> itemPriceCell;
	@FXML TableColumn<PopulateTable, String> itemDescriptionCell;



		
	OrderList od = new OrderList();
	
	public CookOrderController(Stage stage) throws IOException {

		this.stage = stage;

		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cookOrder.fxml"));
		    // make sure that FX root construct is checked in scene builder

		    
		    fxmlLoader.setRoot(this);
	        // leave controller blank in scene builder, or set it to this class
	        // this allows us to overide that setting and reuse the scene as a template for others
	        fxmlLoader.setController(this);
	        
	        try {
	        	// load fxml file
	            fxmlLoader.load();
	        }catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
	        
	       loadData();
	       
		}
	@FXML protected void cookOrder(ActionEvent ae) throws IOException{
		boolean isValidId = true;
		int cookId = 0;
		String s = cookOrderId.getText();
		try{
			cookId = Integer.parseInt(s);
		}
		catch(Exception e){
			isValidId = false;
			errorMessage.appendText("*Non valid Id");
		}
		
		// od.searchOrder(cookId); //jagdeep needs to fix this to return null or make it a boolean
		
		if (isValidId){
			System.out.println(od.changeOrderStatus(cookId,1));
			//loadData();
		}
		else {
			System.out.println("Couldn't delete Order");
		}
		
	}
	
	@FXML public void loadData() {
		
		orderIdCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("orderId"));
		seatNumberCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("seatNumber"));
		itemIdCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("itemId"));
		itemNameCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("name"));
		itemPriceCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("price"));
		itemDescriptionCell.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("desc"));
		listCook.addAll(oc.getObservableList());
		tableUser.setItems(listCook);
		
	}
	
	@FXML protected void backToHome(ActionEvent ae) throws IOException{
		//instantiate controller here
		ServerHomeController cont = new ServerHomeController(stage);
		
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	@FXML protected void loadAbout(ActionEvent ae) throws IOException {
		AboutController cont = new AboutController(stage);
		Scene scen = new Scene(cont);
		this.stage.setScene(scen);
	}
	
	
}

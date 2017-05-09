package GUI.table;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.employee.Employee;
import model.employee.EmployeeManagement;
import model.order.Order;
import model.order.OrderItems;
import model.order.OrderList;
import model.table.Table;

public class TableDetailController extends BorderPane {

	@FXML TextArea tableID;
	@FXML TextArea occupancy;
	@FXML TextArea tableStatus;
	@FXML TextArea employee;

	@FXML Button layoutReturnBtn;
//	
//	@FXML TextArea orderID;
//	@FXML TextArea orderStatus;
	
//	@FXML TableColumn<OrderItemData, String> menuItemID;
//	@FXML TableColumn<OrderItemData, String> orderItemDescription;
//	@FXML TableColumn<OrderItemData, String> orderItemPrice;
//	@FXML TableColumn<OrderItemData, String> orderItemSeat;
//	
//	@FXML Button backToLayoutBtn2;
//	@FXML Button placeOrder;
//	
//	@FXML TableView<OrderItemData> orderItemTable;
//	ObservableList<OrderItemData> tableList = FXCollections.observableArrayList(); ;
	
	Stage stage;
	
	Table table;
	Order order;
	
	OrderList orderList;
	EmployeeManagement empManage;

	
	
	
	
	

	public TableDetailController(Stage stage) {
		this.stage = stage;
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableTab.fxml"));
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
        
        this.orderList = new OrderList();
        this.empManage = new EmployeeManagement();

        
//        this.displayTableDetails();
        
	}

	
	
	public void setTable(Table table){
		this.table = table;
		this.tableID.setText(Integer.toString(this.table.getTableID() ));
		this.tableStatus.setText(this.table.getStatus());
		this.occupancy.setText(Integer.toString(table.getMaxOccupancy() ));
		
		Employee emp = empManage.findEmployeeInformation(table.getServerSection()); 
		this.employee.setText(emp.getname());
		
		int orderID = this.orderList.getOrderIdByTable(this.table.getTableID());
		Order ord = this.orderList.searchOrder(orderID);
		System.out.println("order for this table" + ord);
		this.setOrder(ord);
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	@FXML protected void returnToLayout(ActionEvent ae){
		TableLayoutController tblLayout = new TableLayoutController(this.stage);
		Scene previousScene = new Scene(tblLayout);
		this.stage.setScene(previousScene);
	}
	
	@FXML protected void viewOrder(ActionEvent ae){
		TableDetailControllerOrd orderInfo = new TableDetailControllerOrd(this.stage);
		orderInfo.setOrder(order);
		Scene nextScene = new Scene(orderInfo);
		this.stage.setScene(nextScene);
	}
	

}

package GUI.table;

import GUI.table.TableArrangementController.EnterTableDetailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.table.Table;
import model.table.TableList;

public class TableArrangementController extends TableLayoutController {

	TableArrangementControllerBtns tblBtns;
	
	TableList tableList;
	
	public TableArrangementController(Stage stage) {
		super(stage);
		tblBtns = new TableArrangementControllerBtns(stage);
		this.tableButtons.getChildren().add(tblBtns);
		this.tblBtns.tblArrangeCont = this;
		
		this.tableList = new TableList();
	}
	
	public void addTable(){
		Stage newStage=new Stage();
		EnterTableDetailController tblDetail = new EnterTableDetailController(newStage);
		tblDetail.orderInfoBtn.setText("Add New Table");
		tblDetail.action = "add";
		tblDetail.tableID.setEditable(false);
		tblDetail.employee.setPromptText("Enter server ID");
		Scene nextScene = new Scene(tblDetail);
//		this.tblDetail.setPrevious(this.current);
		newStage.setScene(nextScene);
		newStage.show();
	}
	
	public void removeTable(){
		Stage newStage=new Stage();
		EnterTableDetailController tblDetail = new EnterTableDetailController(newStage);
		tblDetail.orderInfoBtn.setText("Remove Table");
		tblDetail.tableID.setPromptText("Enter TableID");
		tblDetail.occupancy.setEditable(false);
		tblDetail.employee.setEditable(false);
		tblDetail.tableStatus.setEditable(false);
		tblDetail.action = "remove";
		Scene nextScene = new Scene(tblDetail);
//		this.tblDetail.setPrevious(this.current);
		newStage.setScene(nextScene);
		newStage.show();
	}
	
	public void updateTable(){
		Stage newStage=new Stage();
		EnterTableDetailController tblDetail = new EnterTableDetailController(newStage);
		tblDetail.orderInfoBtn.setText("Update Table");
		tblDetail.employee.setPromptText("Enter server ID");
		tblDetail.action = "update";
		Scene nextScene = new Scene(tblDetail);
//		this.tblDetail.setPrevious(this.current);
		newStage.setScene(nextScene);
		newStage.show();
	}
	
	
	
	public class EnterTableDetailController extends TableDetailController {
		
		String action;
		@FXML TextArea tableID;
		@FXML TextArea occupancy;
		@FXML TextArea tableStatus;
		@FXML TextArea employee;
		
		public EnterTableDetailController(Stage stage){
			super(stage);
		}
		
		
		@FXML protected void viewOrder(ActionEvent ae){
			switch (action){
				case "add":
					createTable();
					break;
				case "remove":
					deleteTable();
					break;
				case "update":
					updateTable();
					break;
					
			}
			
		}
		
		@FXML protected void returnToLayout(ActionEvent ae){
				tblBtns.tblArrangeCont.clearTables();
				tblBtns.tblArrangeCont.showTables();
				this.stage.close();

		}
		
		private void createTable(){
			String oc = occupancy.getText();
			int ocInt = Integer.parseInt(oc);
			String eID = employee.getText();
			int empID = Integer.parseInt(eID);
			String status = tableStatus.getText();
			Table tbl = new Table(ocInt);
			tbl.setServerSection(empID);
			tbl.updateTableStatus(status);
			Table added = tableList.addTable(tbl);
			System.out.println("Added table: " + added);
			returnToLayout(null);
		}
		
		private void deleteTable(){
			String tabId = tableID.getText();
			int tID = Integer.parseInt(tabId);
			tableList.removeTable(tID);
			System.out.println("Try to remove a table with Id: " + tID);
			returnToLayout(null);
		}
		
		private void updateTable(){
			String ocString = occupancy.getText();
			int oc = Integer.parseInt(ocString);
			String eID = employee.getText();
			int empID = Integer.parseInt(eID);
			String tbID = tableID.getText();
			int tID = Integer.parseInt(tbID);
			String status = tableStatus.getText();
			Table tbl = new Table(oc);
			tbl.setTableID(tID);
			tbl.setServerSection(empID);
			tbl.updateTableStatus(status);
			tableList.changeTableStatus(tID, status);
			System.out.println("Try to update - new tableL " + tbl);
			returnToLayout(null);
		}
		
	}
	
	

	
}

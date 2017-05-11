package GUI.table;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.employee.Employee;
import model.employee.EmployeeManagement;
import model.employee.EmployeeManagementJDBC;

public class LoginController extends BorderPane {

	Stage stage;
	Employee employee;
	EmployeeManagement empManage;
	
	@FXML TextField loginID;
	@FXML Text loginText;
	@FXML Button loginBtn;
	
	public LoginController(Stage stage) {
		this.stage = stage;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
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
        
        this.empManage = new EmployeeManagement();
        
	}
	
	@FXML protected void login(ActionEvent ae){
		String userText = loginID.getText();
		int empID;
		try {
			empID = Integer.parseInt(userText);
		} catch (NumberFormatException nfe){
			loginText.setText("Please enter an integer value");
			return;
		}
		Employee empAttempt = this.empManage.findEmployeeInformation(empID);
		if (empAttempt != null){
			this.employee = empAttempt;
			this.checkEmployeeType(employee);
		} else {
			loginText.setText("No employee with that ID could be found");
		}
		
		
	}
	
	private void checkEmployeeType(Employee emp){
		Scene nextScene =null;
		switch (emp.getEmployeeType().toLowerCase()){
			case "server":
				TableLayoutController layout = new TableLayoutController(this.stage);
				nextScene = new Scene(layout);
				this.stage.setScene(nextScene);
				
				break;
				
			case "hostess":
				//shizuni code
				break;
				
			case "manager":
				ManagerController managerMain = new ManagerController(stage);
				managerMain.setManager(emp);
				nextScene = new Scene(managerMain);
				this.stage.setScene(nextScene);
				break;
		}
	}
	
	

}

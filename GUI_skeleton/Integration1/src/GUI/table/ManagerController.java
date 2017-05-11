package GUI.table;

import java.io.IOException;
import java.sql.SQLException;

import GUI.menu.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.employee.Employee;

public class ManagerController extends BorderPane{

	Stage stage;
	Employee manager;
	
	@FXML Button tableSelectBtn;
	@FXML Button menuSelectBtn;
	@FXML Button employeeSelectBtn;
	
	public ManagerController(Stage stage) {
		this.stage = stage;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerView.fxml"));
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
	
	public void setManager(Employee emp){
		this.manager = emp;
	}
	
	@FXML protected void tableSelect(ActionEvent ae){
		
	}
	
	@FXML protected void menuSelect(ActionEvent ae){
		try {
			ViewController menuCont = new ViewController(stage);
			Scene menuScene = new Scene(menuCont);
			this.stage.setScene(menuScene);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML protected void employeeSelect(ActionEvent ae){
		
	}

}

package application;
	

import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws ClassNotFoundException, SQLException {
		ViewController vc = new ViewController(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
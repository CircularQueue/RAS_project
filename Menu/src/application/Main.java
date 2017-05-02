package application;
	

import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
		// instatiate contoller as an object
		ViewController sc = new ViewController(primaryStage);
		// pass sc in as a scene parameter, since it extends borderpane
		Scene scene = new Scene(sc, 1000, 600);
		// set the scene, and display it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
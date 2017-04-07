package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// instatiate contoller as an object
		SampleController sc = new SampleController();
		// pass sc in as a scene parameter, since it extends borderpane
		Scene scene = new Scene(sc, 400, 300);
		// set the scene, and display it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

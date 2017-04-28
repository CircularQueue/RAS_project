package Main;
import javafx.stage.Stage;
import application.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;


public class MenuTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		// instatiate contoller as an object
		MenuController mc = new MenuController();
		// pass sc in as a scene parameter, since it extends borderpane
		Scene scene = new Scene(mc, 400, 300);
		// set the scene, and display it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
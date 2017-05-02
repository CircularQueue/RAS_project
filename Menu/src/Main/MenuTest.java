package Main;
import javafx.stage.Stage;

import java.sql.SQLException;

import application.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;


public class MenuTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Menu menu = new Menu();
		System.out.print(menu.toString());
	}
}
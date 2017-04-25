package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// instatiate contoller as an object
		SampleController sc = new SampleController(primaryStage);
		// pass sc in as a scene parameter, since it extends borderpane
		Scene scene = new Scene(sc, 400, 300);
		// set the scene, and display it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
//		launch(args);
		
		
		// jdbc config experiment
		  try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        } catch (Exception ex) {
	            // handle the error
	        }
		Connection conn = null;
	
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3310/dbma_assignment1?", "root", "root");

		    // Do something with the Connection
		    
		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM Part");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

//		    if (stmt.execute("SELECT foo FROM bar")) {
//		        rs = stmt.getResultSet();
//		    }

		    // Now do something with the ResultSet ....
		    while (rs.next()){
		    	System.out.println("Title: " + rs.getString("Part_Description"));
		    }
		    
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}
}

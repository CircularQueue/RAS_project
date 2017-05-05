package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import model.employee.Employee;
import model.employee.EmployeeManagementJDBC;
import model.table.Table;
import model.table.TableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import GUI.table.TableLayoutController;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// instatiate contoller as an object
		TableLayoutController tlc = new TableLayoutController(primaryStage);
		// pass sc in as a scene parameter, since it extends borderpane
		Scene scene = new Scene(tlc, 600, 500);
//		SampleController sc = new SampleController(primaryStage);
//		Scene scene = new Scene(sc);
		// set the scene, and display it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
//		launch(args);
		EmployeeManagementJDBC empDB = new EmployeeManagementJDBC();
		Employee emp = empDB.findEmployeeInformation("Clara Oswald");
		
		if (emp != null)
		{
			System.out.println("Found employee: " + emp);
		} else 
		{
			System.out.println("No employee found with that name.");
		}
		
		Employee good= new Employee ("sam smith", "server", true);
		Employee emp1 = empDB.addemployee(good);
		
		emp = empDB.findEmployeeInformation("sam smith");
		if (emp!=null)
		{
			System.out.println("add employee: " + emp1);
		}
		else
		{
			System.out.println("new employee not added");
		}
		
		Employee emp2 = empDB.removeEmployee("Clara Oswald");
		if (emp2 !=null){
			System.out.println("removed employee"+ emp2);
		}else {
				System.out.println("remove employee from the database not sucessful");
		}
//		TableList tableList = new TableList();
//		
//		HashMap<Integer, Table> allTables = tableList.getTableLayout();
//		HashMap<Integer, ArrayList<Table> > sections = tableList.viewServerSections();
//		
//		System.out.println("Table Layout of all tables:");
//		for (Integer tableId : allTables.keySet()){
//			Table table = allTables.get(tableId);
//			System.out.println(table);
//		}
//		
//		System.out.println("Tables by section:");
//		for ( Integer serverID : sections.keySet() ){
//			System.out.println("Tables for employeeID: " + serverID);
//			for ( Table table : sections.get(serverID)){
//				System.out.println(table);
//			}
//		}
		
		// jdbc config experiment
//		  try {
//	            // The newInstance() call is a work around for some
//	            // broken Java implementations
//
//	            Class.forName("com.mysql.jdbc.Driver").newInstance();
//	        } catch (Exception ex) {
//	            // handle the error
//	        }
//		Connection conn = null;
//	
//		try {
//		    conn =
//		       DriverManager.getConnection("jdbc:mysql://localhost/dbma_assignment1?", "root", "root");
//
//		    // Do something with the Connection
//		    
//		   
//		} catch (SQLException ex) {
//		    // handle any errors
//		    System.out.println("SQLException: " + ex.getMessage());
//		    System.out.println("SQLState: " + ex.getSQLState());
//		    System.out.println("VendorError: " + ex.getErrorCode());
//		}
//		
//		PreparedStatement stmtPrep = null;
//		
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
////		    stmt = conn.createStatement();
////			rs = stmt.executeQuery("SELECT * FROM Part");
//			stmtPrep = conn.prepareStatement("SELECT * FROM Part");
//			rs = stmtPrep.executeQuery();
//
//		    // or alternatively, if you don't know ahead of time that
//		    // the query will be a SELECT...
//
////		    if (stmt.execute("SELECT foo FROM bar")) {
////		        rs = stmt.getResultSet();
////		    }
//
//		    // Now do something with the ResultSet ....
//		    while (rs.next()){
//		    	System.out.println("PartName: " + rs.getString("Part_Description"));
//		    }
//		    
//		}
//		catch (SQLException ex){
//		    // handle any errors
//		    System.out.println("SQLException: " + ex.getMessage());
//		    System.out.println("SQLState: " + ex.getSQLState());
//		    System.out.println("VendorError: " + ex.getErrorCode());
//		}
//		finally {
//		    // it is a good idea to release
//		    // resources in a finally{} block
//		    // in reverse-order of their creation
//		    // if they are no-longer needed
//
//		    if (rs != null) {
//		        try {
//		            rs.close();
//		        } catch (SQLException sqlEx) { } // ignore
//
//		        rs = null;
//		    }
//
//		    if (stmt != null) {
//		        try {
//		            stmt.close();
//		        } catch (SQLException sqlEx) { } // ignore
//
//		        stmt = null;
//		    }
//		}
	}
}

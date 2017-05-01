package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/RAS";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	public ConnectionJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getDB() {
		   
		   Connection db_connection = null;
		
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		   }
		   catch(ClassNotFoundException se){ //Catches if you don't have your JDBC driver
			      //Handle errors for JDBC
			      se.printStackTrace();
		   }
		   try {
			   db_connection = DriverManager.getConnection(DB_URL,USER,PASS); //get connection to Database
			   return db_connection;
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
		   }
		   
		   return db_connection;
	   }
	
	// connects without connecting to the specific database
	public static Connection connectServer(){
		   Connection db_connection = null;
			
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		   }
		   catch(ClassNotFoundException se){ //Catches if you don't have your JDBC driver
			      //Handle errors for JDBC
			      se.printStackTrace();
		   }
		   try {
			   db_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",USER,PASS); //get connection to Database
			   return db_connection;
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
		   }
		   
		   return db_connection;
	}
}

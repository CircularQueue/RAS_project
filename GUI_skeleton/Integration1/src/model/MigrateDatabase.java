package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MigrateDatabase {

	private static void importSQL(Connection conn, InputStream in) throws SQLException
	{
	    Scanner s = new Scanner(in);
	    s.useDelimiter("(;(\r)?\n)|((\r)?\n)?(--)?.*(--(\r)?\n)");
	    Statement st = null;
	    try
	    {
	        st = conn.createStatement();
	        while (s.hasNext())
	        {
	            String line = s.next();
	            if (line.startsWith("/*!") && line.endsWith("*/"))
	            {
	                int i = line.indexOf(' ');
	                line = line.substring(i + 1, line.length() - " */".length());
	            }

	            if (line.trim().length() > 0)
	            {
	                st.execute(line);
	            }
	        }
	    }
	    finally
	    {
	        if (st != null) st.close();
	    }
	}
	
	public static void importSQL(String sqlFilePath){
		FileInputStream in = null;
		try {
			in = new FileInputStream(sqlFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			MigrateDatabase.importSQL(ConnectionJDBC.connectServer(), in);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// create db schema
		importSQL("src/model/CreateDB.sql");
		// import seed data
		importSQL("src/model/SeedData.sql");

	}

}

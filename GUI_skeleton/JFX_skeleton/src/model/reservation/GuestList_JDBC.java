package model.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 
 * Class Name: GuestList_JDBC 
 * Class Description: This class holds database connection.
 * Connects GuestList to Database
 */
public class GuestList_JDBC 
{
    WaitGuest guest = new WaitGuest();
	/**
	 * This is a queue of waitguest
	 */
	//private WaitGuest[] guestQueue = new WaitGuest[500];
	 List <WaitGuest>guestQueue = new ArrayList<WaitGuest>();
	
  /**
 * @return Connection
 */
 public Connection connectToDB()
	   {
		   Connection conn = null;
		   try
		   {
			   Class.forName("com.mysql.jdbc.Driver");
				//Establish connection to mysql
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ras","root","root");
			    //System.out.println(" connection established"); 
		   }
		   catch (Exception e) 
		   {
			System.out.println(" error while connecting to db "+e);
		  }
		   return conn;
	   }
	 
	/**
	 * This will add a guest into the guestQueue
	 * @param guest new Guest
	 * @return true if the guest was added or false if the guest was not added
	 */

	public boolean addGuest(WaitGuest guest, Connection conn)
	{
		String fName = guest.getFirst_name();
		String lName = guest.getLast_name();
		int count = guest.getGuest_count();
		Boolean guestAdded = false;
		try
		{
			if(conn !=null)
		    {
			    //query string
			    String queryString = "insert into ras."+"wait_list"+ "( first_name, last_name, guest_count) values (?,?,?)";
			    //create a statement
			    PreparedStatement st = conn.prepareStatement(queryString);
			    st.setString(1, fName);
			    st.setString(2, lName);
			    st.setInt(3, count);
			    //execute mysql query
			    st.execute();
			    guestAdded = true;
		    }
		} 
		catch (Exception e) 
		{
			System.out.println(" error occurred while connceting"+e.getMessage());
		}
		return guestAdded; 
	}
	
	/**
	 * This will search for a guest in the guestQueue
	 * @param name wanted name
	 * @return the WaitGuest that was searched for
	 */
	public List<WaitGuest> searchGuest(String fname, String lname, Connection conn, String key)
	{
		WaitGuest guest = new WaitGuest();
		List<WaitGuest> searchResult = new ArrayList<WaitGuest>();
		try 
		{
			
			if(conn!=null)
		    {
		    	//create a statement
			    Statement st = conn.createStatement();
			    ResultSet rs = st.executeQuery("Select * from ras."+key+" where first_name = '"+fname+"' and last_name = '"+lname+"'");
			    // check if all values are getting added to guest
			    while(rs.next())
			    {
			    	guest.setId(rs.getInt(1));
			    	guest.setFirst_name(rs.getString(2));
			    	guest.setLast_name(rs.getString(3));
			    	guest.setGuest_count(rs.getInt(4));
			    	//System.out.println("\n"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			    	searchResult.add(guest);
			    }
		    }
		} 
		catch (Exception e) 
		{
			System.out.println(" error occurred while searching DB"+e.getMessage());
			e.printStackTrace();
		}
		//return list of results
		return searchResult;
	}
	
	/**
	 * This will remove a guest from the guestQueue
	 * @param name wanted name
	 * @return the guest that was removed
	 */
	public boolean removeGuest(String fName, String lName, Connection conn, String key)
	{
		
		boolean removeGuest = false;
		try
		{
			if(conn!=null)
		    {
		    	//query string
			    String queryString = "delete from ras."+key+" where first_name = ? and last_name = ? ";
			    //create a statement
			    PreparedStatement st = conn.prepareStatement(queryString);
			    st.setString(1, fName);
			    st.setString(2, lName);
			    //execute mysql query
			    st.execute();	
			    // set something to guest
			    removeGuest = true;
			   // System.out.println(" values removed");
		    }
		}
		catch (Exception e) 
		{
			System.out.println(" exception while removing guest "+e.getMessage());
		}
		return removeGuest;
	}
	
	/**
	 * This will present the waitlist to the user
	 * @return the current waitlist
	 */
	public List<WaitGuest> viewWaitList(Connection conn, String key)
	{
		List<WaitGuest> waitGuestQueue = new ArrayList<WaitGuest>();
		try
		{
			
			if(conn!=null)
			{
				  //create a statement
				if(key.equals("wait_list"))
				{
					System.out.println("Id"+"  "+"FirstName"+"    "+"LastName"+"    "+"No. of Guests");
				}
				else
				{
					System.out.println("Id"+"  "+"FirstName"+"    "+"LastName"+"    "+"No. of Guests"+"      "+"Date"+"     "+"Time");
				}
			    Statement st = conn.createStatement();
			    ResultSet rs = st.executeQuery("Select * from ras."+key);
			    while(rs.next())
			    {
			    	guest.setId(rs.getInt(1));
			    	guest.setFirst_name(rs.getString(2));
			    	guest.setLast_name(rs.getString(3));
			    	guest.setGuest_count(rs.getInt(4));
			    	
			    	if(key.equals("wait_list"))
			    	{ 
			    		System.out.println("\n"+rs.getString(1)+"         "+rs.getString(2)+"         "+rs.getString(3)+"         "+rs.getInt(4));
			    	}
			    	else
			    	{
			    		System.out.println("\n"+rs.getString(1)+"   "+rs.getString(2)+"          "+rs.getString(3)+"         "+rs.getInt(4)+"          "+rs.getString(5)+"       "+rs.getString(6));
			    	}
			    	//add data to queue
			    	waitGuestQueue.add(guest);
			    }
			}	
		}
		catch (Exception e) 
		{
			System.out.println(" error while displaying db table "+e.getMessage());
		}
		return waitGuestQueue;
	}
	/**
	 * This will add a guest into the Reservation
	 * @param guest new Guest
	 * @return true if the guest was added or false if the guest was not added
	 */
	public boolean addReservation(Reservation res, Connection conn)
	{
		String fName = res.getFirst_name();
		String lName = res.getLast_name();
		int count = res.getGuest_count();
		String date = res.getReservation_date();
		String time = res.getReservation_time();
		Boolean guestAdded = false;
		try
		{
			if(conn !=null)
		    {
			    //query string
			    String queryString = "insert into ras.reservation ( first_name, last_name, guest_count,res_date,res_time) values (?,?,?,?,?)";
			    //create a statement
			    PreparedStatement st = conn.prepareStatement(queryString);
			    st.setString(1, fName);
			    st.setString(2, lName);
			    st.setInt(3, count);
			    st.setString(4, date);
			    st.setString(5, time);
			    //execute mysql query
			    st.execute();
			    guestAdded = true;
		    }
		} 
		catch (Exception e) 
		{
			System.out.println(" error occurred while connecting"+e.getMessage());
		}
		return guestAdded; 
	}
  

}

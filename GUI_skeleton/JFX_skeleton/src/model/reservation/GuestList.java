package model.reservation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestList 
{
  static GuestList_JDBC guestListJDBC = new GuestList_JDBC();
  static WaitGuest guest = new WaitGuest();
  static Reservation res = new Reservation();

  public Connection connect_db()
  {
	  Connection conn = guestListJDBC.connectToDB();
	  return conn;
  }
  public void add_guest(Scanner sc, Connection conn)
  {
	   //call add
		System.out.println(" Please enter First Name of Guest");
		String fName = sc.nextLine();
		System.out.println(" Please enter Last Name of Guest");
		String lName = sc.nextLine();
		System.out.println(" Please enter number of Guests");
		int gcount = Integer.parseInt(sc.nextLine());
		 //boolean to check if guest is added successfully to the list 
		  boolean isGuestAddSuccess = false;
		  guest.setFirst_name(fName);
		  guest.setLast_name(lName);
		  guest.setGuest_count(gcount);
		 //call add method
		  isGuestAddSuccess = guestListJDBC.addGuest(guest,conn);
		  if(isGuestAddSuccess)
		  {
			 System.out.println(" Guest is added successfully");
		  }
  }
  public void remove_guest(Scanner sc, Connection conn,String key)
  {
	  //boolean to check guest is removed from db successfully
	  boolean removeGuest = false;
	  System.out.println(" Please enter First Name of Guest");
	  String fName = sc.nextLine();
	  System.out.println(" Please enter Last Name of Guest");
	  String lName = sc.nextLine();
	  guest.setFirst_name(fName);
	  guest.setLast_name(lName);
	 //call method to remove guest
	  removeGuest = guestListJDBC.removeGuest(guest.getFirst_name(), guest.getLast_name(), conn, key);
	 
	  if(removeGuest)
	  {
		 System.out.println(" Guest removed ");
	  }
  }
  public void view_guest(Connection conn, String key)
  {
		guestListJDBC.viewWaitList(conn, key);
  }
  public void search_guest(Scanner sc, Connection conn, String key)
  {
	  List <WaitGuest> guestFound = new ArrayList<WaitGuest>();
	  System.out.println(" Please enter First Name of Guest");
	  String fName = sc.nextLine();
	  System.out.println(" Please enter Last Name of Guest");
	  String lName = sc.nextLine();
	  guest.setFirst_name(fName);
	  guest.setLast_name(lName);
	  //call method to search guest
	  guestFound.addAll(guestListJDBC.searchGuest(guest.getFirst_name(), guest.getLast_name(), conn, key));
	  if(guestFound.size()>0)
	  {
		  System.out.println(" guest found ");
	  }
	  else
	  {
		  System.out.println(" Guest not found");
	  }
  }
  public void add_reservation(Scanner sc, Connection conn)
  {
	  System.out.println(" Please enter First Name of Guest");
	  String fName = sc.nextLine();
	  System.out.println(" Please enter Last Name of Guest");
	  String lName = sc.nextLine();
	  System.out.println(" Please enter number of Guests");
	  int gcount = Integer.parseInt(sc.nextLine());
	  System.out.println(" Please enter date of reservation in format MMM dd yyyy");
	  String reservation_date = sc.nextLine();
	  System.out.println(" Please enter time of reservation in format hh:mm aaa");
	  String reservation_time = sc.nextLine();
	  
	  //boolean to check if guest is added successfully to the list 
	  boolean isGuestAddSuccess = false;
	  res.setFirst_name(fName);
	  res.setLast_name(lName);
	  res.setGuest_count(gcount);
	  res.setReservation_date(reservation_date);
	  res.setReservation_time(reservation_time);
	  isGuestAddSuccess = guestListJDBC.addReservation(res, conn);
	  if(isGuestAddSuccess)
	  {
		 System.out.println(" Guest is added successfully");
	  }
  }
}

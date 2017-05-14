package application;

import java.sql.Connection;
import java.util.Scanner;

import model.reservation.GuestList;

public class ReservationAndWaitlist {

	static Scanner sc = new Scanner(System.in);
	
//	public static void main(String[] args) 
//	{
//		Scanner sc = new Scanner(System.in);
//		menuSelect(sc);
//	}
	
	public ReservationAndWaitlist(){
		menuSelect(sc);
	}
	
	public static String menuSelect(Scanner sc)
	{
		GuestList guestList = new GuestList();
		
		
		//connect to jdbc
		Connection conn = guestList.connect_db();
		
		System.out.println("\n Do you want (A) Reservation or (B) Waitguest (C) Exit?");
		
		String option = sc.nextLine();
		String key = "";
		if(option.equalsIgnoreCase("A"))
		{
			key = "reservation";
			//call reservation
			System.out.println("Do you want to \n"+"A. Add \n"+"B. Remove \n"+"C. View \n"+"D. Search");
			String opt = sc.nextLine();
			if(opt.equalsIgnoreCase("A"))
			{
				//add reservation
				guestList.add_reservation(sc, conn);
				//go back to main menu
				menuSelect(sc);

			}
			else if(opt.equalsIgnoreCase("B"))
			{
				 //remove guest
				 guestList.remove_guest(sc, conn,key);
				 menuSelect(sc);
			}
			else if (opt.equalsIgnoreCase("C"))
			{
				//view list of guest
				guestList.view_guest(conn, key);
				menuSelect(sc);
				 
			}
			else if (opt.equalsIgnoreCase("D"))
			{
				//search guest
				guestList.search_guest(sc, conn, key);
				menuSelect(sc);
			}
		
			
		}
		else if(option.equalsIgnoreCase("B"))
		{
			key = "wait_list";
			//call waitguest
			System.out.println("Do you want to \n"+"A. Add \n"+"B. Remove \n"+"C. View \n"+"D. Search");
			String opt = sc.nextLine();
			if(opt.equalsIgnoreCase("A"))
			{
				//add guest
				guestList.add_guest(sc, conn);
				//go back to main menu
				menuSelect(sc);

			}
			else if(opt.equalsIgnoreCase("B"))
			{
				 //remove guest
				 guestList.remove_guest(sc, conn, key);
				 menuSelect(sc);
			}
			else if (opt.equalsIgnoreCase("C"))
			{
				//view list of guest
				guestList.view_guest(conn, key);
				menuSelect(sc);
				 
			}
			else if (opt.equalsIgnoreCase("D"))
			{
				//search guest
				guestList.search_guest(sc, conn,key);
				menuSelect(sc);
			}
		}
		return option;
	}

}


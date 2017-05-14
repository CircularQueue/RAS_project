package model.reservation;

/**
 * @author shehzuni shahid
 *
 */
public class Reservation extends WaitGuest
{
 private String reservation_time;
 private String reservation_date;


 public Reservation() 
 {
	super();
 }
 public String getReservation_time() 
 {
	return reservation_time;
 }
 public void setReservation_time(String reservation_time) 
 {
	this.reservation_time = reservation_time;
 }
 public String getReservation_date() 
 {
	return reservation_date;
 }
 public void setReservation_date(String reservation_date) 
 {
	this.reservation_date = reservation_date;
 }
}



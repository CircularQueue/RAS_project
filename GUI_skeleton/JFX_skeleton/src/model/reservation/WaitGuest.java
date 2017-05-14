package model.reservation;

//author thomas pederson
public class WaitGuest 
{
  private String first_name;
  private String last_name;
  private int guest_count;
  private int id ;
  
public WaitGuest()
  {
	  
  }
 public String getFirst_name() 
 {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public int getGuest_count() {
	return guest_count;
}

public void setGuest_count(int guest_count) {
	this.guest_count = guest_count;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

  
}
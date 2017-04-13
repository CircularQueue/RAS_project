import java.util.Hashmap;
/**
 * 
 * @author christinasadhu
 *class name: Employees Shift
 *description this class sets a the schedule depending on the availablilty, requested time
 *and the shifts that are taken
 */
/**the name of the employees first and last name 
 * 
 */
public class Employee {
	/**
	 * <p>
	 * firstname
	 * lastname 
	 * the maxhrs
	 * and the minhours they can get depending on the employee
	 * it also depends on what time they are avabile to work and what shifts are already taken by other 
	 * employees 
	 * also it will allow managers to see when the employees requested time off from work
	 * @param fname
	 * @param lname
	 * @param inthours
	 */
	public Employee (String fname, String lname, int hours){}
	
	/** what day the time span the shifttime when it starts and ends 
	 */
	public void addshift(double starttime,double endtime,String day){}
	
	/**returns the employees to the top if they have not yet been assigned to a shift 
	public void setemployees{
	/**
	 * 
	 */
	/**
	 * add new employees and return the employee that works 
	 * @param newEmp
	 */
	public void addemployee(Employee newEmp){
		return "";	
	}
	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @param day
	 * @return
	 * making the scheduele for employees on what time they start and end for the 
	 * day 
	 */
	
	
	public HashMap<String, Double[]> getAllShifts()
	{
		return new HashMap<String, Double[]>();
	}
	/*
	 * tells the time when you start and finish the job for the day 
	 */
	public HashMap<Double, Double> getShiftsOnDay(String day){
		return new HashMap<Double, Double>();
	}
	 
	public void addemployee(string name);
	 /** 
	  * this method will call on a search method to look for an employee and if the employees name or id has been 
	  * found then they will have their position moved around depending on where help is needed in the resturante 
	  * @param remove the employees from the system they no longer work there 
	  */ 
	 public void removeemployee(){
		 return"";
	 }
	 
	 
	 public boolean searchemployee(string name);
	 

}
	
}

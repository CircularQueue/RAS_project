import java.util.HashMap;

public class Manager extends Employee {

	public Manager(String fname, String lname){
		super(fname, lname);
	}
	
	public void addemployee(string name);
	 /** 
	  * this method will call on a search method to look for an employee and if the employees name or id has been 
	  * found then they will have their position moved around depending on where help is needed in the resturante 
	  * @param remove the employees from the system they no longer work there 
	  */ 
	 public Employee removeEmployee(){
		 return"";
	 }
	 
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
		
	 public Employee findEmployeeInformation(string name);
}

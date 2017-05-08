
public class Test {
		public static void main(String[] args) throws ClassNotFoundException{
			EmployeeManagamentJDBC db = new EmployeeManagamentJDBC();
			Employee emp = new Employee("Paul", "Waitress", true);
			db.addemployee(emp);
			System.out.println(db.findEmployeeInformation(emp.getEmployeeName()).toString());
		}

}

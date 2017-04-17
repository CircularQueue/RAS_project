package model.employee;

import java.util.ArrayList;
import java.util.List;

import model.BaseJDBC;
import model.CommonJDBC;
import model.table.Table;

/**
 * This class implements the CommonJDBC interface, and includes some JDBC database actions specific to Employee
 * @author Phillip Witkin
 *
 */
public class EmployeeJDBC extends BaseJDBC<Employee> implements CommonJDBC<Employee>{

	/**
	 * Constructor; establishes database connection
	 * 
	 */
	public EmployeeJDBC() {
		
	}
	

	/**
	 * Finds an Employee by their employeeID
	 * @param employeeID The ID of the employee to search for
	 * @return An Employee object with matching ID from the database
	 */
	@Override
	public Employee finByID(int employeeID) {
		return null;
	}

	/**
	 * 
	 * A sub-class of ArrayList which allows for ArrayLists of those sub-classes to be returned in the child classes of EmployeeJDBC, for specific employees
	 * @author Phillip Witkin
	 *
	 * @param <E> A child class of Employee
	 */
	class EmployeeList<E> extends ArrayList<Employee> {}
	
	/**
	 * Returns an EmployeeList, an ArrayList of Employees matching the condition of the SQLWhere string
	 */
	@Override
	public EmployeeList<? extends Employee> findWhere(String SQLWhere) {
		return null;
	}

	
	@Override
	public Employee update(Employee updatedEmployee) {
		return null;
	}

	@Override
	public Employee create(Employee newEmloyee) {
		return null;
	}

	@Override
	public Employee deleteByID(int employeeID) {
		return null;
	}
	
	

}

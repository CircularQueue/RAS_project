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

	public EmployeeJDBC() {
		
	}
	


	@Override
	public Employee finByID(int ID) {
		// TODO Auto-generated method stub
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

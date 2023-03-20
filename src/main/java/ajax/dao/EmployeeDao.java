package ajax.dao;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import ajax.entity.Employee;

public class EmployeeDao {
	
	private static List<Employee> employees = new CopyOnWriteArrayList<>();
	private static EmployeeDao _instance = new EmployeeDao();
	
	private EmployeeDao() {
		
	}
	
	public static EmployeeDao getInstance() {
		return _instance;
	}
	
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	public int getEmployeeNextId() {
		return employees.size() == 0 ? 1 : employees.get(employees.size()-1).getId() + 1;
	}
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employeeOpt = employees.stream()
							.filter(emp -> emp.getId().equals(id))
							.findFirst();
		return employeeOpt.isPresent() ? employeeOpt.get() : null;
	}
	
	
}

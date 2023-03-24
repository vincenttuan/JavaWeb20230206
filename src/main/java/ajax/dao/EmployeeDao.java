package ajax.dao;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ajax.entity.Employee;

public class EmployeeDao {
	
	private static List<Employee> employees = new CopyOnWriteArrayList<>();
	private static EmployeeDao _instance = new EmployeeDao();
	
	private EntityManagerFactory entityManagerFactory;
	
	private EmployeeDao() {
		// 建立工廠管理器實體 (實務上要配置在 ServletContextListsner 中)
		entityManagerFactory = Persistence.createEntityManagerFactory("demo");
	}
	
	public static EmployeeDao getInstance() {
		return _instance;
	}
	
	public List<Employee> getAllEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select employee From Employee employee"); // PQL
		List<Employee> employees = query.getResultList(); // 將查詢結果傳換成 List
		entityManager.close(); // 關閉 entityManager
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
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void updateEmployee(Integer id, Employee employee) {
		// 根據 id 來查找 index
		int index = employees.indexOf(getEmployeeById(id));
		if(index != -1) {
			employees.set(index, employee);
		}
	}
	
	public void deleteEmployee(Integer id) {
		// 根據 id 來查找 index
		int index = employees.indexOf(getEmployeeById(id));
		if(index != -1) {
			employees.remove(index);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		 // 關閉工廠 (實務上要配置在 ServletContextListsner 中)
		if(entityManagerFactory != null) { 
			entityManagerFactory.close();
		}
	}
	
	
}

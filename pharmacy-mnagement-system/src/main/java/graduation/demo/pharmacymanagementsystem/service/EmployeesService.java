package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.Employee;

public interface EmployeesService {
	public Map<String, Object>  employeeSignIn(String theusername, String thepassword);
	public String restoreThePassword(String username);
	public Employee getEmployeeByUsername(String theusername);
	public String restoreEmail(String theusername);
	public Integer restoreId(String theusername);
	public Integer returnemployeeId(String theemployeename);
	public void saveORupdate (Employee theEmployee);
	public List <Employee> findAllEmployee();
}

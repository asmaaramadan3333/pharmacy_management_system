package graduation.demo.pharmacymanagementsystem.service;

import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Employee;

public interface EmployeesService {
	public Map<String, Boolean>  employeeSignIn(String theusername, String thepassword);
	public String restoreThePassword(String username);
	public Employee getEmployeeByUsername(String theusername);
}

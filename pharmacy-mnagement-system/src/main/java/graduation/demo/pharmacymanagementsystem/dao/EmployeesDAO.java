package graduation.demo.pharmacymanagementsystem.dao;


import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Employee;

public interface EmployeesDAO {
	public Employee signIn(String theusername, String thepassword);
	public Employee getEmployeeByUsername(String theusername);
	public String restoreThePassword(String username);
	public Employee getEmployeeByname(String name);
	public void saveORupdate (Employee theEmployee);
	public List<Employee> findAllEmployee();
}

package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthlyPK;

public interface EmployeeMonthlyService {
	public List<Employee> getallEmployeeWithStatusZero();
	public List getEmployeeNameandHolidays(String month);
	public Map<String, Object> addnew(EmployeesMonthly theemployeesMonthly);
	
	public EmployeesMonthly get_by_id(EmployeesMonthlyPK theid);
	public EmployeesMonthly update(EmployeesMonthly theemployeesMonthly);
}

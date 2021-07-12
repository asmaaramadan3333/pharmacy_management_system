package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Employee;

public interface EmployeeMonthlyService {
	public List<Employee> getallEmployeeWithStatusZero();
	public List getEmployeeNameandHolidays(String month);
}

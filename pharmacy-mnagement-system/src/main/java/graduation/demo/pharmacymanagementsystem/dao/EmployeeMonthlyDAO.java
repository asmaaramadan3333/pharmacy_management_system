package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;

public interface EmployeeMonthlyDAO {
	public List<Employee> getallEmployeeWithStatusZero();
	public int getMonthlyHolidayes(int employeeId,String month);
}

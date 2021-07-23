package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthlyPK;

public interface EmployeeMonthlyDAO {
	public List<Employee> getallEmployeeWithStatusZero();
	public int getMonthlyHolidayes(int employeeId,String month);
	public EmployeesMonthly get_byid(EmployeesMonthlyPK theid);
	public void saveOrUpdate(EmployeesMonthly theemployeesMonthly);
}

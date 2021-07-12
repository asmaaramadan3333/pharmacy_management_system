package graduation.demo.pharmacymanagementsystem.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.service.EmployeeMonthlyService;
import graduation.demo.pharmacymanagementsystem.service.EmployeesService;
@RestController
@RequestMapping("/employeeMonthly")
public class EmployeeMonthlyRestController {
	private EmployeeMonthlyService EmployeeMonthlyService;
	@Autowired
	public EmployeeMonthlyRestController(EmployeeMonthlyService theEmployeeMonthlyService) {
		EmployeeMonthlyService = theEmployeeMonthlyService;
	}
	//// get all employee with status zero 
	@GetMapping("/get_all")
	public List<Employee> findAllEmployee() {
		return EmployeeMonthlyService.getallEmployeeWithStatusZero();
	}
	@GetMapping("/get_all_name_holiday/{month}")
	public List getAllnameAndHolidaiesBI(@PathVariable String month)
	{
		return EmployeeMonthlyService.getEmployeeNameandHolidays(month);
	}
}

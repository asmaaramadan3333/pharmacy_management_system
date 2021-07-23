package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.annotation.Put;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
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
	
	
	@PostMapping("/add_new")
	public Map<String, Object> add_new_row (@RequestBody EmployeesMonthly theemployeesMonthly)
	{    Map<String, Object> coordinates = new HashMap<>();
		
	      coordinates = EmployeeMonthlyService.addnew(theemployeesMonthly);
		
		return coordinates;
		
	}
	
	@PutMapping("/update")
	public EmployeesMonthly update_row (@RequestBody EmployeesMonthly theemployeesMonthly)
	{    
		
	EmployeesMonthly theemployeesMonthly2 = EmployeeMonthlyService.update(theemployeesMonthly);
		return theemployeesMonthly2;
		
	}
}

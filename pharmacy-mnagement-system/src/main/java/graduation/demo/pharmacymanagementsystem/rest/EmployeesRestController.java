package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;
import graduation.demo.pharmacymanagementsystem.service.EmployeesService;

@RestController
@RequestMapping("/api")
public class EmployeesRestController {
	private EmployeesService employeesService;
	@Autowired
	public EmployeesRestController(EmployeesService theEmployeesService) {
		employeesService = theEmployeesService;
	}
	@GetMapping("/employee_signIn/{username}/{thepassword}")
	public Map Employee_signIn(@PathVariable String username,@PathVariable String thepassword) {
		Map <String,Boolean> coordinates = new HashMap<>();

		coordinates = employeesService.employeeSignIn(username, thepassword);
		return coordinates ;
	}
	@GetMapping("/return_the_password/{username}")
	public String restoreThePassword(@PathVariable String username)
	{
		return employeesService.restoreThePassword(username);
	}
	@GetMapping("return_the_employee/{theusername}")
	public Employee getEmployeeByUsername(@PathVariable String theusername)
	{
        Employee theEmployee =employeesService.getEmployeeByUsername(theusername);
		
		if (theEmployee == null) {
			throw new RuntimeException("customer not found - " + theusername);
		}
		
		return theEmployee;
	}
	
}

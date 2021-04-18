package graduation.demo.pharmacymanagementsystem.rest;

import java.net.URLDecoder;
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

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;
import graduation.demo.pharmacymanagementsystem.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeesRestController {
	private EmployeesService employeesService;
	@Autowired
	public EmployeesRestController(EmployeesService theEmployeesService) {
		employeesService = theEmployeesService;
	}
  
	////////////////////get all employee/////////////////
	@GetMapping("/get_all")
	public List<Employee> findAllCustomers() {
		return employeesService.findAllEmployee();
	}
	/////////////employee sign in /////////////////////////
		@GetMapping("/employee_signIn/{username}/{thepassword}")
		public Map Employee_signIn(@PathVariable String username,@PathVariable String thepassword) {
			Map <String,Boolean> coordinates = new HashMap<>();
	
			coordinates = employeesService.employeeSignIn(username, thepassword);
			return coordinates ;
		}
	/////////////////return the user name and password by user name///////////////
	@GetMapping("/return_the_password_and_email/{username}")
		public Map restoreThePassword(@PathVariable String username)
		{
			Map <String,String> coordinates = new HashMap<>();	
			coordinates.put("thepassword",employeesService.restoreThePassword(username));
			coordinates.put("theemail",employeesService.restoreEmail(username));
			return coordinates;
			
		}
	////////////////return the id by user name///////////////////////
	@GetMapping("/return_the_Id/{username}")
		public Map returnTheId(@PathVariable String username)
		{
			Map <String,Integer> coordinates = new HashMap<>();	
			coordinates.put("theID",employeesService.restoreId(username));
			return coordinates;
			
		}
	///////////////return the employee by user name//////////////////
	@GetMapping("/return_the_employee/{theusername}")
		public Employee getEmployeeByUsername(@PathVariable String theusername)
		{
	        Employee theEmployee =employeesService.getEmployeeByUsername(theusername);
			
			if (theEmployee == null) {
				throw new RuntimeException("customer not found - " + theusername);
			}
			
			return theEmployee;
		}
	/////////////////////////return the id of employee by taking the employee name/////////////////////
	@GetMapping("/return_the__employee_Id/{theemployeename}")
		public Map returnTheIdbyname(@PathVariable String theemployeename)
		{    
			Map <String,Integer> coordinates = new HashMap<>();	
			coordinates.put("theID",employeesService.returnemployeeId(theemployeename));
			return coordinates;
			
		}
	////////////////////////////////////add_new_employee///////////////////////////

	@PostMapping("/add_new")
		public Employee addCustomer(@RequestBody Employee theEmployee) {
	
			// also just in case they pass an id in JSON ... set id to 0
	
			// this is to force a save of new item ... instead of update
	
			theEmployee.setId(0);
	
			employeesService.saveORupdate(theEmployee);
	
			return theEmployee;
		}

}

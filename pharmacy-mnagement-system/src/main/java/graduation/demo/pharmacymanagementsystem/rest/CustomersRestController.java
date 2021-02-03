package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;

@RestController
@RequestMapping("/api")
public class CustomersRestController {

	private CustomersService customersService;
	
	@Autowired
	public CustomersRestController(CustomersService theCustomersService) {
		customersService = theCustomersService;
	}
	

	// expose "/Customers" and return list of Customers
	@GetMapping("/customers")
	public List <Customer> findAllCustomers() {
		return customersService.findAllCustomers();
	}

	// add mapping for GET /Customers/{CustomerCode}
	
	@GetMapping("/Customers/{CustomerId}")
	public Customer getCustomer(@PathVariable int CustomerId) {
		
		Customer theCustomer = customersService.findByCode(CustomerId);
		
		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + CustomerId);
		}
		
		return theCustomer;
	}
	
	@GetMapping("/Customers_search/{CustomerName}")
	public List<Customer> getCustomer(@PathVariable String CustomerName) {
		
		List<Customer> theCustomer = customersService.searchByName(CustomerName);
		
		if (theCustomer.size() == 0) {
			throw new RuntimeException("Customer not found - " + CustomerName);
		}
		
		return theCustomer;
	}
	
	@GetMapping("/Customer_email/{CustomerEmail}")
	public Customer getCustomerByemail(@PathVariable String CustomerEmail) {
		
		Customer theCustomer = customersService.getCustomerByEmail(CustomerEmail);
		
		if (theCustomer == null) {
			throw new RuntimeException("customer not found - " + CustomerEmail);
		}
		
		return theCustomer;
	}
	
	
	@GetMapping("/customer_signIn/{theemail}/{thepassword}")
	
	public Map Customer_signIn(@PathVariable String theemail,@PathVariable String thepassword) {
		
		Map <String,Boolean> coordinates = new HashMap<>();

		coordinates = customersService.customerSignIn(theemail, thepassword);
		
		return coordinates ;
	}

	
	
	
	
	
	
	
	
	
	// add mapping for POST /Customers - add new Customers
	
	@PostMapping("/Customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case they pass an id in JSON ... set id to 0
		
		// this is to force a save of new item ... instead of update
		
		theCustomer.setCustomerId(0);
		
		customersService.saveORupdate(theCustomer);
		
		return theCustomer;
	}
	
	
	// add mapping for PUT /Customers - update existing Customer
	
	@PutMapping("/Customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customersService.saveORupdate(theCustomer);
		
		return theCustomer;
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/customer_signup")

	public Map<String,Integer> signUp(@RequestBody Customer theCustomer) {
		      
		return customersService.signUp(theCustomer);
	}
	
	@PostMapping("/add_products_to_customer")
	public Customer  add_products_to_customer( @RequestBody Map<String, Integer> userData){
      
		int theCustomerId =userData.get("customerId");
		int theproductCode = userData.get("code");
		
		customersService.add_products_to_customer(theCustomerId, theproductCode);
		return getCustomer(theCustomerId);
	}
	
	
	
	
	// add mapping for DELETE /Customers/{CustomerCode} - delete Customer
	
	@DeleteMapping("/Customers/{CustomerId}")
	public String deleteCustomer(@PathVariable int CustomerId) {
		
		Customer tempCustomer = customersService.findByCode(CustomerId);
		
		// throw exception if null
		
		if (tempCustomer == null) {
			throw new RuntimeException("Customer code not found - " + CustomerId);
		}
		
		customersService.deleteByCode(CustomerId);
		
		return "Deleted Customer id - " + CustomerId;
	}

	
	
	
}

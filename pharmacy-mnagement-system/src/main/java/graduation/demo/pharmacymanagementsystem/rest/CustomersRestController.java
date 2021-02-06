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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.dto.CustomersProductsHistoryDTO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomersRestController {

	private CustomersService customersService;


	@Autowired
	public CustomersRestController(CustomersService theCustomersService) {
		customersService = theCustomersService;
	}

	// expose "/get_all" and return list of Customers
	@GetMapping("/get_all")
	public List<Customer> findAllCustomers() {
		return customersService.findAllCustomers();
	}

	// add mapping for GET /get_by_id/{CustomerId}

	@GetMapping("/get_by_id/{CustomerId}")
	public Customer getCustomer(@PathVariable int CustomerId) {

		Customer theCustomer = customersService.findByCode(CustomerId);

		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + CustomerId);
		}

		return theCustomer;
	}

	// add mapping for GET /search_by_name/{CustomerName}

	@GetMapping("/search_by_name/{CustomerName}")
	public List<Customer> getCustomer(@PathVariable String CustomerName) {

		List<Customer> theCustomer = customersService.searchByName(CustomerName);

		if (theCustomer.size() == 0) {
			throw new RuntimeException("Customer not found - " + CustomerName);
		}

		return theCustomer;
	}

	// add mapping for GET /search_by_email/{CustomerEmail}

	@GetMapping("/search_by_email/{CustomerEmail}")
	public Customer getCustomerByemail(@PathVariable String CustomerEmail) {

		Customer theCustomer = customersService.getCustomerByEmail(CustomerEmail);

		if (theCustomer == null) {
			throw new RuntimeException("customer not found - " + CustomerEmail);
		}

		return theCustomer;
	}

	// add mapping for GET /signIn/{theemail}/{thepassword} -customer sign in

	@GetMapping("/signIn/{theemail}/{thepassword}")

	public Map<String, Boolean> Customer_signIn(@PathVariable String theemail, @PathVariable String thepassword) {

		Map<String, Boolean> coordinates = new HashMap<>();

		coordinates = customersService.customerSignIn(theemail, thepassword);

		return coordinates;
	}

	// add mapping for POST /add_new - add new Customers

	@PostMapping("/add_new")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// also just in case they pass an id in JSON ... set id to 0

		// this is to force a save of new item ... instead of update

		theCustomer.setCustomerId(0);

		customersService.saveORupdate(theCustomer);

		return theCustomer;
	}

	// 	 add mapping for POST /signup -  Customers sign up

	@SuppressWarnings("unchecked")
	@PostMapping("/sign_up")

	public Map<String, Integer> signUp(@RequestBody Customer theCustomer) {

		return customersService.signUp(theCustomer);
	}


 	// add mapping for POST /add_products_to_customer - add products to the customer

	@PostMapping("/add_products")
	public Customer add_products_to_customer(@RequestBody CustomersProductsHistoryDTO customer_products) {

		int theCustomerId = customer_products.getCustomerId();
		int theproductCode =  customer_products.getCode();

		customersService.add_products_to_customer(theCustomerId, theproductCode);
		
		return getCustomer(theCustomerId);

	}

	// add mapping for PUT /update - update existing Customer

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customersService.saveORupdate(theCustomer);

		return theCustomer;
	}

	// add mapping for DELETE /delete_by_id/{CustomerCode} - delete Customer

	@DeleteMapping("/delete_by_id/{CustomerId}")
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

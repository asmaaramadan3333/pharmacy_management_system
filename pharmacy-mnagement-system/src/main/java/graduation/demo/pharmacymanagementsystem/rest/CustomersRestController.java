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

import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.dto.CustomersProductsHistoryDTO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomersRestController {

	private CustomersService customersService;

	@Autowired
	public CustomersRestController(CustomersService theCustomersService) {
		customersService = theCustomersService;
	}

//////////////////////// get requests///////////////
	// return list of customers //
	@GetMapping("/get_all")
	public List<Customer> findAllCustomers() {
		return customersService.findAllCustomers();
	}

	// get customer by customer id//
	@GetMapping("/get_by_id/{CustomerId}")
	public Customer getCustomer(@PathVariable int CustomerId) {

		Customer theCustomer = customersService.findByCode(CustomerId);

		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + CustomerId);
		}

		return theCustomer;
	}

	// search for certain customers by customer name//
	@GetMapping("/search_by_name/{CustomerName}")
	public List<Customer> getCustomer(@PathVariable String CustomerName) {

		List<Customer> theCustomer = customersService.searchByName(CustomerName);

		if (theCustomer.size() == 0) {
			throw new RuntimeException("Customer not found - " + CustomerName);
		}

		return theCustomer;
	}

	// get customer by customer email//
	@GetMapping("/get_by_email/{CustomerEmail}")
	public Customer getCustomerByemail(@PathVariable String CustomerEmail) {

		Customer theCustomer = customersService.getCustomerByEmail(CustomerEmail);

		if (theCustomer == null) {
			throw new RuntimeException("customer not found - " + CustomerEmail);
		}

		return theCustomer;
	}

	// sign in customer by email and password //
	@GetMapping("/signIn/{theemail}/{thepassword}")
	public Map<String, Object> Customer_signIn(@PathVariable String theemail, @PathVariable String thepassword) {

		Map<String, Object> coordinates = new HashMap<>();

		coordinates = customersService.customerSignIn(theemail, thepassword);

		return coordinates;
	}

	// *********** post requests///////////////

	/*
	 * // add mapping for POST /add_new - add new Customers for desktop //
	 * 
	 * @PostMapping("/add_new") public Map<String, Integer> addCustomer(@RequestBody
	 * Customer theCustomer) { Map<String, Integer> coordinates = new HashMap<>();
	 * Customer customer1= customersService.saveandreturncustomer(theCustomer);
	 * coordinates.put("customerId", customer1.getCustomerId()); return coordinates;
	 * }
	 */

	//////////////////////// add_new_phone_to_customer/////////////
	@PostMapping("/add_new_phone_to_customer")
	public CustomersPhone addphoneForCustomer(@RequestBody CustomersPhone theCustomersPhone) {
		Customer thecustomer = customersService.findByCode(theCustomersPhone.getId().getCustomerId());
		if (thecustomer == null) {
			throw new RuntimeException(" the Customer  not found ");
		}

		thecustomer.addCustomersPhone(theCustomersPhone);
		
		customersService.saveORupdate(thecustomer);
		
		return theCustomersPhone;
	}

	/////////////////// sign up customer for mobile //////////////////////
	@SuppressWarnings("unchecked")
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(@RequestBody Customer theCustomer) {
		return customersService.signUp(theCustomer);
	}

	/////////////////// add products to customer ////////////////////
	@PostMapping("/add_products")
	public Customer add_products_to_customer(@RequestBody CustomersProductsHistoryDTO customer_products) {

		int theCustomerId = customer_products.getCustomerId();
		int theproductCode = customer_products.getCode();

		customersService.add_products_to_customer(theCustomerId, theproductCode);

		return getCustomer(theCustomerId);

	}

	/////////////////////// add new address to customer //////////////
	@PostMapping("/add_new_address")
	public CustomersAddress addAddressForCustomer(@RequestBody CustomersAddress theCustomersAddress) {

		Customer thecustomer = customersService.findByCode(theCustomersAddress.getId().getCustomerId());
		if (thecustomer == null) {
			throw new RuntimeException(" the Customer  not found ");
		}
		thecustomer.addCustomersAddress(theCustomersAddress);

		customersService.saveORupdate(thecustomer);

		return theCustomersAddress;
	}

	////////////////// edit customer /////////////////////////

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customersService.saveORupdate(theCustomer);
		return theCustomer;
	}
   //////////////////edit customer password /////////////////////////

	@PutMapping("/update_password")
	public Map<String, Object> updateCustomerPassword(@RequestBody Customer theCustomer) {
	    
		Map<String, Object> coordinates = new HashMap<>();
	    
		coordinates = customersService.updatePassword(theCustomer.getCustomerId(),theCustomer.getPassword());

		return coordinates;
	}
 
	//////////////////////// delete customer by customer id //////////////////////////
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

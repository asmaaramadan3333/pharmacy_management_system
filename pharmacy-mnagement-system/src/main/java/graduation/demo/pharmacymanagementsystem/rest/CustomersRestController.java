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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.dto.CustomerDTO;
import graduation.demo.pharmacymanagementsystem.dto.CustomersProductsHistoryDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddressPK;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
import graduation.demo.pharmacymanagementsystem.service.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomersRestController {

	private CustomersService customersService;

	@Autowired
	public CustomersRestController(CustomersService theCustomersService) {
		customersService = theCustomersService;
	}

	public CustomersRestController() {
		// TODO Auto-generated constructor stub
	}

	//////////////////////// get requests///////////////
	// return list of customers //
	@GetMapping("/get_all")
	public List<Customer> findAllCustomers() {
		return customersService.findAllCustomers();
	}

	// return list of customers without id and password //

	/*
	 * @GetMapping("/get_all") public List<Customer> custom_findAllCustomerscustom()
	 * { List<Customer> list_customers = customersService.findAllCustomers();
	 * for(int i=0 , i < list_customers.size() ,i++) {
	 * 
	 * }
	 * 
	 * list_customers.get
	 * 
	 * return customersService.custom_findAllCustomerscustom(); }
	 */

	////////////// get list of customers with balance =< 0///

	@GetMapping("/get_Paid")
	public List<Customer> findpaidCustomers() {
		return customersService.findpaidCustomers();
	}

//////////////get list of customers with balance > 0 ///
	@GetMapping("/get_credit_added_customers")
	public List<Customer> findcredit_addedCustomers() {
		return customersService.findcredit_addedCustomers();
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

	/*//try
	@GetMapping("/get_by_id_ex")
	@ResponseBody
	public String getFoos(@RequestParam(name = "id") int id) {
	    return "ID: " + id;
	}
	*/
	
	
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

	// add mapping for POST /add_new - add new Customers for desktop //

	/*@PostMapping("/add_new")
	public Map<String, Integer> addCustomer(@RequestBody Customer theCustomer) {
		Map<String, Integer> coordinates = new HashMap<>();
		Customer customer1 = customersService.saveandreturncustomer(theCustomer);
		coordinates.put("customerId", customer1.getCustomerId());
		return coordinates;
	}*/

	// add mapping for POST /add_new - add new Customers for desktop //
	
	@PostMapping("/add_new")
	public Map<String, Object> addCustomer_desktop(@RequestBody CustomerDTO theCustomerdto) {

		Map<String, Object> coordinates = new HashMap<>();
		
		Customer theCustomer = customersService.save_desktop(theCustomerdto);

		if (theCustomer!=null)
		{		
			int customerId = theCustomer.getCustomerId();
		
		if (theCustomerdto.getPhoneNumber() != null)
		{
			CustomersPhone theCustomersPhone = new CustomersPhone();

			CustomersPhonePK theCustomersPhonePK = new CustomersPhonePK();
			theCustomersPhonePK.setCustomerId(customerId);
			theCustomersPhonePK.setPhoneNumber(theCustomerdto.getPhoneNumber());

			theCustomersPhone.setId(theCustomersPhonePK);

			theCustomer.addCustomersPhone(theCustomersPhone);

			customersService.saveORupdate(theCustomer);

		}

		if (theCustomerdto.getAddress() != null) {
			
			CustomersAddress theCustomersAddress = new CustomersAddress();

			CustomersAddressPK theCustomersAddressPK = new CustomersAddressPK();
			theCustomersAddressPK.setCustomerId(customerId);
			theCustomersAddressPK.setAddress( theCustomerdto.getAddress());

			theCustomersAddress.setId(theCustomersAddressPK);

			theCustomer.addCustomersAddress(theCustomersAddress);

			customersService.saveORupdate(theCustomer);
		}
		coordinates.put("status", 1);
		coordinates.put( "the theCustomer_phone is newly added ", "success");
		return coordinates;
		
		}
		else
		{
			coordinates.put("states", 0);
			coordinates.put( "the theCustomer_phone already exists ", "failed");
		}
			
		return coordinates;
	}

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

	/*
	 * @PostMapping("/add_new_Bill_to_customer") public Bill
	 * addBillForCustomer(@RequestBody Bill theBill) {
	 * 
	 * Customer thecustomer = customersService.findByCode(theBill.getCustomerId());
	 * if (thecustomer == null) { throw new
	 * RuntimeException(" the Customer  not found "); }
	 * 
	 * thecustomer.addBill(theBill);
	 * 
	 * customersService.saveORupdate(thecustomer);
	 * 
	 * return theBill; }
	 */

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
	public Map<String, Object> addAddressForCustomer(@RequestBody CustomersAddress theCustomersAddress) {

		Map<String, Object> coordinates = new HashMap<>();
		Customer thecustomer = customersService.findByCode(theCustomersAddress.getId().getCustomerId());
		if (thecustomer == null) {

			coordinates.put("states", 0);

			coordinates.put("the customer id not found ", theCustomersAddress.getId().getCustomerId());

		} else {
			thecustomer.addCustomersAddress(theCustomersAddress);
			customersService.saveORupdate(thecustomer);
			coordinates.put("states", 1);
			coordinates.put("the customer address posted ", theCustomersAddress);
		}
		return coordinates;
	}

////////////############################////////////////////////////////////

	////////////////////////// add new bill to the customer not finished
	////////////////////////// ////////////////
	/*
	 * @PostMapping("/add_new_bill_to_customer") public Bill
	 * addphoneForCustomer(@RequestBody Bill theBill) { //public Bill
	 * addbillTocustomer(Bill theBill) { Customer thecustomer =
	 * customersService.findByCode(theBill.getCustomer().getCustomerId()); if
	 * (thecustomer == null) { throw new
	 * RuntimeException(" the Customer  not found "); }
	 * 
	 * thecustomer.addBill(theBill);
	 * 
	 * customersService.saveORupdate(thecustomer);
	 * 
	 * return theBill; }
	 */

	////////////////// edit customer /////////////////////////

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customersService.saveORupdate(theCustomer);
		return theCustomer;
	}
	////////////////// edit customer password /////////////////////////

	@PutMapping("/update_password")
	public Map<String, Object> updateCustomerPassword(@RequestBody Customer theCustomer) {

		Map<String, Object> coordinates = new HashMap<>();

		coordinates = customersService.updatePassword(theCustomer.getCustomerId(), theCustomer.getPassword());

		return coordinates;
	}

	///////////////////// update customer by phone for desktop /////////////////////
	
	@PutMapping("/update_by_phone")
	public Customer updateCustomer_by_phone(@RequestBody CustomerDTO theCustomerdto) {
		
		Customer the_customer = customersService.updateCustomer_by_phone( theCustomerdto);
		
		return the_customer;
	}
	
	
	
	
	//////////////////////// delete customer by customer id
	//////////////////////// //////////////////////////
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

package graduation.demo.pharmacymanagementsystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
import graduation.demo.pharmacymanagementsystem.service.CustomersPhoneService;

@RestController
@RequestMapping("/customerphone")
public class CustomersPhoneRestController {
	private CustomersPhoneService customersPhoneService;
	@Autowired
	public CustomersPhoneRestController(CustomersPhoneService theCustomersPhoneService) {
		customersPhoneService =theCustomersPhoneService;
	}

	/*
	 * @DeleteMapping("/delete_phone_by_id/{CustomerId}/{customersPhone}") public
	 * CustomersPhone getCustomerphone(@PathVariable int CustomerId,@PathVariable
	 * CustomersPhone customersPhone) {
	 * 
	 * Customer theCustomer = customersPhoneService.findByCode(CustomerId);
	 * 
	 * if (theCustomer == null) { throw new
	 * RuntimeException("Customer id not found - " + CustomerId); }
	 * 
	 * return theCustomer.removeCustomersPhone(customersPhone); }
	 */
	
	/*
	 * @PostMapping("/add_new_phone") public CustomersPhone
	 * addphoneForCustomer(@RequestBody CustomersPhone theCustomersPhone ) {
	 * 
	 * customersPhoneService.save(theCustomersPhone);
	 * 
	 * return theCustomersPhone; }
	 */
	
	
	
	/*
	 * @DeleteMapping("delete_by_customer_id") public String
	 * deleteSupply(@PathVariable int supply_bill_id) {
	 * 
	 * Supply tempSupply =customersPhoneService.;
	 * 
	 * // throw exception if null
	 * 
	 * if (tempSupply == null) { throw new
	 * RuntimeException("Supply code not found - " + supply_bill_id); }
	 * 
	 * SuppliesService.deleteByCode(supply_bill_id);
	 * 
	 * return "Deleted Supply id - " + supply_bill_id; }
	 */
}

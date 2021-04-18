package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
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
import graduation.demo.pharmacymanagementsystem.service.CustomersAddressService;


@RestController
@RequestMapping("/customeraddress")
public class CustomersAddressRestController {
	
	private CustomersAddressService customersAddressService;


	@Autowired
	public CustomersAddressRestController(CustomersAddressService theCustomersAddressService) {
		customersAddressService =theCustomersAddressService;
	}
	// add mapping for GET /get_address_by_id/{CustomerId}

	@GetMapping("/get_address_by_id/{theCustomerId}")
	public CustomersAddress getCustomer(@PathVariable int theCustomerId) {

		CustomersAddress theCustomerAddress =customersAddressService.findCustomerAddressByCustomrId(theCustomerId) ;

		if (theCustomerAddress == null) {
			throw new RuntimeException("Customer id not found - " + theCustomerId);
		}

		return theCustomerAddress;
	}
	@DeleteMapping("/delete_address_by_customer_id/{CustomerId}")
	public Map <String,Object>deleteCustomer(@PathVariable int CustomerId) {
		Map<String, Object> coordinates = new HashMap<>();
		CustomersAddress theCustomerAddress  = customersAddressService.findCustomerAddressByCustomrId(CustomerId);

		// throw exception if null

		if (theCustomerAddress == null) {
			coordinates.put("Customer id not found - " ,CustomerId);
		}
		else {
		customersAddressService.deleteById(CustomerId);
		coordinates.put("the customer address  deleted" ,CustomerId);
		}
		return coordinates;
	}

	@PutMapping("/update")
	public CustomersAddress updateCustomersAddress(@RequestBody CustomersAddress theCustomersAddress) {

		customersAddressService.saveORupdate(theCustomersAddress);

		return theCustomersAddress;
	}

	}


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

import graduation.demo.pharmacymanagementsystem.dto.CustomerAddressDTO;
import graduation.demo.pharmacymanagementsystem.dto.CustomersPhoneDTO;
import graduation.demo.pharmacymanagementsystem.dto.CustomersProductsHistoryDTO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.service.CustomersAddressService;

@RestController
@RequestMapping("/customeraddress")
public class CustomersAddressRestController {

	private CustomersAddressService customersAddressService;

	@Autowired
	public CustomersAddressRestController(CustomersAddressService theCustomersAddressService) {
		customersAddressService = theCustomersAddressService;
	}

	/////////////////////////////// get all addresses for certain customer by the customerId /////////////////////////
	@GetMapping("/get_address_by_customer_id/{theCustomerId}")
	public Map<String, Object> getCustomer(@PathVariable int theCustomerId) {
		Map<String, Object> coordinates = new HashMap<>();
		
		List<CustomersAddress> theCustomerAddress = customersAddressService.findCustomerAddressByCustomrId(theCustomerId);
       
		if (theCustomerAddress == null || theCustomerAddress.isEmpty()) 
		  {	
			  //throw new RuntimeException("the customer not found " + CustomerId);
			coordinates.put("status", 0);
			coordinates.put("message","the Customer does not have any address" );
			return coordinates;
		  }
		  else {
			  coordinates.put("status", 1);
			  coordinates.put("the_customer_addresses:",theCustomerAddress);
			  return coordinates;
		  }
	}

	/////////////////////////// get Specific CustomerPhone by the customer id and the phone number ////////////////////////
	@GetMapping("/get_rowof_customersaddress/{CustomerId}/{address}")
	public CustomersAddress getrowOfCustomerAddress(@PathVariable int CustomerId, @PathVariable String address)
	{
		CustomersAddress theCustomeraddress = customersAddressService.findSpecificCustomerAddress(CustomerId, address);

			return theCustomeraddress;
	}
	//////////////// check if the address already in database//////////////
	@GetMapping("/checkAddress/{CustomerId}/{address}")
	public Map<String,Object> getrowOfCustomerAddressCheck(@PathVariable int CustomerId, @PathVariable String address)
	{  	Map<String, Object> coordinates = new HashMap<>();
		CustomersAddress theCustomeraddress = customersAddressService.findSpecificCustomerAddress(CustomerId, address);
		if (theCustomeraddress==null)
		{
			coordinates.put("states", 0);
			coordinates.put( "the customer address not found ", address);
		}
		else {
		
		coordinates.put("states", 1);
		coordinates.put( "the customer address found ", theCustomeraddress);
		}
		return coordinates;
	}
	/////////////////////////////// delete the customer phone//////////////////////////////////

	@DeleteMapping("/delete_address_by_customer_id/{CustomerId}/{address}")
	public Map<String,Object> deleteCustomeraddress(@PathVariable int CustomerId, @PathVariable String address) 
	{

		Map<String, Object> coordinates = new HashMap<>();
		CustomersAddress theCustomersAddress = getrowOfCustomerAddress(CustomerId, address);
		if (theCustomersAddress==null)
		{
			coordinates.put("states", 0);
			coordinates.put( "the customer address not found ", address);
		}
		else {
		customersAddressService.deleteById(CustomerId, address);
		coordinates.put("states", 1);
		coordinates.put( "the customer address deleted ", address);
		}
		return coordinates;
	}


	@PutMapping("/editAddress")
  	public Map<String,Object> updatecustomersaddress(@RequestBody CustomerAddressDTO thecustomeraddress) {
		System.out.println(thecustomeraddress);
		Map<String, Object> coordinates = new HashMap<>();
    	 int theCustomerId=thecustomeraddress.getTheCustomerId();
    	 
    	 String theCustomerAddressold=thecustomeraddress.getTheCustomerAddressOld();
    	 String theCustomerAdressnew=thecustomeraddress.getTheCustomerAddressNew();
    	 CustomersAddress tempCustomersAddress = getrowOfCustomerAddress(theCustomerId, theCustomerAddressold);
    	 if (tempCustomersAddress==null)
 		{
 			coordinates.put("states", 0);
 			coordinates.put( "the customer address not found ", tempCustomersAddress);
 		}
 		else {
 	     customersAddressService.update(tempCustomersAddress,theCustomerAdressnew);
    	 CustomersAddress tempcustomeraddress=getrowOfCustomerAddress(theCustomerId, theCustomerAdressnew);
 		coordinates.put("states", 1);
 		coordinates.put( "the customer address edited",tempcustomeraddress);
 		}
 		return coordinates;
  	}

}

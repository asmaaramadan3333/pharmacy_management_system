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
	public List<CustomersAddress> getCustomer(@PathVariable int theCustomerId) {

		List<CustomersAddress> theCustomerAddress = customersAddressService.findCustomerAddressByCustomrId(theCustomerId);

		 if (theCustomerAddress == null && theCustomerAddress.isEmpty()) {
				throw new RuntimeException("the customer dosen't have addresses " + theCustomerId);
			}

		return theCustomerAddress;
	}

	/////////////////////////// get Specific CustomerPhone by the customer id and the phone number ////////////////////////
	@GetMapping("/get_rowof_customersphone/{CustomerId}/{address}")
	public CustomersAddress getrowOfCustomerAddress(@PathVariable int CustomerId, @PathVariable String address)
	{
		CustomersAddress theCustomeraddress = customersAddressService.findSpecificCustomerPhone(CustomerId, address);

			return theCustomeraddress;
	}

	/////////////////////////////// delete the customer phone//////////////////////////////////

	@DeleteMapping("/delete_address_by_customer_id/{CustomerId}/{address}")
	public Map<String,Object> deleteCustomerphone(@PathVariable int CustomerId, @PathVariable String address) 
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
  	public CustomersAddress updatecustomersPhone(@RequestBody CustomerAddressDTO thecustomeraddress) {
    	 int theCustomerId=thecustomeraddress.getTheCustomerId();
    	 String theCustomerAddressold=thecustomeraddress.getTheCustomerAddressOld();
    	 String theCustomerAdressnew=thecustomeraddress.getTheCustomerAddressNew();
    	 CustomersAddress tempCustomersAddress = getrowOfCustomerAddress(theCustomerId, theCustomerAddressold);
    	 customersAddressService.update(tempCustomersAddress,theCustomerAdressnew);
    	 CustomersAddress tempcustomerphone2=getrowOfCustomerAddress(theCustomerId, theCustomerAdressnew);
  		return tempcustomerphone2;
  	}

}

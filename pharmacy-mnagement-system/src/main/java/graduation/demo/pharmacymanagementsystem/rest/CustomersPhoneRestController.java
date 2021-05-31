package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import graduation.demo.pharmacymanagementsystem.dto.CustomersPhoneDTO;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.service.CustomersPhoneService;

@RestController
@RequestMapping("/customerphone")
public class CustomersPhoneRestController {
	private CustomersPhoneService customersPhoneService;
	@Autowired
	public CustomersPhoneRestController(CustomersPhoneService theCustomersPhoneService) {
		customersPhoneService =theCustomersPhoneService;
	}

	/////////////////////////////////// get list of customer phones by customer id///////////////////////////
	@GetMapping("/get_customerphones_bycid/{CustomerId}")
	public  Map<String, Object>  getCustomerphone (@PathVariable int CustomerId)
	{

		  Map<String, Object> coordinates = new HashMap<>();
		  List <CustomersPhone> theCustomer_phones = customersPhoneService.findCustomerPhoneByCustomrId (CustomerId);
		  if (theCustomer_phones == null || theCustomer_phones.isEmpty()) 
		  {	
			coordinates.put("status", 0);
			coordinates.put("message","the Customer does not have any phone" );
			return coordinates;
		  }
		  else {
			  coordinates.put("status", 1);
			  coordinates.put("the_customer_phones:",theCustomer_phones);
			  return coordinates;
		  }
	}
	
	/////////////////////////// get Specific CustomerPhone by the customer id and the phone number ////////////////////////
	@GetMapping("/get_rowof_customersphone/{CustomerId}/{phone}")
	public CustomersPhone getrowOfCustomerphone (@PathVariable int CustomerId ,@PathVariable String theCustomerPhoneold)
	{
		  CustomersPhone theCustomer_phone = customersPhoneService.findSpecificCustomerPhone(CustomerId,theCustomerPhoneold);
		
		return theCustomer_phone;
	}
	//////////////////////check if the phone is found with phone and customerId//////////////////////
	@GetMapping("/checkphone/{CustomerId}/{phone}")
	public Map<String,Object> getrowOfCustomerPhoneCheck(@PathVariable int CustomerId, @PathVariable String phone)
	{  	Map<String, Object> coordinates = new HashMap<>();
	    CustomersPhone theCustomer_phone = customersPhoneService.findSpecificCustomerPhone(CustomerId,phone);
		if (theCustomer_phone==null)
		{
			coordinates.put("status", 0);
			coordinates.put( "the theCustomer_phone not found ", theCustomer_phone);
		}
		else {
		
		coordinates.put("status", 1);
		coordinates.put( "the theCustomer_phone found ", theCustomer_phone);
		}
		return coordinates;
	}

	///////////////////////check if the phone is found for desktop////////////////
	@GetMapping("/checkphone_by_phone/{phone}")
	public CustomersPhone get_customer_by_phone( @PathVariable String phone)
	{  
		//Map<String, Object> coordinates = new HashMap<>();
		
		//coordinates = customersPhoneService.get_customer_by_phone(phone);
		
		CustomersPhone theCustomer_phone = customersPhoneService.get_customer_by_phone(phone);
		
		return theCustomer_phone;
	}
	
	
	/////////////////////////////// delete the customer phone //////////////////////////////////
	
	  @DeleteMapping("/delete_phone_by_id/{CustomerId}/{customerPhone}") 
	  public Map<String,Object> deleteCustomerphone(@PathVariable int CustomerId,@PathVariable String customerPhone) 
	  {
	  Map<String, Object> coordinates = new HashMap<>();
	  List <CustomersPhone> theCustomer_phones = customersPhoneService.findCustomerPhoneByCustomrId (CustomerId);
	  
	  CustomersPhone theCustomerPhone = getrowOfCustomerphone (CustomerId,customerPhone);
	  if(theCustomerPhone==null)
	  {
			coordinates.put("status", 0);
			coordinates.put( "the customer phone not found ",customerPhone);
	  }
	  else 
	  {
	  customersPhoneService.deleteById(CustomerId,customerPhone);
	  coordinates.put("status", 1);
	  coordinates.put( "the customer phone deleted ", customerPhone);
	  }	 
	  return coordinates;
			   
	  }


	
    @PutMapping("/editphone")
  	public Map<String,Object> updatecustomersPhone(@RequestBody CustomersPhoneDTO thecustomersphone) {
    	 Map<String, Object> coordinates = new HashMap<>();
    	 int theCustomerId=thecustomersphone.getTheCustomerId();
    	 String theCustomerPhoneold=thecustomersphone.getTheCustomerPhoneold();
    	 String theCustomerPhonenew=thecustomersphone.getTheCustomerPhonenew();
    	CustomersPhone tempcustomerphone = getrowOfCustomerphone(theCustomerId, theCustomerPhoneold);
    	System.out.println(tempcustomerphone );
    	System.out.println(theCustomerPhoneold);
  		 if (tempcustomerphone==null)
  		{
  			coordinates.put("status", 0);
  			coordinates.put( "the customer phone not found ",tempcustomerphone);
  		}
  		else {
  			customersPhoneService.update(tempcustomerphone,theCustomerPhonenew);
  	    	CustomersPhone tempcustomerphone2=getrowOfCustomerphone(theCustomerId, theCustomerPhonenew);
  		    coordinates.put("status", 1);
  		    coordinates.put( "the customer phone edited",tempcustomerphone2);
  		}
  		return coordinates;
  	}
}

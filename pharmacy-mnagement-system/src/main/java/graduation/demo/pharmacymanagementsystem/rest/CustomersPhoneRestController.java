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

import java.util.List;
import graduation.demo.pharmacymanagementsystem.dto.CustomersPhoneDTO;
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

	/////////////////////////////////// get list of customer phones by customer id///////////////////////////
	@GetMapping("/get_customerphones_bycid/{CustomerId}")
	public List <CustomersPhone> getCustomerphone (@PathVariable int CustomerId)
	{


		  List <CustomersPhone> theCustomer_phones = customersPhoneService.findCustomerPhoneByCustomrId (CustomerId);
		  
		  if (theCustomer_phones == null && theCustomer_phones.isEmpty()) {
				throw new RuntimeException("the customer doesn't have phones  " + CustomerId);
			}

		return theCustomer_phones;
	}
	
	/////////////////////////// get Specific CustomerPhone by the customer id and the phone number ////////////////////////
	@GetMapping("/get_rowof_customersphone/{CustomerId}/{phone}")
	public CustomersPhone getrowOfCustomerphone (@PathVariable int CustomerId ,@PathVariable int phone)
	{
		  CustomersPhone theCustomer_phone = customersPhoneService.findSpecificCustomerPhone (CustomerId,phone);
		  
		  if (theCustomer_phone == null  )
			{
			  
			  throw new RuntimeException("the customer phone not found " + phone);
			}
		  else
			  
		return theCustomer_phone;
	}
	
	/////////////////////////////// delete the customer phone //////////////////////////////////
	
	  @DeleteMapping("/delete_phone_by_id/{CustomerId}/{customerPhone}") 
	  public Map<String,Object> deleteCustomerphone(@PathVariable int CustomerId,@PathVariable int customerPhone) 
	  {
	  Map<String, Object> coordinates = new HashMap<>();
	  List <CustomersPhone> theCustomer_phones = customersPhoneService.findCustomerPhoneByCustomrId (CustomerId);
	  
	  CustomersPhone theCustomerPhone = getrowOfCustomerphone (CustomerId,customerPhone);
	  if(theCustomerPhone==null)
	  {
			coordinates.put("states", 0);
			coordinates.put( "the customer phone not found ",customerPhone);
	  }
	  else 
	  {
	  customersPhoneService.deleteById(CustomerId,customerPhone);
	  coordinates.put("states", 1);
	  coordinates.put( "the customer phone deleted ", customerPhone);
	  }	 
	  return coordinates;
			   
	  }


	
    @PutMapping("/phone")
  	public CustomersPhone updatecustomersPhone(@RequestBody CustomersPhoneDTO thecustomersphone) {
    	 int theCustomerId=thecustomersphone.getTheCustomerId();
    	 int theCustomerPhoneold=thecustomersphone.getTheCustomerPhoneold();
    	 int theCustomerPhonenew=thecustomersphone.getTheCustomerPhonenew();
    	CustomersPhone tempcustomerphone =
    			getrowOfCustomerphone(theCustomerId, theCustomerPhoneold);
    	System.out.println(tempcustomerphone);
    	customersPhoneService.update(tempcustomerphone,theCustomerPhonenew);
    	CustomersPhone tempcustomerphone2=getrowOfCustomerphone(theCustomerId, theCustomerPhonenew);
  		return tempcustomerphone2;
  	}
}

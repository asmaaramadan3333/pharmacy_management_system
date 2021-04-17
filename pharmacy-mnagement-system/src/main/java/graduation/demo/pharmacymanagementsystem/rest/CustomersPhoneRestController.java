package graduation.demo.pharmacymanagementsystem.rest;

import java.util.List;

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
				throw new RuntimeException("the customer not found " + CustomerId);
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
	  public String deleteCustomerphone(@PathVariable int CustomerId,@PathVariable int customerPhone) 
	  {
	  
	  List <CustomersPhone> theCustomer_phones = customersPhoneService.findCustomerPhoneByCustomrId (CustomerId);
	  
	  CustomersPhone theCustomer = getrowOfCustomerphone (CustomerId,customerPhone);
		 
	  customersPhoneService.deleteById(CustomerId,customerPhone);
	 
	  return "success";
			   
	  }
	
	  
	  @PostMapping("/add_new_phone") 
	  public int addphoneForCustomer(@RequestBody CustomersPhone theCustomersPhone ) {
	  
	  customersPhoneService.save(theCustomersPhone);
	  
	  return theCustomersPhone.getId().getCustomerId(); 
	  
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

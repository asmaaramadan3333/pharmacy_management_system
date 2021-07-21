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
import graduation.demo.pharmacymanagementsystem.entity.CustomersPrescript;
import graduation.demo.pharmacymanagementsystem.service.CustomersPrescriptsService;

@RestController
@RequestMapping("/customersPrescripts")
public class CustomersPrescriptsRestController {

	private CustomersPrescriptsService CustomersPrescriptsService;
	
	@Autowired
	public CustomersPrescriptsRestController(CustomersPrescriptsService theCustomersPrescriptsService) {
		CustomersPrescriptsService = theCustomersPrescriptsService;
	}
	

	// expose "/CustomersPrescripts" and return list of CustomersPrescripts
	@GetMapping("/get_all")
	public List <CustomersPrescript> findAllCustomersPrescripts() {
		return CustomersPrescriptsService.findAllCustomersPrescripts();
	}

	// add mapping for GET /CustomersPrescripts/{CustomersPrescriptsCode}
	
	@GetMapping("/get_by_prescreption_id/{CustomersPrescriptsId}")
	public Map<String, Object> getCustomersPrescripts(@PathVariable int CustomersPrescriptsId) {
		Map<String, Object> coordinates = new HashMap<>();	
		CustomersPrescript theCustomersPrescript = CustomersPrescriptsService.findById(CustomersPrescriptsId);
		
		if (theCustomersPrescript == null) {
			 coordinates.put("status", 0);
			 coordinates.put("msg", "theCustomersPrescript does not exist");
			 return coordinates;		
			 }
		else
		{
			coordinates.put("status", 1);
			coordinates.put("theCustomersPrescript", theCustomersPrescript);
			 return coordinates;		

		}
	}
	
	@GetMapping("/check_status/{CustomersPrescriptsId}")
	public Map<String, Object> check_status(@PathVariable int CustomersPrescriptsId) {
	    Map<String, Object> coordinates = new HashMap<>();		  

		CustomersPrescript theCustomersPrescript = CustomersPrescriptsService.findById(CustomersPrescriptsId);
		
		if (theCustomersPrescript == null) {
			 coordinates.put("status", 0);
			 coordinates.put("msg", "theCustomersPrescript does not exist");
			 return coordinates;		
			 }
		else
		{
			coordinates.put("status", 1);
			coordinates.put("prescription_status", theCustomersPrescript.getStatus());
			 return coordinates;		

		}
		
	}
	
	
	@GetMapping("/searchbyurl/{CustomersPrescriptsurl}")
	public CustomersPrescript getCustomersPrescriptbyurl(@PathVariable String CustomersPrescriptsurl) {
		
		CustomersPrescript theCustomersPrescript = CustomersPrescriptsService.searchByurl(CustomersPrescriptsurl);
		
		return theCustomersPrescript;
	}
	
	@GetMapping("/get_by_userId/{CustomerId}")
	public  Map<String, Object> getCustomersPrescriptby_userid (@PathVariable int CustomerId)
	{	    Map<String, Object> coordinates = new HashMap<>();		  

		
		return CustomersPrescriptsService.findByCustomerId( CustomerId);
	}
	
	
	// add mapping for POST /CustomersPrescripts - add new CustomersPrescripts
	
	@PostMapping("/add_new")
	public Map<String, Object> addCustomersPrescripts(@RequestBody CustomersPrescript theCustomersPrescripts) {
	    Map<String, Object> coordinates = new HashMap<>();		  
		CustomersPrescript theCustomers_Prescript = CustomersPrescriptsService.searchByurl(theCustomersPrescripts.getUrl());
		
		if(theCustomers_Prescript != null)
		
		{
			 coordinates.put("status", 0);
			 coordinates.put("msg", "the prescription url already exists");
			 return coordinates;
		}				
		else{
			
		    CustomersPrescriptsService.saveORupdate(theCustomersPrescripts);
		    coordinates.put("status", 1);
		    coordinates.put("msg", "success");
		    coordinates.put("prescription_id", theCustomersPrescripts.getId());
		    return coordinates;
		}
	}
	
	
	// add mapping for PUT /CustomersPrescripts - update existing CustomersPrescripts
	
	@PutMapping("/update")
	public CustomersPrescript updateCustomersPrescripts(@RequestBody CustomersPrescript theCustomersPrescripts) {
		
		CustomersPrescriptsService.saveORupdate(theCustomersPrescripts);
		
		return theCustomersPrescripts;
	}
	
	
	// add mapping for DELETE /CustomersPrescripts/{CustomersPrescriptsCode} - delete CustomersPrescripts
	
	@DeleteMapping("/CustomersPrescripts/{CustomersPrescriptsCode}")
	public String deleteCustomersPrescripts(@PathVariable int CustomersPrescriptsCode) {
		
		CustomersPrescript tempCustomersPrescripts = CustomersPrescriptsService.findById(CustomersPrescriptsCode);
		
		// throw exception if null
		
		if (tempCustomersPrescripts == null) {
			throw new RuntimeException("CustomersPrescripts code not found - " + CustomersPrescriptsCode);
		}
		
		CustomersPrescriptsService.deleteByCode(CustomersPrescriptsCode);
		
		return "Deleted CustomersPrescripts id - " + CustomersPrescriptsCode;
	}

	
	
	
}

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
import graduation.demo.pharmacymanagementsystem.entity.Supply;
import graduation.demo.pharmacymanagementsystem.service.SuppliesService;

@RestController
@RequestMapping("/supply")
public class SuppliesRestController {

	private SuppliesService SuppliesService;

	@Autowired
	public SuppliesRestController(SuppliesService theSuppliesService) {
		SuppliesService = theSuppliesService;
	}

	// expose "/get_all" and return list of Supplies
	@GetMapping("/get_all")
	public List<Supply> findAllSupplies() {
		return SuppliesService.findAllSupplies();
	}

	// add mapping for GET /get_all/{supply_bill_id} --return the total price of the supplies bill

	@GetMapping("/get_total_price/{supply_bill_id}/{companyId}")
	public Map<String, Double> findBillTotalPrice(@PathVariable int supply_bill_id,@PathVariable int companyId) {
		Map<String, Double> coordinates = new HashMap<>();
		coordinates.put("Bill_Total_Price ", SuppliesService.findBillTotalPrice ( supply_bill_id,  companyId))  ;
		return coordinates;
	}
	
    @GetMapping("/get_certain_supply/{supply_bill_id}/{companyId}")
    public Map<String,Object> findSpecificSupply(@PathVariable int companyId,@PathVariable int supply_bill_id)
    {
    	Map<String, Object> coordinates = new HashMap<>();
    	 Supply the_supply = SuppliesService.findSpecificSupply(companyId, supply_bill_id);
    	if (the_supply ==null) {
    		coordinates.put("status","0");
    		coordinates.put("message","the supply not found");
    		}
    	else {
    	coordinates.put("status ","1")  ;
    	coordinates.put("theSupply",SuppliesService.findSpecificSupply(companyId, supply_bill_id));}
		return coordinates;
    	
    }
	
	// add mapping for POST /Supplies - add new Supplies
	@PostMapping("/add_new")
	public Supply addSupply(@RequestBody Supply theSupply) {

		SuppliesService.save(theSupply);
		
		return theSupply;
		}
	
	
	// add mapping for PUT /Supplies - update existing Supply
	@PutMapping("/Supplies")
	public Supply updateSupply(@RequestBody Supply theSupply) {

		SuppliesService.saveORupdate(theSupply);

		return theSupply;
	}
	
/*
	// add mapping for GET /Supplies/{supply_bill_id}

	@GetMapping("/Supplies/{supply_bill_id}")
	public Supply getSupply(@PathVariable int supply_bill_id) {

		Supply theSupply = SuppliesService.findBybill_id(supply_bill_id);

		if (theSupply == null) {
			throw new RuntimeException("Employee id not found - " + supply_bill_id);
		}

		return theSupply;
	}

	@GetMapping("/Supplies_search/{SupplyName}")
	public List<Supply> getSupply(@PathVariable String SupplyName) {

		List<Supply> theSupply = SuppliesService.searchByName(SupplyName);

		if (theSupply == null) {
			throw new RuntimeException("Employee id not found - " + SupplyName);
		}

		return theSupply;
	}

	



	// add mapping for DELETE /Supplies/{supply_bill_id} - delete Supply

	@DeleteMapping("/Supplies/{supply_bill_id}")
	public String deleteSupply(@PathVariable int supply_bill_id) {

		Supply tempSupply = SuppliesService.findBybill_id(supply_bill_id);

		// throw exception if null

		if (tempSupply == null) {
			throw new RuntimeException("Supply code not found - " + supply_bill_id);
		}

		SuppliesService.deleteById(supply_bill_id);

		return "Deleted Supply id - " + supply_bill_id;
	}*/

}

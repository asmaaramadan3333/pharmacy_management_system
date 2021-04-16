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
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.service.BillsService;

@RestController
@RequestMapping("/Bill")
public class BillsRestController {

	private BillsService BillsService;
	
	@Autowired
	public BillsRestController(BillsService theBillsService) {
		BillsService = theBillsService;
	}
	

	// expose "/Bills" and return list of Bills
	
	@GetMapping("/Bills")
	public List <Bill> findAllBills() {
		return BillsService.findAllBills();
	}

	// add mapping for GET /Bills/{Bill_id} //// find Bill by id
	
	@GetMapping("/Bills/{Bill_id}")
	public Bill getBill(@PathVariable int Bill_id) {
		
		Bill theBill = BillsService.findByBillID(Bill_id);
		
		if (theBill == null) {
			throw new RuntimeException("Employee id not found - " + Bill_id);
		}
		
		return theBill;
	}
	
	/*@GetMapping("/Bills_search/{BillName}")
	public List<Bill> getBill(@PathVariable String BillName) {
		
		List<Bill> theBill = BillsService.searchByName(BillName);
		
		if (theBill == null) {
			throw new RuntimeException("Employee id not found - " + BillName);
		}
		
		return theBill;
	}*/
	
	
	
	
	// add mapping for POST /Bills - add new Bills
	
	@PostMapping("/Bills")
	public Bill addBill(@RequestBody Bill theBill) {
		
		// also just in case they pass an id in JSON ... set id to 0
		
		// this is to force a save of new item ... instead of update
		
		theBill.setBillId(0);
		
		BillsService.saveORupdate(theBill);
		
		return theBill;
	}
	
	
	// add mapping for PUT /Bills - update existing Bill
	
	@PutMapping("/Bills")
	public Bill updateBill(@RequestBody Bill theBill) {
		
		BillsService.saveORupdate(theBill);
		
		return theBill;
	}
	
	
	// add mapping for DELETE /Bills/{Bill_id} - delete Bill
	
	@DeleteMapping("/Bills/{Bill_id}")
	public String deleteBill(@PathVariable int Bill_id) {
		
		Bill tempBill = BillsService.findByBillID(Bill_id);
		
		// throw exception if null
		
		if (tempBill == null) {
			throw new RuntimeException("Bill code not found - " + Bill_id);
		}
		
		BillsService.deleteByBillID(Bill_id);
		
		return "Deleted Bill id - " + Bill_id;
	}

	
	
	
}

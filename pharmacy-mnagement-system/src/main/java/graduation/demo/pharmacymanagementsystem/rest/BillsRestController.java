
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.dto.SoldProductsQuantityDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.service.BillsService;

@RestController
@RequestMapping("/bill")
public class BillsRestController {

	private BillsService BillsService;

	@Autowired
	public BillsRestController(BillsService theBillsService) {
		BillsService = theBillsService;
	}


//////////////////////////////////////// get all bills //////////////////////////////
	@GetMapping("/get_all")
	public List <Bill> findAllBills() {
		return BillsService.findAllBills();
	}

	///////////////////////////get the bill by bill id ////////////////////////////
	@GetMapping("/get_bill_by_id/{Bill_id}")
	public Map<String, Object> getBillbybillId(@PathVariable int Bill_id) {
		Map<String, Object> coordinates = new HashMap<>();

		Bill theBill = BillsService.findByBillID(Bill_id);

		if (theBill == null) {
			//throw new RuntimeException("bill id not found - " + Bill_id);
			coordinates.put("status", 0);
			coordinates.put("message","the bill id not found" );
			return coordinates;
		    }
		else
			{
			coordinates.put("status", 1 );
			coordinates.put("theBill", theBill);
			return coordinates;
			}

	}


	///////////////////////////////////// get the customer bills by the customer id ///////////////////////////
/*	@GetMapping("/get_customer_Bills_bycid/{CustomerId}")
	public Map<String, Object> getCustomerbills (@PathVariable int CustomerId)
	{

		Map<String, Object> coordinates = new HashMap<>();

		  List<Bill> theCustomer_BillsList = BillsService.findCustomerBillsById (CustomerId);


		  if (theCustomer_BillsList == null || theCustomer_BillsList.isEmpty())
		  {
			  //throw new RuntimeException("the customer not found " + CustomerId);
			coordinates.put("status", 0);
			coordinates.put("message","the Customer does not have any bills" );
			return coordinates;
		  }
		  else {
			  coordinates.put("status", 1);
			  coordinates.put("the_customer_bills",theCustomer_BillsList);
			  return coordinates;
		  }
	}*/

	//////////////////////////////////////get all bills with filtration phases/////////////

	@GetMapping("/filtered_bills")
	@ResponseBody
	public List<Bill> getFilteredBills(@RequestParam(required = false) String billState
			,@RequestParam(required = false) String billType
			,@RequestParam(required = false , name = "billId")Long billId,@RequestParam(required = false) String replyTime)
	    {

		List<Bill> billsList = BillsService.find_filteredBills(billId,billType,billState,replyTime);

		return billsList;

	}



	//////////get product sold in certain period /////////////////////////for Bi/////////////

	@GetMapping("/get_list_sold_product/{replyTime1}/{replyTime2}")

	public List<SoldProductsQuantityDTO> getSold_products_quantity (@PathVariable (required= true) String replyTime1
			, @PathVariable (required= true) String replyTime2)
	{

		return BillsService.find_product_while_aperiod(replyTime1,replyTime2);

	}

	// add mapping for DELETE /Bills/{Bill_id} - delete Bill

	@DeleteMapping("/delete/{Bill_id}")
	public String deleteBill(@PathVariable int Bill_id) {

		Bill tempBill = BillsService.findByBillID(Bill_id);

		// throw exception if null

		if (tempBill == null) {
			throw new RuntimeException("Bill code not found - " + Bill_id);
		}

		BillsService.deleteByBillID(Bill_id);

		return "Deleted Bill id - " + Bill_id;
	}




	// add mapping for POST /Bills - add new Bills

	@PostMapping("/add_new_Bills")
	public Bill addBill(@RequestBody Bill theBill) {
		//CustomersRestController thecustomerRest = new CustomersRestController();

		//Bill thecustomerbill = thecustomerRest.addbillTocustomer(theBill);


		BillsService.saveORupdate(theBill);

		//return BillsService.findByBillID(theBill.getBillId());

		return theBill;

	}


	// add mapping for PUT /Bills - update existing Bill

	@PutMapping("/Bills")
	public Bill updateBill(@RequestBody Bill theBill) {

		BillsService.saveORupdate(theBill);

		return theBill;
	}

}

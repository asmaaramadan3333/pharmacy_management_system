package graduation.demo.pharmacymanagementsystem.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;
import graduation.demo.pharmacymanagementsystem.service.CompanyPaymentsService;

@RestController
@RequestMapping("/companypayment")
public class CompanyPaymentsRestController {

	private CompanyPaymentsService CompanyPaymentsService;
	
	@Autowired
	public CompanyPaymentsRestController(CompanyPaymentsService theCompanyPaymentsService) {
		CompanyPaymentsService = theCompanyPaymentsService;
	}
	

	// expose "/CompanyPayments" and return list of CompanyPayments
	@GetMapping("/get_all_companypayments")
	public List <CompanyPayment> findAllCompanyPayments() {
		return CompanyPaymentsService.findAllCompanyPayments();
	}

	@PostMapping("/add_new_companypayment")
	public CompanyPayment addCompanyPayment(@RequestBody CompanyPayment theCompanyPayment) {
		
		
		CompanyPaymentsService.saveORupdate(theCompanyPayment);
		
		return theCompanyPayment;
	}
	
	@GetMapping("/filtered_company_payments")
	@ResponseBody
	public List<CompanyPayment> getFilteredBills(@RequestParam(required = false) int companyId
			,@RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date start_date
			,@RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date end_date)
	    {

		System.out.println(start_date +"start date");
		List<CompanyPayment> CompanyPaymentsList = CompanyPaymentsService.find_filteredCompanyPayments(companyId,start_date,end_date);

		return CompanyPaymentsList;

	}
	
	// add mapping for GET /CompanyPayments/{CompanyPaymentCode}
	
	/*@GetMapping("/companypayments/{CompanyPaymentCode}")
	public CompanyPayment getCompanyPayment(@PathVariable int CompanyPaymentCode) {
		
		CompanyPayment theCompanyPayment = CompanyPaymentsService.findByCode(CompanyPaymentCode);
		
		if (theCompanyPayment == null) {
			throw new RuntimeException("Employee id not found - " + CompanyPaymentCode);
		}
		
		return theCompanyPayment;
	}*/
	
	/*@GetMapping("/companypayments_search/{CompanyPaymentName}")
	public List<CompanyPayment> getCompanyPayment(@PathVariable String CompanyPaymentName) {
		
		List<CompanyPayment> theCompanyPayment = CompanyPaymentsService.searchByName(CompanyPaymentName);
		
		if (theCompanyPayment == null) {
			throw new RuntimeException("Employee id not found - " + CompanyPaymentName);
		}
		
		return theCompanyPayment;
	}*/
	
	
	
	
	// add mapping for POST /add_companypayments - add new add_companypayments
	
	
	
	
	// add mapping for PUT /update - update existing CompanyPayment
	
/*	@PutMapping("/update")
	public CompanyPayment updateCompanyPayment(@RequestBody CompanyPayment theCompanyPayment) {
		
		CompanyPaymentsService.saveORupdate(theCompanyPayment);
		
		return theCompanyPayment;
	}*/
	
	
	// add mapping for DELETE /companypayments/{CompanyPaymentCode} - delete CompanyPayment
	
	/*@DeleteMapping("/companypayments/{CompanyPaymentCode}")
	public String deleteCompanyPayment(@PathVariable int CompanyPaymentCode) {
		
		CompanyPayment tempCompanyPayment = CompanyPaymentsService.findByCode(CompanyPaymentCode);
		
		// throw exception if null
		
		if (tempCompanyPayment == null) {
			throw new RuntimeException("CompanyPayment code not found - " + CompanyPaymentCode);
		}
		
		CompanyPaymentsService.deleteByCode(CompanyPaymentCode);
		
		return "Deleted CompanyPayment id - " + CompanyPaymentCode;
	}*/

	
	
	
}

package graduation.demo.pharmacymanagementsystem.rest;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.service.PharmaCoService;
@RestController
@RequestMapping("/api")
public class PharmaCoRestController {
	private PharmaCoService pharmacoService;
	@Autowired
	public PharmaCoRestController(PharmaCoService thePharmaCoService) {
		pharmacoService = thePharmaCoService;
	}

	////////////////////////////////////////////return the id of the company by taking the company name/////////////////
	@GetMapping("/return_the__company_Id/{thecompanyname}")
	public Map returnTheId(@PathVariable String thecompanyname)
	{    
		Map <String,Integer> coordinates = new HashMap<>();	
		System.out.println(thecompanyname);
		@SuppressWarnings("deprecation")
		String companyname = URLDecoder.decode(thecompanyname);
		System.out.println(companyname);
		coordinates.put("theID",pharmacoService.returnCompanyId(companyname));
		return coordinates;
		
	}

	/*
	 * @GetMapping(
	 * "/return_the_id/{thecompanyname}/{theproductname}/{theproductsize}/{theproducttype}/{theemployeename}")
	 * public Map returnTheId(@PathVariable String thecompanyname,@PathVariable
	 * String theproductname,@PathVariable int theproductsize,
	 * 
	 * @PathVariable String theproducttype,@PathVariable String theemployeename) {
	 * Map<String, Integer> coordinates = new HashMap<>(); coordinates
	 * =pharmacoService.get_id_employee_company_product(theproductname,
	 * theproducttype, theproductsize, thecompanyname, theemployeename); return
	 * coordinates; }
	 */
	//////////////////////////////////// return object of pharmaci by take the company name//////////////////
	@GetMapping("/return_the_pharmaco/{thecompanyname}")
	public PharmaCo getPharmaCo(@PathVariable String thecompanyname)
	{
        PharmaCo thePharmaCo =pharmacoService.getPharmaCo(thecompanyname);
		
		if (thePharmaCo == null) {
			throw new RuntimeException("company not found - " + thecompanyname);
		}
		
		return thePharmaCo;
	}
	//////////////////////////////////return all the company name////////////////////////////////
	@GetMapping("/return_all_companyname/")
	public List<PharmaCo> findallcomplanyName() 
	{
		return pharmacoService.findallcomplanyName();
	}
}

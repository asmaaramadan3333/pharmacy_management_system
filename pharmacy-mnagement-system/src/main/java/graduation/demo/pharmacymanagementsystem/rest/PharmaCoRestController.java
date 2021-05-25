package graduation.demo.pharmacymanagementsystem.rest;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
import graduation.demo.pharmacymanagementsystem.service.PharmaCoService;

@RestController
@RequestMapping("/pharmaCo")
public class PharmaCoRestController {
	private PharmaCoService pharmacoService;

	@Autowired
	public PharmaCoRestController(PharmaCoService thePharmaCoService) {
		pharmacoService = thePharmaCoService;
	}

	//////////////////////////////////////////// return the id of the company by
	//////////////////////////////////////////// taking the company
	//////////////////////////////////////////// name/////////////////
	////////////////////////// commented until demanded ///////////////////////

	/*
	 * @GetMapping("/get_company_Id/{thecompanyname}") public Map
	 * returnTheId(@PathVariable String thecompanyname) { Map<String, Integer>
	 * coordinates = new HashMap<>(); System.out.println(thecompanyname);
	 * 
	 * @SuppressWarnings("deprecation") String companyname =
	 * URLDecoder.decode(thecompanyname); System.out.println(companyname);
	 * coordinates.put("theID", pharmacoService.returnCompanyId(companyname));
	 * return coordinates; }
	 */

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

	///////////////////////////////// search in pharmaco by company name and return
	///////////////////////////////// list of pharmaco ////////////////// finish

	@GetMapping("/search_by_name/{thecompanyname}")
	public Map<String, Object> searchPharmaCobyname(@PathVariable String thecompanyname) {
		Map<String, Object> coordinates = new HashMap<>();

		List<PharmaCo> PharmaCoList = pharmacoService.searchCompanyByCompanyName(thecompanyname);
		
		if (PharmaCoList.isEmpty()) {
			coordinates.put("status", 0);
			coordinates.put("message", "no campnies found with enterd name");
			return coordinates;
		}

		else {
			coordinates.put("status", 1);
			coordinates.put("message", "successful operation");
			coordinates.put("companies", PharmaCoList);
			return coordinates;
		}
		

		
	}

//////////////////////////////////return all the company name///////////////////////////////
	@GetMapping("/get_all_companies_name")
	public Map<String, Object> findallcomplanyName() {

		Map<String, Object> coordinates = new HashMap<>();

		List<PharmaCo> PharmaCoList = pharmacoService.findallcomplanyName();
		
		if (PharmaCoList.isEmpty()) {
			coordinates.put("status", 0);
			coordinates.put("message", "no campnies found");
			return coordinates;
		}

		else {
			coordinates.put("status", 1);
			coordinates.put("message", "successful operation");
			coordinates.put("all_companies_names", PharmaCoList);
			return coordinates;
		}
		
	}

/////////////////////////////// get list of all the companies //////////////////// 
	@GetMapping("/get_all_companies")
	public Map<String, Object> findAllPharmaCo() {
		Map<String, Object> coordinates = new HashMap<>();

		List<PharmaCo> PharmaCoList = pharmacoService.findAllPharmaCo();

		if (PharmaCoList.isEmpty()) {
			coordinates.put("status", 0);
			coordinates.put("message", "no campnies found");
			return coordinates;
		}

		else {
			coordinates.put("status", 1);
			coordinates.put("message", "successful operation");
			coordinates.put("companies", PharmaCoList);
			return coordinates;
		}
	}

	//////////////////////////////////////// post///////////////////////////////
	@RequestMapping(method = RequestMethod.POST, value = "/add_new_pharmaco")
	public Map<String, Object> addPharmaco(@RequestBody PharmaCo new_PharmaCo) {

		Map<String, Object> coordinates = new HashMap<>();

		coordinates.put("status", 1);
		coordinates.put("message", "successful operation");

		pharmacoService.save(new_PharmaCo);
		coordinates.put("PharmaCo", new_PharmaCo);

		return coordinates;
	}

}

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
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProductPK;
import graduation.demo.pharmacymanagementsystem.service.PrescriptsProductsService;

@RestController
@RequestMapping("/PrescriptsProduct")
public class PrescriptsProductsRestController {

	private PrescriptsProductsService PrescriptsProductsService;
	
	@Autowired
	public PrescriptsProductsRestController(PrescriptsProductsService thePrescriptsProductsService) {
		PrescriptsProductsService = thePrescriptsProductsService;
	}
	

	// expose "/PrescriptsProducts" and return list of PrescriptsProducts
	@GetMapping("/get_all")
	public List <PrescriptsProduct> findAllPrescriptsProducts() {
		return PrescriptsProductsService.findAllPrescriptsProducts();
	}

	// add mapping for GET /PrescriptsProducts/{PrescriptsProductCode}
	
	@GetMapping("/PrescriptsProducts/{PrescriptsProductId}")
	public PrescriptsProduct getPrescriptsProduct(@PathVariable PrescriptsProductPK PrescriptsProductId) {
		
		PrescriptsProduct thePrescriptsProduct = PrescriptsProductsService.findById(PrescriptsProductId);
		
		if (thePrescriptsProduct == null) {
			throw new RuntimeException("PrescriptsProduct id not found - " + PrescriptsProductId);
		}
		
		return thePrescriptsProduct;
	}
	

	
	
	
	// add mapping for POST /PrescriptsProducts - add new PrescriptsProducts
  	
	@PostMapping("/add_new_List")
	public Map<String, Object> addPrescriptsProduct(@RequestBody List<PrescriptsProduct> thePrescriptsProductsList) {
		
	    Map<String, Object> coordinates = new HashMap<>();		  

		
	    coordinates = PrescriptsProductsService.saveORupdate(thePrescriptsProductsList);
		
		return coordinates;
	}
	
	
	// add mapping for PUT /PrescriptsProducts - update existing PrescriptsProduct
/*	
	@PutMapping("/PrescriptsProducts")
	public PrescriptsProduct updatePrescriptsProduct(@RequestBody PrescriptsProduct thePrescriptsProduct) {
		
		PrescriptsProductsService.saveORupdate(thePrescriptsProduct);
		
		return thePrescriptsProduct;
	}
	*/
	
	// add mapping for DELETE /PrescriptsProducts/{PrescriptsProductCode} - delete PrescriptsProduct
/*	
	@DeleteMapping("/PrescriptsProducts/{PrescriptsProductCode}")
	public String deletePrescriptsProduct(@PathVariable int PrescriptsProductCode) {
		
		PrescriptsProduct tempPrescriptsProduct = PrescriptsProductsService.findByCode(PrescriptsProductCode);
		
		// throw exception if null
		
		if (tempPrescriptsProduct == null) {
			throw new RuntimeException("PrescriptsProduct code not found - " + PrescriptsProductCode);
		}
		
		PrescriptsProductsService.deleteByCode(PrescriptsProductCode);
		
		return "Deleted PrescriptsProduct id - " + PrescriptsProductCode;
	}

	*/
	
	
}

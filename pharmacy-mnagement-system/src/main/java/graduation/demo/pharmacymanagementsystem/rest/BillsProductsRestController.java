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
import org.springframework.web.bind.annotation.ResponseBody;
import graduation.demo.pharmacymanagementsystem.dto.BillsProductDTO;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.service.BillsProductsService;

@RestController
@RequestMapping("/BillsProduct")
public class BillsProductsRestController {

	private BillsProductsService BillsProductsService;
	
	@Autowired
	public BillsProductsRestController(BillsProductsService theBillsProductsService) {
		BillsProductsService = theBillsProductsService;
	}
	

	// expose "/BillsProducts" and return list of BillsProducts
	@GetMapping("/get_all_BillsProducts")
	public List <BillsProduct> findAllBillsProducts() {
		return BillsProductsService.findAllBillsProducts();
	}
	// add mapping for GET /BillsProducts/{BillsProduct_id} //// find BillsProduct by id
	
	@GetMapping("/find_BillsProducts/{Bill_id}")
	public List<BillsProductDTO> getBillsProduct(@PathVariable long Bill_id) {
		
		List<BillsProductDTO> theBillsProducts = BillsProductsService.find_BillsProductby_Bill_ID(Bill_id);
		
		 if (theBillsProducts == null && theBillsProducts.isEmpty()) {
				throw new RuntimeException("the Billproducts not found " + Bill_id);
			}

		return theBillsProducts;
	}
		
	
	@PostMapping("/BillsProductsList")
	public   Map<String, Object>  getListOfProduts(@RequestBody List<BillsProduct> theBillsProductsList) {

		  Map<String, Object> coordinates = new HashMap<>();		  

		  coordinates= BillsProductsService.saveORupdate(theBillsProductsList);

	  return coordinates;
	}
	
	/*@GetMapping("/BillsProducts_search/{BillsProductName}")
	public List<BillsProduct> getBillsProduct(@PathVariable String BillsProductName) {
		
		List<BillsProduct> theBillsProduct = BillsProductsService.searchByName(BillsProductName);
		
		if (theBillsProduct == null) {
			throw new RuntimeException("Employee id not found - " + BillsProductName);
		}
		
		return theBillsProduct;
	}*/
	
	
	
	
	
	// add mapping for PUT /BillsProducts - update existing BillsProduct
	/*
	@PutMapping("/BillsProducts")
	public BillsProduct updateBillsProduct(@RequestBody BillsProduct theBillsProduct) {
		
		BillsProductsService.saveORupdate(theBillsProduct);
		
		return theBillsProduct;
	}
	
	
	// add mapping for DELETE /BillsProducts/{BillsProduct_id} - delete BillsProduct
/*	
	@DeleteMapping("/BillsProducts/{BillsProduct_id}")
	public String deleteBillsProduct(@PathVariable int BillsProduct_id) {
		
		BillsProduct tempBillsProduct = BillsProductsService.findByBillsProductID(BillsProduct_id);
		
		// throw exception if null
		
		if (tempBillsProduct == null) {
			throw new RuntimeException("BillsProduct code not found - " + BillsProduct_id);
		}
		
		BillsProductsService.deleteByBillsProductID(BillsProduct_id);
		
		return "Deleted BillsProduct id - " + BillsProduct_id;
	}
*/
	
	
	
}

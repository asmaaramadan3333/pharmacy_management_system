package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

	private ProductsService productsService;

	@Autowired
	public ProductsRestController(ProductsService theProductsService) {
		productsService = theProductsService;
	}

	// expose "/products" and return list of products
	
	@GetMapping("/get_all")
	public List<Product> findAllProducts() {
		return productsService.findAllProducts();
	}

	@GetMapping("/get_all_state_0")
	public List<Product> findAllProductswithstate0() {
		return productsService.findProductsWithState0();
	}
	// add mapping for GET /products/{productCode} - to get product by code

	@GetMapping("/products_by_code/{productCode}")
	public Product getProduct(@PathVariable int productCode) {

		Product theProduct = productsService.findByCode(productCode);

		if (theProduct == null) {
			throw new RuntimeException("Employee id not found - " + productCode);
		}

		return theProduct;
	}

	
	// add mapping for GET /products/{productName} - to get product by name

	@GetMapping("/products_name_search/{productName}")
	
	public List<Product> getProduct(@PathVariable String productName) {

		List<Product> theProduct = productsService.searchByName(productName);

		if (theProduct == null) {
			throw new RuntimeException("product not found " + productName);
		}

		return theProduct;
	}

	// add mapping for GET /products/{productName} - to get product by the two categories

	@GetMapping("/products_category_search/{main_category}/{secondary_category}")
	public List<Product> getProduct(@PathVariable String main_category, @PathVariable String secondary_category) {
		List<Product> theProducts = productsService.select_by_category(main_category, secondary_category);

		if (theProducts == null) {
			throw new RuntimeException(" empty category ");
		}

		return theProducts;
	}

	///////////////// optional will be added////////////////
	@GetMapping("/return_the_product_code/{theproductname}/{theproducttype}/{theproductsize}")
	public Map returnThe_Id_by_name(@PathVariable String theproductname, @PathVariable String theproducttype,
			@PathVariable int theproductsize) {
		Map<String, Integer> coordinates = new HashMap<>();
		coordinates.put("theID", productsService.returnproductcode(theproductname, theproducttype, theproductsize));
		return coordinates;

	}

	// add mapping for POST /products - add new products

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product theProduct) {

		// also just in case they pass an id in JSON ... set id to 0

		// this is to force a save of new item ... instead of update

		theProduct.setCode(0);

		productsService.saveORupdate(theProduct);

		return theProduct;
	}

	// add mapping for PUT /products - update existing product

	@PutMapping("/editproducts")
	public Product updateProduct(@RequestBody Product theProduct) {

		productsService.saveORupdate(theProduct);

		return theProduct;
	}

	// add mapping for DELETE /products/{productCode} - delete product

	@DeleteMapping("/deleteProduct/{productCode}")
	public Map<String,Object> deleteProduct(@PathVariable int productCode) {
		
	
		Map<String, Object> coordinates = new HashMap<>();
		Product tempProduct = productsService.findByCode(productCode);

		// throw exception if null

		if (tempProduct == null) {
    		coordinates.put("status","0");
    		coordinates.put("product code not found ",productCode);
		}
		else {
		productsService.deleteByCode(productCode);
		coordinates.put("status","1");
		coordinates.put("product code deleted ",productCode);}
		return coordinates;
	}

	/*
	 * // add mapping for POST /products - add new products
	 * 
	 * @PostMapping(value="/api/allservices") public Object
	 * addnewservice(@RequestBody Map<String, Object> datamap) { //Map<String,
	 * Object> servicesMap=new HashMap<String, Object>(); Object
	 * esbcoreRule=datamap.get("rules"); Object
	 * esbcoreService=datamap.get("services"); productsService.save(esbcoreRule);
	 * //serviceRepo.save(esbcoreService); return datamap; }
	 */
}

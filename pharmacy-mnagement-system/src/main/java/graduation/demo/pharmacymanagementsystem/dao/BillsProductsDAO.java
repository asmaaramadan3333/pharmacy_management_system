package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.BillsProductPK;
import graduation.demo.pharmacymanagementsystem.entity.Product;

public interface BillsProductsDAO {

	public List <BillsProduct> findAllBillsProducts();
	
	
	public List<BillsProduct> saveORupdate (List<BillsProduct> theBillsProduct);
	
	public void deleteByBillsProductID (int theCode);

	public List<BillsProduct> find_BillsProductby_Bill_ID(long bill_id);


	public Product findProductByCode(int theCode);


	public BillsProduct getbill_by_pkid(BillsProductPK id);


	public List<Map<String, Object>> get_best_summer_sells();


	public List<Map<String, Object>> get_best_winter_sells();


	//public void editSupplyQuantity(BillsProduct the_saved_list);

	//public List<BillsProduct> searchByName(String theName);
	
	
}

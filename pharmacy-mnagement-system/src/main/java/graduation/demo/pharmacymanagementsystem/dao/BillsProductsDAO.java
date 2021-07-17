package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.BillsProductPK;
import graduation.demo.pharmacymanagementsystem.entity.Product;

public interface BillsProductsDAO {

	public List <BillsProduct> findAllBillsProducts();
	
	
	public void saveORupdate (List<BillsProduct> theBillsProduct);
	
	public void deleteByBillsProductID (int theCode);

	public List<BillsProduct> find_BillsProductby_Bill_ID(long bill_id);


	public Product findProductByCode(int theCode);


	public BillsProduct getbill_by_pkid(BillsProductPK id);

	//public List<BillsProduct> searchByName(String theName);
	
	
}

package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;

public interface BillsProductsDAO {

	public List <BillsProduct> findAllBillsProducts();
	
	public BillsProduct findByBillsProductID (int theBillsProduct_id);
	
	public void saveORupdate (BillsProduct theBillsProduct);
	
	public void deleteByBillsProductID (int theCode);

	//public List<BillsProduct> searchByName(String theName);
	
	
}

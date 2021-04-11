package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;

public interface BillsProductsService {

    public List <BillsProduct> findAllBillsProducts();
	
	public BillsProduct findByBillsProductID (int theBillsProduct_id);
	
	public void saveORupdate (BillsProduct theBillsProduct);
	
	public void deleteByBillsProductID (int theBillsProduct_id);
	
	//public List<BillsProduct> searchByName(String theName);
	
}

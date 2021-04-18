package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.dto.BillsProductDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;

public interface BillsProductsService {

	public List<BillsProductDTO> find_BillsProductby_Bill_ID(long bill_id);
	public void saveORupdate (List<BillsProduct> theBillsProducts);
	public List<BillsProduct> findAllBillsProducts();
	
}

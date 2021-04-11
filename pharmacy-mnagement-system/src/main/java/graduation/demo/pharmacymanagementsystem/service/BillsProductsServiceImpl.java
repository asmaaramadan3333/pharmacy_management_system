package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.BillsProductsDAO;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;

@Service
public class BillsProductsServiceImpl implements BillsProductsService {

    private BillsProductsDAO BillsProductsDAO ;
	
    @Autowired
	public BillsProductsServiceImpl(BillsProductsDAO theBillsDAO) {
    	BillsProductsDAO theBillsProductsDAO;
	}
	
	@Override
	@Transactional
	public List<BillsProduct> findAllBillsProducts() {
		
		return BillsProductsDAO.findAllBillsProducts();
	}

	@Override
	@Transactional
	public BillsProduct findByBillsProductID(int theBillsProduct_id) {
		
		return BillsProductsDAO.findByBillsProductID(theBillsProduct_id);
	}

	@Override
	@Transactional
	public void saveORupdate(BillsProduct theBillsProduct) {
		
		BillsProductsDAO.saveORupdate(theBillsProduct);
	}

	@Override
	@Transactional
	public void deleteByBillsProductID(int theBillsProduct_id) {
		
		BillsProductsDAO.deleteByBillsProductID(theBillsProduct_id);
		
	}

	/*@Override
	public List<BillsProduct> searchByName(String theName) {
		
		return BillsProductsDAO.searchByName(theName);
	}*/

}

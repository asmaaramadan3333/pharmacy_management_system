package graduation.demo.pharmacymanagementsystem.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.BillsDAO;
import graduation.demo.pharmacymanagementsystem.dto.SoldProductsQuantityDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Service
public class BillsServiceImpl implements BillsService {

	private BillsDAO BillsDAO;

	@Autowired
	public BillsServiceImpl(BillsDAO theBillsDAO) {
		BillsDAO = theBillsDAO;
	}

	@Autowired
	private ProductsService productsService;

	@Override
	@Transactional
	public List<Bill> findAllBills() {

		return BillsDAO.findAllBills();
	}

	@Override
	@Transactional
	public Bill findByBillID(long thebill_id) {

		return BillsDAO.findByBillID(thebill_id);

	}

	@Override
	@Transactional
	public void saveORupdate(Bill theBill) {

		BillsDAO.saveORupdate(theBill);
	}

	@Override
	@Transactional
	public void save(Bill theBill) {

		BillsDAO.save(theBill);

		// Bill thebill=theBill.getBillId();

	}

	@Override
	@Transactional
	public void deleteByBillID(int thebill_id) {

		BillsDAO.deleteByBillID(thebill_id);

	}

	@Override
	public List<Bill> findCustomerBillsById(int theCustomerId) {
		return BillsDAO.findCustomerBillsById(theCustomerId);
	}
	
	
	@Override
	public List<SoldProductsQuantityDTO> find_product_while_aperiod(String replyTime1, String replyTime2) {
		// TODO Auto-generated method stub

		replyTime1 = replyTime1.concat("00:00:00");
		replyTime2 = replyTime2.concat("00:00:00");

		Timestamp timestamp1 = Timestamp.valueOf(replyTime1);
		Timestamp timestamp2 = Timestamp.valueOf(replyTime2);

		List<Bill> Bill_list = BillsDAO.find_product_while_aperiod(timestamp1, timestamp2);
		
		Map<String, Integer> coordinatesMap = new HashMap<>();

		// System.out.println(Bill_list.size());

		List<SoldProductsQuantityDTO> soldProductsList = new ArrayList<SoldProductsQuantityDTO>();

        coordinatesMap = getMapOfSoldProducts(Bill_list);
        
			for (Map.Entry<String,Integer> entry : coordinatesMap.entrySet()) {
				
				SoldProductsQuantityDTO soldProducts = new SoldProductsQuantityDTO();
				soldProducts.setProductName(entry.getKey());
				soldProducts.setQuantity(entry.getValue());
				soldProductsList.add(soldProducts);
			}
		return soldProductsList;
		
		
		

	}

	/*
	 * @Override public List<Bill> searchByName(String theName) {
	 * 
	 * return BillsDAO.searchByName(theName); }
	 */
     private Map<String, Integer> getMapOfSoldProducts(List<Bill>Bill_list ){
		
    	 Map<String, Integer> coordinatesMap = new HashMap<>();
    	 if (!Bill_list.isEmpty()) {

 			for (int i = 0; i < Bill_list.size(); i++) {

 				List<BillsProduct> billsProductList = Bill_list.get(i).getBillsProducts();
 				if (!billsProductList.isEmpty()) {
 					
 					for (int j = 0; j < billsProductList.size(); j++) {
 						int product_code = billsProductList.get(j).getId().getProductCode();
 						//System.out.println(productsService.findByCode(product_code).getName());
 						//System.out.println(Bill_list.get(i).getBillsProducts().get(j).getQuantity());
                         if (!coordinatesMap.isEmpty())
                         {
                         	if(coordinatesMap.get(productsService.findByCode(product_code).getName()) != null)
                         	{
                         	  coordinatesMap.put(productsService.findByCode(product_code).getName()
                         		, (coordinatesMap.get(productsService.findByCode(product_code).getName()))+billsProductList.get(j).getQuantity());
                         	}
                         	
                         	else {
                         		coordinatesMap.put(productsService.findByCode(product_code).getName() , billsProductList.get(j).getQuantity());
                         	}
                         }	
                         	
                         else {	
                         	coordinatesMap.put(productsService.findByCode(product_code).getName(), billsProductList.get(j).getQuantity());
                         }
                         
 					}
 				} else
 					continue;
 			}
             
 			
 			return coordinatesMap;
 			
 		}

 		else {
 			//throw new RuntimeException("no products sold in this period");

 			 return null;
 		}
    	 
    	 
    	
     } 
	
}

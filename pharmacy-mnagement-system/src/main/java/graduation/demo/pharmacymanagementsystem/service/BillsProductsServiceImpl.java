package graduation.demo.pharmacymanagementsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.dao.BillsProductsDAO;
import graduation.demo.pharmacymanagementsystem.dto.BillsProductDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.BillsProductPK;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Service
public class BillsProductsServiceImpl implements BillsProductsService {

	@Autowired
	private BillsProductsDAO BillsProductsDAO;
	@Autowired
	private ProductsService ProductsService;
	
	@Autowired
	private SupplyProductsService SupplyProductsService;
	
	@Autowired
	public BillsProductsServiceImpl(BillsProductsDAO theBillsProductsDAO) {
		BillsProductsDAO = theBillsProductsDAO;
	}

	@Override
	public List<BillsProductDTO> find_BillsProductby_Bill_ID(long bill_id) {
		
		//Map<String, Object> coordinates = new HashMap<>();
        
		List<BillsProduct> theBillsProducts = BillsProductsDAO.find_BillsProductby_Bill_ID(bill_id);
		
		List<BillsProductDTO> theBillsProductsdtoList = new ArrayList() ;

		//List<String> names ;
		 
		//List<Product> the_products = new ArrayList() ;
		//List<List<Integer>> String = new ArrayList<List<Integer>>();

		//ProductsService theProductsService = new ProductsService() ;
		BillsProductDTO theBillsProductsdto = null;
		for(int i = 0 ; i<theBillsProducts.size();i++)
		{
			//codes.set(i,theBillsProducts.get(i).getId().getProductCode());
		    int code = theBillsProducts.get(i).getId().getProductCode();
		    System.out.println(code);
		     theBillsProductsdto = new BillsProductDTO() ;
		    //theBillsProductsdto.setbillIdparam(theBillsProducts.get(i).getId().getBillId());
		    System.out.println(theBillsProducts.get(i).getId().getBillId());

		    theBillsProductsdto.setBillId((theBillsProducts.get(i).getId().getBillId()));
		    theBillsProductsdto.setQuantity(theBillsProducts.get(i).getQuantity());
		    theBillsProductsdto.setTotalPrice(theBillsProducts.get(i).getTotalPrice());
		    theBillsProductsdto.setUnitPrice(theBillsProducts.get(i).getUnitPrice());
		    theBillsProductsdto.setName(BillsProductsDAO.findProductByCode(code).getName());
		    
		    System.out.println(theBillsProductsdto);

		    theBillsProductsdtoList.add(theBillsProductsdto);
		    
		   // the_products.set(i, theProductsService.findByCode(code)); 
		    
			//names.set(i, the_products.get(i).getName());
			
			//coordinates.put("", names.get(i));
		}

		//coordinates.put("", value);
		
		
		return theBillsProductsdtoList;
	}
       
	@Override
	
	public BillsProduct getbill_by_pkid(BillsProductPK id) {
		
		return BillsProductsDAO.getbill_by_pkid(id);
		
	}
	
	
	
	
	@Override
	//@Transactional
	public Map<String, Object> saveORupdate(List<BillsProduct>  theBillsProduct) {
		  Map<String, Object> coordinates = new HashMap<>();		  
		for(int i=0;i< theBillsProduct.size();i++)
		  {
			  BillsProduct theBillsProduct2= getbill_by_pkid(theBillsProduct.get(i).getId());
			  if (theBillsProduct2 != null) {
			  coordinates.put("msg", "the Billproduct id already exist");
			  coordinates.put("status", 0);
			  coordinates.put("id",theBillsProduct.get(i).getId());
			  return coordinates;
			  }			  
		  }
		
		List<BillsProduct> the_saved_list = BillsProductsDAO.saveORupdate(theBillsProduct);
        
		
			SupplyProductsService.editSupplyQuantity(the_saved_list);
		
			
		
		  
 		  coordinates.put("msg","success");
		  coordinates.put("status",1);
		  coordinates.put("saved",the_saved_list);
		  return coordinates;

	}


	@Override
	public List<BillsProduct> findAllBillsProducts() {
		// TODO Auto-generated method stub
		return BillsProductsDAO.findAllBillsProducts();
	}

}

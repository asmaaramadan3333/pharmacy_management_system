package graduation.demo.pharmacymanagementsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.dao.BillsProductsDAO;
import graduation.demo.pharmacymanagementsystem.dto.BillsProductDTO;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Service
public class BillsProductsServiceImpl implements BillsProductsService {

	private BillsProductsDAO BillsProductsDAO;
	
	private ProductsService theProductsService;
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

}

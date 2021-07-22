package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.dao.SupplyProductsDAO;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Service

public class SupplyProductsServiceImpl implements SupplyProductsService {
	@Autowired
	private SupplyProductsDAO SupplyProductsDAO;

	@Autowired
	private ProductsService  ProductsService;
	
	@Autowired
	public SupplyProductsServiceImpl(SupplyProductsDAO theSupplyProductsDAO) {
		SupplyProductsDAO = theSupplyProductsDAO;
	}

	@Override
	@Transactional
	public void editSupplyQuantity(List<BillsProduct> the_saved_list) {
	//	System.out.println(the_saved_list.get(0));
		float newquantity;
		
		for(int i=0;i<the_saved_list.size();i++)
		{
			Product theProduct=ProductsService.findByCode(the_saved_list.get(i).getId().getProductCode());
			System.out.println(theProduct.getPosition());
			if (theProduct.getPosition().equals("TABLETS")||theProduct.getPosition().equals("tablets"))
					
			{
				
				int no_of_tablets = theProduct.getPackages();
				newquantity = (float)(the_saved_list.get(i).getQuantity())/no_of_tablets; 
				System.out.println("tablets"  );
				System.out.println(newquantity);
			}
			else 
			{
				newquantity=(float)(the_saved_list.get(i).getQuantity());
				//System.out.println(newquantity);
			}
			
			SupplyProductsDAO.editSupplyQuantity(the_saved_list.get(i),newquantity);
		
		
		}
	}

}

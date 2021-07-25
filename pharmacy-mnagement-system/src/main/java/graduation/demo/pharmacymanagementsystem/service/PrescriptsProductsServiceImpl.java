package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.PrescriptsProductsDAO;
import graduation.demo.pharmacymanagementsystem.dao.CustomersPrescriptsDAO;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProductPK;

@Service
public class PrescriptsProductsServiceImpl implements PrescriptsProductsService {

    private PrescriptsProductsDAO PrescriptsProductsDAO ;
	
    @Autowired
	private CustomersPrescriptsDAO CustomersPrescriptsDAO;
    
    @Autowired
	public PrescriptsProductsServiceImpl(PrescriptsProductsDAO thePrescriptsProductsDAO) {
    	PrescriptsProductsDAO = thePrescriptsProductsDAO;
	}
	
	@Override
	@Transactional
	public List<PrescriptsProduct> findAllPrescriptsProducts() {
		
		return PrescriptsProductsDAO.findAllPrescriptsProducts();
	}

	@Override
	@Transactional
	public PrescriptsProduct findById(PrescriptsProductPK theId) {
		
		return PrescriptsProductsDAO.findById(theId);
	}

	@Override
	//@Transactional
	public Map<String, Object> saveORupdate(List<PrescriptsProduct> thePrescriptsProduct) {
		  Map<String, Object> coordinates = new HashMap<>();		  
			for(int i=0;i< thePrescriptsProduct.size();i++)
			  {
				PrescriptsProduct thePrescriptsProduct2 = findById(thePrescriptsProduct.get(i).getId());
				  if (thePrescriptsProduct2 != null) {
				  coordinates.put("msg", "the Prescriptsproduct id already exist");
				  coordinates.put("status", 0);
				  coordinates.put("id",thePrescriptsProduct.get(i).getId());
				  return coordinates;
				  }	
			  }
			
		
			 List<PrescriptsProduct> the_saved_list =PrescriptsProductsDAO.saveORupdate(thePrescriptsProduct);
			 
			 int prescript_id = the_saved_list.get(0).getId().getPrescriptId();
			 
			 CustomersPrescriptsDAO.update_status( prescript_id);
			 
			 
			 coordinates.put("msg","success");
			  coordinates.put("status",1);
			  return coordinates;
	}

	@Override
	@Transactional
	public void deleteByCode(int theCode) {
		
		PrescriptsProductsDAO.deleteByCode(theCode);
		
	}

	@Override
	public List<PrescriptsProduct> searchByName(String theName) {
		
		return PrescriptsProductsDAO.searchByName(theName);
	}

}

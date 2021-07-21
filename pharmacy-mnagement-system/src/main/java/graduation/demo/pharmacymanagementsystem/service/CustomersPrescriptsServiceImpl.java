package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.CustomersPrescriptsDAO;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPrescript;

@Service
public class CustomersPrescriptsServiceImpl implements CustomersPrescriptsService {

    private CustomersPrescriptsDAO CustomersPrescriptsDAO ;
	
    @Autowired
	public CustomersPrescriptsServiceImpl(CustomersPrescriptsDAO theCustomersPrescriptsDAO) {
    	CustomersPrescriptsDAO = theCustomersPrescriptsDAO;
	}
	
	@Override
	@Transactional
	public List<CustomersPrescript> findAllCustomersPrescripts() {
		
		return CustomersPrescriptsDAO.findAllCustomersPrescripts();
	}

	@Override
	@Transactional
	public CustomersPrescript findById(int theId) {
		
		return CustomersPrescriptsDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveORupdate(CustomersPrescript theCustomersPrescript) {
		
		CustomersPrescriptsDAO.saveORupdate(theCustomersPrescript);
	}

	@Override
	@Transactional
	public void deleteByCode(int theCode) {
		
		CustomersPrescriptsDAO.deleteByCode(theCode);
		
	}

	@Override
	public CustomersPrescript searchByurl(String theurl) {
		
		return CustomersPrescriptsDAO.searchByurl(theurl);
	}

	@Override
	public Map<String,Object> findByCustomerId(int customerId) {
	    Map<String, Object> coordinates = new HashMap<>();		  

	    List <CustomersPrescript> the_result_list = CustomersPrescriptsDAO.findByCustomerId(customerId);
	    
	    if(the_result_list != null)
	    {
	    	coordinates.put("status" ,1);
	    	coordinates.put("the result",the_result_list );
	    	return coordinates;
	    }
	    else
	    {
	    	coordinates.put("status", 0);
	    	coordinates.put("msg", "the customer does not have prescriptions");
	    	return coordinates;
	    }
		
	}

}

package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.CustomersDAO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;

@Service
public class CustomersServiceImpl implements CustomersService {

    private CustomersDAO CustomersDAO ;
	
    @Autowired
	public CustomersServiceImpl(CustomersDAO theCustomersDAO) {
    	CustomersDAO = theCustomersDAO;
	}
	
	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		
		return CustomersDAO.findAllCustomers();
	}

	@Override
	@Transactional
	public Customer findByCode(int theCode) {
		
		return CustomersDAO.findByCode(theCode);
	}

	@Override
	@Transactional
	public void saveORupdate(Customer theCustomer) {
		
		CustomersDAO.saveORupdate(theCustomer);
	}

	@Override
	@Transactional
	public void deleteByCode(int theCode) {
		
		CustomersDAO.deleteByCode(theCode);
		
	}

	@Override
	public List<Customer> searchByName(String theName) {
		
		return CustomersDAO.searchByName(theName);
	}

	@Override
	public Customer getCustomerByEmail(String theemail) {
		return CustomersDAO.getCustomerByEmail(theemail) ;
	}
	
	
	
	@Override
	public Map<String, Boolean> customerSignIn (String theemail , String thepassword) {
	
		Map <String,Boolean> coordinates= new HashMap<> ();
		
		Customer thecustomer = CustomersDAO.getCustomerByEmail(theemail);
		
		if (thecustomer != null) {
			
			coordinates.put("having_an_account", true);
			
			Customer theExistingCustomer = CustomersDAO.signIn(theemail, thepassword);
			
		if(theExistingCustomer!=null)	{
			
			coordinates.put("success", true);
			coordinates.put("correct_password", true);
		}
		else
		{
			coordinates.put("success", false);
			coordinates.put("correct_password", false);
			
		}
			
		return coordinates;
		
		}
		
		else
			
		{
			coordinates.put("success", false);
			coordinates.put("having_an_account", false);
			coordinates.put("correct_password", false);
		
			return coordinates;	
		
		}
		
		
		
	}

	
	
	
	
	
	
}

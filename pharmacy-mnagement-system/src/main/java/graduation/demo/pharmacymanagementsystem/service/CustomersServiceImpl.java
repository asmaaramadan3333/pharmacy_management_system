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

	private CustomersDAO CustomersDAO;

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
	public Customer findByCode(int theCustomerId) {

		return CustomersDAO.findByCode(theCustomerId);
	}

	@Override
	@Transactional
	public void saveORupdate(Customer theCustomer) {

		CustomersDAO.saveORupdate(theCustomer);
	}

	@Override
	@Transactional
	public void deleteByCode(int theCustomerId) {

		CustomersDAO.deleteByCode(theCustomerId);

	}

	@Override
	@Transactional

	public List<Customer> searchByName(String theCustomerName) {

		return CustomersDAO.searchByName(theCustomerName);
	}

	@Override
	@Transactional

	public Customer getCustomerByEmail(String theemail) {
		return CustomersDAO.getCustomerByEmail(theemail);
	}

	@Override
	@Transactional

	public Map<String, Boolean> customerSignIn(String theemail, String thepassword) {

		Map<String, Boolean> coordinates = new HashMap<>();

		Customer thecustomer = CustomersDAO.getCustomerByEmail(theemail);

		if (thecustomer != null) {

			coordinates.put("having_an_account", true);

			Customer theExistingCustomer = CustomersDAO.signIn(theemail, thepassword);

			if (theExistingCustomer != null) {

				coordinates.put("success", true);
				coordinates.put("correct_password", true);
			}

			else {
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

	@Override
	
	@Transactional
	public Map signUp(Customer theCustomer) {

		Map<String, Integer> coordinates = new HashMap<>();

		Customer thecustomer1 = getCustomerByEmail(theCustomer.getEmail());

		if (thecustomer1 != null) {
			coordinates.put("success", 0);

			coordinates.put("already_has_an_account", 1);

			coordinates.put("user_id", theCustomer.getCustomerId());

		} 
		else {
			
			coordinates.put("success", 1);

			coordinates.put("already_has_an_account", 0);
			theCustomer.setCustomerId(0);
			
			saveORupdate(theCustomer);
			
			coordinates.put("user_id", theCustomer.getCustomerId());

		}

		return coordinates;
	}

	@Override
	@Transactional
	public void add_products_to_customer(int theCustomerId, int theproductCode) {
            CustomersDAO.add_products_to_customer(theCustomerId, theproductCode);		
	}

}

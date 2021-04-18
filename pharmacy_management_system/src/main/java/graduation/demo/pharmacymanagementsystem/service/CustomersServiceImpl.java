package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.CustomersDAO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

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

    ////////////////////////////customer_sign_in/////////////////////////////////////////

	@Override
	@Transactional
	public Map<String, Object> customerSignIn(String theemail, String thepassword) {

		Map<String, Object> coordinates = new HashMap<>();

		Customer thecustomer = CustomersDAO.getCustomerByEmail(theemail);

		if (thecustomer != null) {

			coordinates.put("having_an_account", 1);

			Customer theExistingCustomer = CustomersDAO.signIn(theemail, thepassword);

			if (theExistingCustomer != null) {

				coordinates.put("status", 1);
				coordinates.put("correct_password", 1);
				coordinates.put("the_customer", thecustomer);
			}

			else {
				coordinates.put("status", 0);
				coordinates.put("correct_password", 0);
				coordinates.put("the_customer", thecustomer);
			}

			return coordinates;

		}

		else

		{

			coordinates.put("status", 0);
			coordinates.put("having_an_account", 0);
			coordinates.put("correct_password", 0);

			return coordinates;

		}

	}


    ////////////////////////////customer_sign_up/////////////////////////////////////////

	@Override

	@Transactional
	public Map signUp(Customer theCustomer) {

		Map<String, Object> coordinates = new HashMap<>();

		Customer thecustomer1 = getCustomerByEmail(theCustomer.getEmail());

		if (thecustomer1 != null) {
			
			coordinates.put("status", 0);


			coordinates.put("already_has_an_account", 1);

			coordinates.put("the_customer", thecustomer1);
		

		} 
		else {
			
			coordinates.put("status", 1);

			coordinates.put("already_has_an_account", 0);
			
			theCustomer.setCustomerId(0);
			
			saveORupdate(theCustomer);
		  Customer thecustomer2 = getCustomerByEmail(theCustomer.getEmail());
		  coordinates.put("the_customer", thecustomer2);

		}
      	
		return coordinates;
	}

	@Override
	@Transactional
	public void add_products_to_customer(int theCustomerId, int theproductCode) {
            CustomersDAO.add_products_to_customer(theCustomerId, theproductCode);		
	}

	@Override
	public void add_Phones_to_customer(CustomersPhone Custmersphone) {
		// TODO Auto-generated method stub
		CustomersDAO.add_Phones_to_customer(Custmersphone);
	}

	@Override
	public CustomersPhone findCustomerPhoneByCustomrId(int customerid,int customerphone) {
		// TODO Auto-generated method stub
		return CustomersDAO.findCustomerPhoneByCustomrId(customerid,customerphone);
	}

	@Override
	public Customer saveandreturncustomer(Customer theCustomer) {
		Customer thecustomer1 = getCustomerByEmail(theCustomer.getEmail());
	  
	if(thecustomer1 != null) {
		
		//theCustomer.setCustomerId(0);
		
		saveORupdate(theCustomer);
	  Customer thecustomer2 = getCustomerByEmail(theCustomer.getEmail());
	  Customer thecustomer3 = findByCode(theCustomer.getCustomerId());
	   System.out.println(thecustomer2.getCustomerId());
	   theCustomer=thecustomer3 ;
	   }
	
		return theCustomer;
	}

	@Override
	public Map<String, Object> updatePassword(int customerId, String newPassword) {
		Map<String, Object> coordinates = new HashMap<>();
		Customer theCustomer = findByCode(customerId);

		if (theCustomer == null) {
			
			coordinates.put("status", 0);
			coordinates.put("message", "the customer not found");
		}
		else {
		CustomersDAO.updatePassword(customerId,newPassword);
		coordinates.put("status", 1);
		}
		return coordinates;
	}


}

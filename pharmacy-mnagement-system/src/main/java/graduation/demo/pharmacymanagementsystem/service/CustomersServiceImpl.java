package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.CustomersDAO;
import graduation.demo.pharmacymanagementsystem.dto.CustomerDTO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
import graduation.demo.pharmacymanagementsystem.rest.CustomersPhoneRestController;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersDAO CustomersDAO;
	
	@Autowired
	private CustomersPhoneService customersPhoneService;

	@Autowired
	private CustomersAddressService customersAddressService;
	
	//@Autowired
	/*public CustomersServiceImpl(CustomersDAO theCustomersDAO,CustomersPhoneService theCustomersPhoneService) {
		CustomersDAO = theCustomersDAO;
		customersPhoneService =theCustomersPhoneService;
	}*/
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAllCustomers() {

		return CustomersDAO.findAllCustomers();
	}

	@Override
	@Transactional
	public List<Customer> findpaidCustomers() {
		// TODO Auto-generated method stub
		return CustomersDAO.findpaidCustomers();
	}

	@Override
	@Transactional
	public List<Customer> findcredit_addedCustomers() {
		// TODO Auto-generated method stub
		return CustomersDAO.findcredit_addedCustomers();
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
	public List<Map<String, Object>> get_effective_customers() {
		return CustomersDAO.get_effective_customers();
	}

	///////////////////////////////add new customer from desktop/////////////////////////
	@Override
	@Transactional
	public Customer save_desktop(CustomerDTO theCustomerdto) {

		//CustomersPhoneService customersPhoneService = null;
		
        //Map<String, Object> coordinates = new HashMap<>();
		
		CustomersPhone theCustomer_phone  = customersPhoneService.get_customer_by_phone(theCustomerdto.getPhoneNumber());
		
       if(theCustomer_phone==null)
       {
		Customer theCustomer = new Customer();

		if (theCustomerdto.getFirstName() != null) {
			theCustomer.setFirstName(theCustomerdto.getFirstName());
		}

		if (theCustomerdto.getLastName() != null) {

			theCustomer.setLastName(theCustomerdto.getLastName());
		}

		if (theCustomerdto.getDateOfBirth() != null) {

			theCustomer.setDateOfBirth(theCustomerdto.getDateOfBirth());
		}

		if (theCustomerdto.getGender() != null) {
			
			theCustomer.setGender(theCustomerdto.getGender());
		}

		if (theCustomerdto.getEmail() != null) {

			theCustomer.setEmail(theCustomerdto.getEmail());
		}

		if (theCustomerdto.getCredit() != 0) {

			theCustomer.setCredit(theCustomerdto.getCredit());
		}
        theCustomer.setPassword(theCustomerdto.getPassword());		
		
        theCustomer.setRate(theCustomerdto.getRate());        
        Customer the_customer =  CustomersDAO.save_desktop(theCustomer);
		
		
		return the_customer;
       }
       
		else {
		
	
			return null;
		}
		
       //return coordinates;
    	   
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

	//////////////////////////// customer_sign_in/////////////////////////////////////////

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

	//////////////////////////// customer_sign_up/////////////////////////////////////////

	@Override

	@Transactional
	public Map signUp(Customer theCustomer) {

		Map<String, Object> coordinates = new HashMap<>();

		Customer thecustomer1 = getCustomerByEmail(theCustomer.getEmail());

		if (thecustomer1 != null) {

			coordinates.put("status", 0);

			coordinates.put("already_has_an_account", 1);

			coordinates.put("the_customer", thecustomer1);

		} else {

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
	public CustomersPhone findCustomerPhoneByCustomrId(int customerid, int customerphone) {
		// TODO Auto-generated method stub
		return CustomersDAO.findCustomerPhoneByCustomrId(customerid, customerphone);
	}

	@Override
	public Customer saveandreturncustomer(Customer theCustomer) {
		Customer thecustomer1 = getCustomerByEmail(theCustomer.getEmail());

		if (thecustomer1 != null) {

			// theCustomer.setCustomerId(0);

			saveORupdate(theCustomer);
			Customer thecustomer2 = getCustomerByEmail(theCustomer.getEmail());
			Customer thecustomer3 = findByCode(theCustomer.getCustomerId());
			System.out.println(thecustomer2.getCustomerId());
			theCustomer = thecustomer3;
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
		} else {
			CustomersDAO.updatePassword(customerId, newPassword);
			coordinates.put("status", 1);
		}
		return coordinates;
	}

	
	///////////////////////////get customer by customer phone /////////////////////////
	@Override
	public Map<String, Object> get_customer_by_phone (String phone) {
		Map<String, Object> coordinates = new HashMap<>();
		CustomersPhone customerPhone = customersPhoneService.get_customer_by_phone(phone);
		if (customerPhone !=null) {
				int cId = customerPhone.getId().getCustomerId();
		
				Customer thecustomer = findByCode(cId);
		
				/*Map<String, Object> customer_coordinates = new HashMap<>();
				customer_coordinates.put("customerId",cId );
           		customer_coordinates.put("firstName",thecustomer.getFirstName());
        		customer_coordinates.put("lastName",thecustomer.getLastName());
        		customer_coordinates.put("credit",thecustomer.getCredit());
        		customer_coordinates.put("customersAddresses",thecustomer.getCustomersAddresses() );
			    customer*/
			    coordinates.put("theCustomer",thecustomer );
			    coordinates.put("status", 1);
			}
		else
		{
			coordinates.put("status", 0);
			coordinates.put("msq","the customer phone not found");
		}
		
		return coordinates;

	}
	
	
	
	
	//////////////////////////// update customer by customer phone ////////////////////
	
	
    @Transactional
	@Override
	public Customer updateCustomer_by_phone(CustomerDTO theCustomerdto) {
		
		CustomersPhone theCustomer_phone  = customersPhoneService.get_customer_by_phone(theCustomerdto.getPhoneNumber());
		
        if(theCustomer_phone!=null)
	       {
			  //Customer theCustomer = new Customer();
        	  Customer theCustomer = findByCode(theCustomer_phone.getId().getCustomerId());
              CustomersPhonePK customerph_id=theCustomer_phone.getId();
              System.out.println(customerph_id);
//			  theCustomer.setCustomerId(customerph_id.getCustomerId());
			  
			if (theCustomerdto.getFirstName() != null) {
				theCustomer.setFirstName(theCustomerdto.getFirstName());
			}

			if (theCustomerdto.getLastName() != null) {

				theCustomer.setLastName(theCustomerdto.getLastName());
			}

			if (theCustomerdto.getDateOfBirth() != null) {

				theCustomer.setDateOfBirth(theCustomerdto.getDateOfBirth());
			}

			if (theCustomerdto.getGender() != null) {
				
				theCustomer.setGender(theCustomerdto.getGender());
			}

			if (theCustomerdto.getEmail() != null) {

				theCustomer.setEmail(theCustomerdto.getEmail());
			}

			if (theCustomerdto.getCredit() != 0) {

				theCustomer.setCredit(theCustomerdto.getCredit());
			}
            
            System.out.println(theCustomer);
            
			  CustomersDAO.update_customer(theCustomer);
			  
			  //Customer the_Customer = findByCode(theCustomer_phone.getId().getCustomerId());
			  			  
			 if(theCustomerdto.getEdited_phone() != null) { 
			  customersPhoneService.update(theCustomer_phone, theCustomerdto.getEdited_phone());
			   }
			 
			 if(theCustomerdto.getEdited_address() != null) {

				 CustomersAddress the_customersAddress = customersAddressService.findSpecificCustomerAddress(theCustomer.getCustomerId(),theCustomerdto.getAddress());
				  customersAddressService.update(the_customersAddress, theCustomerdto.getEdited_address()); 
				 
			 }
			 
			 
			  return null;
			  
	       }
	       
			else {
			
		
				return null;
			}
		
		
	}

	
	
	
}

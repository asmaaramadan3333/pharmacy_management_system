package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Customer;

public interface CustomersService {

    public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCustomerId);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCustomerId);
	
	public List<Customer> searchByName(String theCustomerName);

	public Customer getCustomerByEmail(String theemail);
	
	public Map<String, Boolean>  customerSignIn(String theemail, String thepassword);

	public Map signUp(Customer theCustomer);
	
	
	
}

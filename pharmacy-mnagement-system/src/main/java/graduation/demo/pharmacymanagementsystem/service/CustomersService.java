package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersService {

    public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCustomerId);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCustomerId);
	
	public List<Customer> searchByName(String theCustomerName);

	public Customer getCustomerByEmail(String theemail);
	
	public Map<String, Integer>  customerSignIn(String theemail, String thepassword);

	public Map signUp(Customer theCustomer);
	
	public void add_products_to_customer(int theCustomerId,int theproductCode); 

	
}

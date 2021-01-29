package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Customer;

public interface CustomersDAO {

	public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCode);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCode);

	public List<Customer> searchByName(String theName);

	public Customer getCustomerByEmail(String theemail);

	public Customer signIn(String theemail, String thepassword);
	
	
}

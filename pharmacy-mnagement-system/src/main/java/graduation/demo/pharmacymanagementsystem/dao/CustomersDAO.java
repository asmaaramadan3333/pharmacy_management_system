package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Customer;

public interface CustomersDAO {

	public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCustomerId);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCustomerId);

	public List<Customer> searchByName(String theCustomerName);

	public Customer getCustomerByEmail(String theemail);

	public Customer signIn(String theemail, String thepassword);

	public void add_products_to_customer(int theCustomerId, int theproductCode);
	
	
}

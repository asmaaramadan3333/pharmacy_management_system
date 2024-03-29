package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersDAO {

	public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCustomerId);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCustomerId);

	public List<Customer> searchByName(String theCustomerName);

	public Customer getCustomerByEmail(String theemail);

	public Customer signIn(String theemail, String thepassword);

	public void add_products_to_customer(int theCustomerId, int theproductCode);

	public void add_Phones_to_customer(CustomersPhone Custmersphone);
	
	public CustomersPhone findCustomerPhoneByCustomrId(int customerid, int customerphone);

	public Customer saveandreturncustomer(Customer theCustomer);

	public void updatePassword(int customerId, String newPassword);

	public List<Customer> findpaidCustomers();

	public List<Customer> findcredit_addedCustomers();

	public Customer save_desktop(Customer theCustomer);

	public void update_customer(Customer theCustomer);

	public List<Map<String, Object>> get_effective_customers();

	

}

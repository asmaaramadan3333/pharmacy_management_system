package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.dto.CustomerDTO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersService {

    public List <Customer> findAllCustomers();
	
	public Customer findByCode (int theCustomerId);
	
	public void saveORupdate (Customer theCustomer);
	
	public void deleteByCode (int theCustomerId);
	
	public List<Customer> searchByName(String theCustomerName);

	public Customer getCustomerByEmail(String theemail);
	
	public Map<String, Object> get_customer_by_phone(String phone);

	public Map<String, Object>  customerSignIn(String theemail, String thepassword);

	public Map signUp(Customer theCustomer);
	
	public void add_products_to_customer(int theCustomerId,int theproductCode); 

	public void add_Phones_to_customer(CustomersPhone Custmersphone);

	public CustomersPhone findCustomerPhoneByCustomrId(int customerid, int customerphone);
	public Customer saveandreturncustomer(Customer theCustomer);


	public Map<String, Object> updatePassword(int customerId, String password);

	public List<Customer> findpaidCustomers();

	public List<Customer> findcredit_addedCustomers();

	public Customer save_desktop(CustomerDTO theCustomer);

	public Customer updateCustomer_by_phone(CustomerDTO theCustomerdto);

	public List<Map<String, Object>> get_effective_customers();





	
}

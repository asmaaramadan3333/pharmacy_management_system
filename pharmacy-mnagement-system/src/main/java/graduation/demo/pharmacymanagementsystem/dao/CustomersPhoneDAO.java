package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneDAO {
	
	public  List<CustomersPhone> findCustomerPhoneById (int theCustomerId);

	public void save(CustomersPhone theCustomersphone);
 
	public void deleteById(int thecustomerid, String thehpone);
  
	public CustomersPhone findSpecificCustomerPhone(int customerId, String phone);
	
	public void update(CustomersPhone theCustomersPhone,int theCustomersPhone2);

	public void update(CustomersPhone tempcustomerphone, String theCustomerPhonenew);

	public CustomersPhone get_customer_by_phone(String phone);


}

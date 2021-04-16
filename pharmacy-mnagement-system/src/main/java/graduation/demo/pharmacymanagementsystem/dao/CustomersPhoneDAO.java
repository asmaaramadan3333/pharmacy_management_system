package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneDAO {
	
	public  List<CustomersPhone> findCustomerPhoneById (int theCustomerId);

	public void save(CustomersPhone theCustomersphone);
 
	void deleteById(int thecustomerid, int thehpone);

	public CustomersPhone findSpecificCustomerPhone(int customerId, int phone);
	
	
}

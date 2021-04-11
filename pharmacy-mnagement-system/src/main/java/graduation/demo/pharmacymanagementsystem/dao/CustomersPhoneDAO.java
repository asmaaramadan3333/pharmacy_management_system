package graduation.demo.pharmacymanagementsystem.dao;

import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneDAO {
	public  CustomersPhonePK findCustomerPhoneById (int theCustomerId);

	

	public void save(CustomersPhone theCustomersphone);



	public void deleteById(int theid);
	
	
}

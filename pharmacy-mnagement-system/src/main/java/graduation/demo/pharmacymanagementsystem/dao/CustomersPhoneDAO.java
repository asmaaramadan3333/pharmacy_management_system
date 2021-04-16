package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneDAO {

	
	public void save(CustomersPhone theCustomersphone);

	public void deleteById(int theid, int customerphone);
	
	public void update(CustomersPhone theCustomersPhone,int theCustomersPhone2);

	public CustomersPhone findSpecificCustomerPhone(int customerId, int phone);

	public List<CustomersPhone> findCustomerPhoneById(int theCustomerId);
}

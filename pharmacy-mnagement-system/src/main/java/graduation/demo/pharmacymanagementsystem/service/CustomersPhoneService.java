package graduation.demo.pharmacymanagementsystem.service;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneService {
	
	public void deleteById(int theid, int customerphone);
	public void save(CustomersPhone theCustomersPhone);
	
	
	
	//public void update(CustomersPhone theCustomersPhone);
	public void update(CustomersPhone tempcustomerphone, int phoneNumber);
	List<CustomersPhone> findCustomerPhoneByCustomrId(int theCustomerId);
	CustomersPhone findSpecificCustomerPhone(int customerId, int phone);
}

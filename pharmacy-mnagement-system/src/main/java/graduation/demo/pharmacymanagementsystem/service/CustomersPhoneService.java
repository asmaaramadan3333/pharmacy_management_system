package graduation.demo.pharmacymanagementsystem.service;


import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneService {
	public CustomersPhonePK findCustomerPhoneByCustomrId (int theCustomerId);
	public void deleteById(int theid);
	public void save(CustomersPhone theCustomersPhone);
}

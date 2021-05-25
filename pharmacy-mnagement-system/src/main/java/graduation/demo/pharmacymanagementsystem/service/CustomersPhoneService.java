package graduation.demo.pharmacymanagementsystem.service;


import java.util.List;


import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;

public interface CustomersPhoneService {

  public List<CustomersPhone> findCustomerPhoneByCustomrId (int theCustomerId);
	//public void deleteById(int theid);
	public void save(CustomersPhone theCustomersPhone);
	
	public void deleteById(int thecustomerid, String customerPhone);
	
	public CustomersPhone findSpecificCustomerPhone(int customerId, String theCustomerPhoneold);
	
 	//public void update(CustomersPhone tempcustomerphone, int phoneNumber);
	public void update(CustomersPhone tempcustomerphone, String theCustomerPhonenew);


}

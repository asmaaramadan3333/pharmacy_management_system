package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import graduation.demo.pharmacymanagementsystem.dao.CustomersPhoneDAO;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
@Service
public class CustomersPhoneServiceImpl implements CustomersPhoneService {
	private CustomersPhoneDAO CustomersPhoneDAO;

	@Autowired
	public CustomersPhoneServiceImpl(CustomersPhoneDAO theCustomersPhoneDAO) {
		CustomersPhoneDAO = theCustomersPhoneDAO;
	}

	@Override
	public List<CustomersPhone> findCustomerPhoneByCustomrId(int theCustomerId) {
		
		return CustomersPhoneDAO.findCustomerPhoneById(theCustomerId);
	}
	
	@Override
	public void save(CustomersPhone theCustomersPhone) {
		 CustomersPhoneDAO.save(theCustomersPhone);
	}
	
	@Override
	public void deleteById(int thecustomerid,String thehpone) {
		 CustomersPhoneDAO.deleteById( thecustomerid,  thehpone);		
	}
  
	@Override
	public CustomersPhone findSpecificCustomerPhone(int customerId, String phone) {

		return  CustomersPhoneDAO.findSpecificCustomerPhone(customerId,phone);
	}
	

	/*
	 * @Override public void update(CustomersPhone theCustomersPhone, int
	 * phoneNumber) { // TODO Auto-generated method stub CustomersPhoneDAO.update(
	 * theCustomersPhone, phoneNumber); }
	 */
	@Override
	public void update(CustomersPhone tempcustomerphone, String theCustomerPhonenew) {
		// TODO Auto-generated method stub
		CustomersPhoneDAO.update( tempcustomerphone, theCustomerPhonenew);
	}

	///////////////////commented uintell needed///////////////
	
	@Override
	public CustomersPhone get_customer_by_phone(String phone) {
		
	    CustomersPhone theCustomer_phone = CustomersPhoneDAO.get_customer_by_phone(phone);
		
	    
	    return theCustomer_phone; 
	}





}

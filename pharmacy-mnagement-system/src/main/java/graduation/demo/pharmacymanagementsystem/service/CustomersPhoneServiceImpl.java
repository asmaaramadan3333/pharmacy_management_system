package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

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
	public void deleteById(int thecustomerid,int thehpone) {
		 
		CustomersPhoneDAO.deleteById( thecustomerid,  thehpone);

		
	}
	
	@Override
	public CustomersPhone findSpecificCustomerPhone(int customerId, int phone) {
		
		return  CustomersPhoneDAO.findSpecificCustomerPhone(customerId,phone);
	}
	/*
	 * @Override public void save(CustomersPhone theCustomersPhone) { // TODO
	 * Auto-generated method stub CustomersPhoneDAO.save(theCustomersPhone); }
	 * 
	 * @Override public void deleteById(int theid,int customerphone) {
	 * CustomersPhoneDAO.deleteById(theid,customerphone);
	 * 
	 * }
	 * 
	 * @Override public CustomersPhone findCustomerPhoneByCustomrId(int
	 * theCustomerId,int CustomerPhone) { // TODO Auto-generated method stub return
	 * CustomersPhoneDAO.findCustomerPhoneByCustomrId(theCustomerId,CustomerPhone);
	 * }
	 * 
	 * @Override public void saveORupdateCustomerPhone(CustomersPhone
	 * theCustomersPhone) {
	 * CustomersPhoneDAO.saveORupdateCustomerPhone(theCustomersPhone);
	 * 
	 * }
	 * 
	 * @Override public Customer findByCode(int theCustomerId) { // TODO
	 * Auto-generated method stub return
	 * CustomersPhoneDAO.findByCode(theCustomerId); }
	 * 
	 * @Override public void saveORupdate(Customer theCustomer) {
	 * CustomersPhoneDAO.saveORupdate(theCustomer);
	 * 
	 * }
	 * 
	 * @Override public void saveORupdate(CustomersPhone theCustomersPhone) {
	 * 
	 * CustomersPhoneDAO.saveORupdateCustomerPhone(theCustomersPhone); }
	 */

	@Override
	public void update(CustomersPhone theCustomersPhone, int phoneNumber) {
		// TODO Auto-generated method stub
		CustomersPhoneDAO.update( theCustomersPhone, phoneNumber);
	}





}

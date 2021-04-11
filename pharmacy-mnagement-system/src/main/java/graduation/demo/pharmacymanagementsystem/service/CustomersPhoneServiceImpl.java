package graduation.demo.pharmacymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.dao.CustomersPhoneDAO;
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
	public CustomersPhonePK findCustomerPhoneByCustomrId(int theCustomerId) {
		// TODO Auto-generated method stub
		return CustomersPhoneDAO.findCustomerPhoneById(theCustomerId);
	}
	
	@Override
	public void save(CustomersPhone theCustomersPhone) {
		// TODO Auto-generated method stub
		 CustomersPhoneDAO.save(theCustomersPhone);
	}
	@Override
	public void deleteById(int theid) {
		 CustomersPhoneDAO.deleteById(theid);
		
	}

}

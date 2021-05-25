package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.CustomersAddressDAO;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
@Service
public class CustomersAddressServiceImpl implements CustomersAddressService {
	private CustomersAddressDAO CustomersAddressDAO;

	@Autowired
	public CustomersAddressServiceImpl(CustomersAddressDAO theCustomersAddressDAO) {
		CustomersAddressDAO = theCustomersAddressDAO;
	}
	
	
	@Override
	@Transactional
	public List<CustomersAddress> findCustomerAddressByCustomrId(int theCustomerId) {
		// TODO Auto-generated method stub
		return CustomersAddressDAO.findCustomerAddressById(theCustomerId);
	}
    
	@Override
	@Transactional
	public void saveORupdate(CustomersAddress theCustomersAddress) {

		CustomersAddressDAO.saveORupdate(theCustomersAddress);
	}



	@Override
	public CustomersAddress findSpecificCustomerAddress(int customerId, String address) {
		// TODO Auto-generated method stub
		return CustomersAddressDAO.findSpecificCustomerAddress(customerId,address);
	}


	@Override
	public void deleteById(int theCustomerId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteById(int thecustomerid, String address) {
		// TODO Auto-generated method stub
		CustomersAddressDAO.deleteById(thecustomerid, address);
	}


	@Override
	public void update(CustomersAddress tempCustomersAddress, String theCustomerAdressnew) {
		// TODO Auto-generated method stub
		CustomersAddressDAO.update(tempCustomersAddress,  theCustomerAdressnew);
	}

}

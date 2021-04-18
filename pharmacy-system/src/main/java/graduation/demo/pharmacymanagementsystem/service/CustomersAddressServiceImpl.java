package graduation.demo.pharmacymanagementsystem.service;

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
	public CustomersAddress findCustomerAddressByCustomrId(int theCustomerId) {
		// TODO Auto-generated method stub
		return CustomersAddressDAO.findCustomerAddressById(theCustomerId);
	}
    
	@Override
	@Transactional
	public void saveORupdate(CustomersAddress theCustomersAddress) {

		CustomersAddressDAO.saveORupdate(theCustomersAddress);
	}
	@Override
	@Transactional
	public void deleteById(int theCustomerId) {

		CustomersAddressDAO.deleteByCode(theCustomerId);

	}

}

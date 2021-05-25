package graduation.demo.pharmacymanagementsystem.service;
import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;

public interface CustomersAddressService {
	public List<CustomersAddress> findCustomerAddressByCustomrId (int theCustomerId);



	public void saveORupdate(CustomersAddress theCustomersAddress);



	public void deleteById(int theCustomerId);



	public CustomersAddress findSpecificCustomerAddress(int customerId, String address);
	public void deleteById(int thecustomerid, String address);



	public void update(CustomersAddress tempCustomersAddress, String theCustomerAdressnew);
}

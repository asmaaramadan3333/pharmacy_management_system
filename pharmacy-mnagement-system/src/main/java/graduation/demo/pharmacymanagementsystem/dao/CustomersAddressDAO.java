package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;

public interface CustomersAddressDAO {
	public  List<CustomersAddress> findCustomerAddressById (int theCustomerId);

	public void saveORupdate(CustomersAddress theCustomersAddress);


	public CustomersAddress findSpecificCustomerAddress(int customerId, String address);

	public void deleteById(int thecustomerid, String address);

	public void update(CustomersAddress tempCustomersAddress, String theCustomerAdressnew);
}

package graduation.demo.pharmacymanagementsystem.dao;

import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;

public interface CustomersAddressDAO {
	public  CustomersAddress findCustomerAddressById (int theCustomerId);

	public void saveORupdate(CustomersAddress theCustomersAddress);

	public void deleteByCode(int theCustomersId);
}

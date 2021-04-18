package graduation.demo.pharmacymanagementsystem.service;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;

public interface CustomersAddressService {
	public CustomersAddress findCustomerAddressByCustomrId (int theCustomerId);



	public void saveORupdate(CustomersAddress theCustomersAddress);



	public void deleteById(int theCustomerId);
	
}

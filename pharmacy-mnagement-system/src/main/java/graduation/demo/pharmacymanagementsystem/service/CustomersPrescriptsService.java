package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.CustomersPrescript;

public interface CustomersPrescriptsService {

    public List <CustomersPrescript> findAllCustomersPrescripts();
	
	public CustomersPrescript findById (int theId);
	
	public void saveORupdate (CustomersPrescript theCustomersPrescript);
	
	
	public CustomersPrescript searchByurl(String theurl);

	public Map<String, Object> findByCustomerId(int customerId);

	
	
}

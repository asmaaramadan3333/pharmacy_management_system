package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.CustomersPrescript;

public interface CustomersPrescriptsDAO {

	

	public List<CustomersPrescript> findAllCustomersPrescripts();
	
	public CustomersPrescript findById (int theId);
	
	public void saveORupdate (CustomersPrescript theCustomersPrescript);
	
	public CustomersPrescript searchByurl(String theurl);

	public List<CustomersPrescript> findByCustomerId(int customerId);

	public void update_status(int prescript_id);
	
	
}

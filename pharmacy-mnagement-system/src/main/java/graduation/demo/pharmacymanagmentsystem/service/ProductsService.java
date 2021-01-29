package graduation.demo.pharmacymanagmentsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagmentsystem.entity.Product;

public interface ProductsService {

    public List <Product> findAllProducts();
	
	public Product findByCode (int theCode);
	
	public void saveORupdate (Product theProduct);
	
	public void deleteByCode (int theCode);
	
	public List<Product> searchByName(String theName);
	
}

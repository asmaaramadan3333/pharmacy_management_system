package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Product;

public interface ProductsService {

    public List <Product> findAllProducts();
	
	public Product findByCode (int theCode);
	
	public void saveORupdate (Product theProduct);
	
	public void deleteByCode (int theCode);
	
	public List<Product> searchByName(String theName);
	
	public List<Product> select_by_category(String main_category,String secondary_category);

	 public int returnproductcode(String name, String type, int size);
	 public List<Product> findProductsWithState0();

	public List<Product> findAllProductsInRange(Integer id1, Integer id2);
}

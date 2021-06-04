package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.ProductsDAO;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsDAO productsDAO ;
	
    @Autowired
	public ProductsServiceImpl(ProductsDAO theProductsDAO) {
    	productsDAO = theProductsDAO;
	}
	
	@Override
	@Transactional
	public List<Product> findAllProducts() {
		
		return productsDAO.findAllProducts();
	}

	@Override
	@Transactional
	public Product findByCode(int theCode) {
		
		return productsDAO.findByCode(theCode);
	}

	@Override
	@Transactional
	public void saveORupdate(Product theProduct) {
		
		productsDAO.saveORupdate(theProduct);
	}

	@Override
	@Transactional
	public void deleteByCode(int theCode) {
		
		productsDAO.deleteByCode(theCode);
		
	}

	@Override
	public List<Product> searchByName(String theName) {
		
		return productsDAO.searchByName(theName);
	}

	@Override
	public List<Product> select_by_category(String main_category, String secondary_category) {
		return productsDAO.select_by_category(main_category, secondary_category);
	}

	@Override
	public int returnproductcode(String theproductname,String type,int size) {
		// TODO Auto-generated method stub
		
		Product theproduct=productsDAO.get_code(theproductname, type, size);
		return theproduct.getCode();
	}

	@Override
	public List<Product> findProductsWithState0() {
		// TODO Auto-generated method stub
		return productsDAO.findProductsWithState0();
	}
}

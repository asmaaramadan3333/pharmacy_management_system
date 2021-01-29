package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.Product;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public ProductsDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List<Product> findAllProducts() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Product> theQuery =
				currentSession.createQuery("from Products", Product.class);
				
		// execute query and get result list
		List <Product> Product = theQuery.getResultList();
				
		// return the results		
		return Product;
	}

	@Override
	public Product findByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the product
		Product theProduct =
				currentSession.get(Product.class, theCode);
				
		// return the product
		return theProduct;
	}

	
	@Override
	public void saveORupdate(Product theProduct) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save product
		currentSession.saveOrUpdate(theProduct);
		
	}
	
	
	@Override
	public List<Product> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM Product  WHERE name like :productName", Product.class );
		
		theQuery.setParameter("productName", theName+ "%");
		
		
		List <Product> products = theQuery.getResultList();
		
		// return the results		
		return products;
	}

	@Override
	public void deleteByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from Product where code=:productCode");
		theQuery.setParameter("productCode", theCode);
				
		theQuery.executeUpdate();

		
	}

	
	
	
	
	
}

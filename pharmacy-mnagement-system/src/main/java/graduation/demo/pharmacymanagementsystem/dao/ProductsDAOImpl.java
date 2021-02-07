package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
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
				currentSession.createQuery("from Product", Product.class);
				
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
	//////////////////////////return the id of product by taking name,size,type///////////////////////////
	public Product get_code(String name,String type,int size)
	{
		Product theProduct = null;
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// search object with name
		Query  theQuery = 
				currentSession.createQuery(
						"FROM Product p  WHERE p.name =: thename AND p.size =: thesize AND p.type =: thetype", Product.class );
		theQuery.setParameter("thename", name);
		theQuery.setParameter("thesize",size);
		theQuery.setParameter("thetype",type);
		theProduct=(Product) theQuery.getResultList().get(0);
		return theProduct;
	}
	
	
	@Override
	public List<Product> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query<Product> theQuery = 

				currentSession.createQuery(
						"FROM Product  WHERE name like :productName", Product.class );
		
		theQuery.setParameter("productName", theName+ "%");
		
		
		List <Product> products = theQuery.getResultList();
		
		// return the results		
		return products;
	}
	
	@Override
	public List<Product> select_by_category(String main_category,String secondary_category) {
		
		List <Product> products=null;
		
		try {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name

		Query<Product> theQuery = 

				currentSession.createQuery(
		"FROM Product p  WHERE p.mainCategory =: first AND p.secondaryCategory =: second", Product.class );
		
		theQuery.setParameter("first", main_category,StringNVarcharType.INSTANCE);
		
		theQuery.setParameter("second",  secondary_category,StringNVarcharType.INSTANCE );
		
		
		if(theQuery.getResultList()!=null&&!theQuery.getResultList().isEmpty()) {
		
			 products = theQuery.getResultList();
		
		
		}}
		catch(NoResultException  ex)
		{
			ex.printStackTrace();
		}
		
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

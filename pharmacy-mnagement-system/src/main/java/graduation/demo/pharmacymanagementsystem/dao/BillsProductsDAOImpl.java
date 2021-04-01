package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;

@Repository
public class BillsProductsDAOImpl implements BillsProductsDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public BillsProductsDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List<BillsProduct> findAllBillsProducts() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<BillsProduct> theQuery =
				currentSession.createQuery("from BillsProduct", BillsProduct.class);
				
		// execute query and get result list
		List <BillsProduct> BillsProduct = theQuery.getResultList();
				
		// return the results		
		return BillsProduct;
	}

	@Override
	public BillsProduct findByBillsProductID(int thebill_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the Bill
		BillsProduct theBillsProduct =
				currentSession.get(BillsProduct.class, thebill_id);
				
		// return the Bill
		return theBillsProduct;
	}

	
	@Override
	public void saveORupdate(BillsProduct theBillsProduct) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save BillsProduct
		currentSession.saveOrUpdate(theBillsProduct);
		
	}
	
	
	/*@Override
	public List<BillsProduct> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM BillsProducts  WHERE name like :BillsProductName", BillsProduct.class );
		
		theQuery.setParameter("BillsProductName", theName+ "%");
		
		
		List <BillsProduct> BillsProducts = theQuery.getResultList();
		
		// return the results		
		return BillsProducts;
	}*/

	@Override
	public void deleteByBillsProductID(int theBillsProduct_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from BillsProduct where code=:id");
		theQuery.setParameter("BillsProductCode", theBillsProduct_id);
				
		theQuery.executeUpdate();

		
	}
	
}

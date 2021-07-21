package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProductPK;

@Repository
public class PrescriptsProductsDAOImpl implements PrescriptsProductsDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public PrescriptsProductsDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List<PrescriptsProduct> findAllPrescriptsProducts() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<PrescriptsProduct> theQuery =
				currentSession.createQuery("from PrescriptsProduct", PrescriptsProduct.class);
				
		// execute query and get result list
		List <PrescriptsProduct> PrescriptsProduct = theQuery.getResultList();
				
		// return the results		
		return PrescriptsProduct;
	}

	@Override
	public PrescriptsProduct findById(PrescriptsProductPK theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the PrescriptsProduct
		PrescriptsProduct thePrescriptsProduct =
				currentSession.get(PrescriptsProduct.class, theId);
				
		// return the PrescriptsProduct
		return thePrescriptsProduct;
	}

	
	@Override
	public List<PrescriptsProduct> saveORupdate(List<PrescriptsProduct> thePrescriptsProduct) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction tx = currentSession.beginTransaction();
		for(int i=0 ;i<thePrescriptsProduct.size();i++)
		{
		currentSession.save(thePrescriptsProduct.get(i));

		}
		tx.commit();
		currentSession.close();
      
		return thePrescriptsProduct;
		
	}
	
	
	@Override
	public List<PrescriptsProduct> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM PrescriptsProducts  WHERE name like :PrescriptsProductName", PrescriptsProduct.class );
		
		theQuery.setParameter("PrescriptsProductName", theName+ "%");
		
		
		List <PrescriptsProduct> PrescriptsProducts = theQuery.getResultList();
		
		// return the results		
		return PrescriptsProducts;
	}

	@Override
	public void deleteByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from PrescriptsProducts where code=:PrescriptsProductCode");
		theQuery.setParameter("PrescriptsProductCode", theCode);
				
		theQuery.executeUpdate();

		
	}

	
	
	
	
	
}

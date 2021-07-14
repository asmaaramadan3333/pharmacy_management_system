package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.BillsProductPK;
import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.entity.Supply;

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
	public BillsProduct getbill_by_pkid(BillsProductPK id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Bill
		BillsProduct theBillsProduct =
				currentSession.get(BillsProduct.class, id);
				
		// return the Bill
		return theBillsProduct;
		
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
	public List<BillsProduct> find_BillsProductby_Bill_ID(long bill_id) {
		// get the current hibernate session
		System.out.println(bill_id);
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the Bill
		Query theQuery = currentSession.createQuery("FROM BillsProduct  WHERE id.billId = : the_billid" , BillsProduct.class);

		theQuery.setParameter("the_billid", bill_id);
		
        System.out.println(theQuery);
		List<BillsProduct> theBillsProducts = theQuery.getResultList();
	
				
		// return the Bill
		return theBillsProducts;
	}

	
	@Override
	//@Transactional
	public void saveORupdate(List<BillsProduct>  theBillsProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction tx = currentSession.beginTransaction();
		for(int i=0 ;i<theBillsProduct.size();i++)
		{
		currentSession.save(theBillsProduct.get(i));

		}
		tx.commit();
		currentSession.close();
        /*for (int i =0; i<theBillsProduct.size();i++)
        {
		//currentSession.saveOrUpdate(theBillsProduct.get(i));
		currentSession.merge(theBillsProduct.get(i));
        }*/
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
	
	
	@Override
	public Product findProductByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the product
		Product theProduct =
				currentSession.get(Product.class, theCode);
				
		// return the product
		return theProduct;
	}


	
}

package graduation.demo.pharmacymanagementsystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import graduation.demo.pharmacymanagementsystem.entity.SupplyProduct;

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
	public List<BillsProduct> saveORupdate(List<BillsProduct>  theBillsProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		for(int i=0 ;i<theBillsProduct.size();i++)
		{
		Transaction tx = currentSession.beginTransaction();

		System.out.println(theBillsProduct.get(i));
		currentSession.save(theBillsProduct.get(i));
		tx.commit();

		}
		currentSession.close();
      
		return theBillsProduct;
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
		theQuery.setParameter("id", theBillsProduct_id);
				
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




	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> get_best_summer_sells() {
		
		List<Map<String,Object>> coordinatesList = new ArrayList<Map<String,Object>>();
		Map<String, Object> coordinates = new HashMap<>();
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {
		Query theQuery = 
				currentSession.createQuery(
						"SELECT new map ((bp.id.productCode) as productCode , sum(bp.quantity) as quantity, p.name as productName)" 
						+ "        FROM Bill b, BillsProduct bp, Product p "
						+ "        where b.billId = bp.id.billId and (bp.id.productCode) = p.code"
						+ "        and month(b.time) >= 3 and month(b.time) <= 8 and year(b.time) = year(current_date()) "
						+ "        group by bp.id.productCode order by sum(bp.quantity) desc ");
		
		theQuery.setFirstResult(0);
		theQuery.setMaxResults(10);
		
		if (!theQuery.getResultList().isEmpty())
		{
			for (int i=0;i<theQuery.getResultList().size();i++)
			{
				coordinates = ( Map<String, Object>) theQuery.getResultList().get(i);
				coordinatesList.add(coordinates);
			}
		}
				
		   }
		catch (Exception ex) {
		ex.printStackTrace();
	    }
		return coordinatesList;
	}




	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> get_best_winter_sells() {
		List<Map<String,Object>> coordinatesList = new ArrayList<Map<String,Object>>();
		Map<String, Object> coordinates = new HashMap<>();
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {
		Query theQuery = 
				currentSession.createQuery(
						"SELECT new map ((bp.id.productCode) as productCode , sum(bp.quantity) as quantity, p.name as productName)" 
						+ "        FROM Bill b, BillsProduct bp, Product p " 
						+ "        where b.billId = bp.id.billId and (bp.id.productCode) = p.code" 
						+ "        and (month(b.time) >= 9 or month(b.time) <= 2) and year(b.time) = year(current_date()) " 
						+ "        group by bp.id.productCode order by sum(bp.quantity) desc ");
		
		theQuery.setFirstResult(0);
		theQuery.setMaxResults(10);
		
		if (!theQuery.getResultList().isEmpty())
		{
			for (int i=0;i<theQuery.getResultList().size();i++)
			{
				coordinates = ( Map<String, Object>) theQuery.getResultList().get(i);
				coordinatesList.add(coordinates);
			}
		}
				
		   }
		catch (Exception ex) {
		ex.printStackTrace();
	    }
		return coordinatesList;
	}

	
	
	
	
	
	
	
	/*@SuppressWarnings("unchecked")
	@Override
	public void editSupplyQuantity(BillsProduct the_saved_product) {
		
		Map<String, Object> total_quantity = new HashMap<>();;
		Session currentSession =entityManager.unwrap(Session.class);
			
			try {
			Query<SupplyProduct> theQuery =

			currentSession.createQuery(
			"update graduation.demo.pharmacymanagementsystem.entity.SupplyProduct AS s set remainedQuantity = remainedQuantity - :Quantity" 
			+ "where  s.id.productCode =: product_code and s.id.supplyId =: supply_id "
			+ "and s.id.companyId =: company_id",SupplyProduct.class);		
			
			theQuery.setParameter("Quantity",the_saved_product.getQuantity() );
			theQuery.setParameter("product_code", the_saved_product.getId().getProductCode());
			theQuery.setParameter("supply_id", the_saved_product.getId().getSupplyId());
			theQuery.setParameter("company_id", the_saved_product.getId().getCompanyId());
			 theQuery.executeUpdate();


			   }
				catch (Exception ex) {
				ex.printStackTrace();
			    }
		
	}*/


	
}

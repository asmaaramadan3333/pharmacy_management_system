package graduation.demo.pharmacymanagementsystem.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.BillsProduct;
import graduation.demo.pharmacymanagementsystem.entity.SupplyProduct;

@Repository
public class SupplyProductsDAOImpl implements SupplyProductsDAO {

	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public SupplyProductsDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void editSupplyQuantity(BillsProduct the_saved_product ,float quantity) {

		Map<String, Object> total_quantity = new HashMap<>();;
		Session currentSession =entityManager.unwrap(Session.class);
			
			try {
			@SuppressWarnings("unchecked")
			Query<SupplyProduct> theQuery =	currentSession.createQuery(

		
			"update SupplyProduct AS s set s.remainedQuantity = s.remainedQuantity - (:Quantity2)" 
			+ "where  s.id.productCode =: product_code2 and s.id.supplyId =: supply_id2 " 
			+ "and s.id.companyId =: company_id2");		
			
			
			
			theQuery.setParameter("Quantity2",quantity );
			theQuery.setParameter("product_code2", the_saved_product.getId().getProductCode());
			theQuery.setParameter("supply_id2", the_saved_product.getId().getSupplyId());
			theQuery.setParameter("company_id2", the_saved_product.getId().getCompanyId());
			 int result = theQuery.executeUpdate();
              

			   }
				catch (Exception ex) {
				ex.printStackTrace();
			    }
		
	}
	
	
	
	
	
	
}

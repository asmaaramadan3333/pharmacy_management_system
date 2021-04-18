package graduation.demo.pharmacymanagementsystem.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
@Repository
public class CustomersAddressDAOImpl implements CustomersAddressDAO {
	// define field for entity manager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public CustomersAddressDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	////////////////////// find address oc customer by the id of customer///////////
	@Override
	public CustomersAddress findCustomerAddressById(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the Customer
		CustomersAddress theCustomerAddress =
				currentSession.get(CustomersAddress.class, theCustomerId);
				
		// return the Customer
		return theCustomerAddress;
	}
 ////////////////////////////////add new address//////////////////
	@Override
	public void saveORupdate(CustomersAddress theCustomersAddress) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Customer
		currentSession.saveOrUpdate(theCustomersAddress);
		
	}
	////////////////////////delete address//////////////////////
	@Override
	public void deleteByCode(int theCustomersId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from CustomersAddress where customer_id=:Customerid");
		theQuery.setParameter("Customerid", theCustomersId);
				
		theQuery.executeUpdate();

		
	}
}

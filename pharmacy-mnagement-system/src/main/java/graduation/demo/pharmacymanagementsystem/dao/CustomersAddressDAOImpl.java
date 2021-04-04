package graduation.demo.pharmacymanagementsystem.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}

package graduation.demo.pharmacymanagementsystem.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
@Repository
public class CustomersPhoneDAOImpl implements CustomersPhoneDAO {
	// define field for entity manager	
	private EntityManager entityManager;
	// set up constructor injection
	@Autowired
	public CustomersPhoneDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	//////////////////////find phone oc customer by the id of customer///////////
	@Override
	public CustomersPhonePK findCustomerPhoneById(int theCustomerId)
	{

	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
		
	// get the Customer
	CustomersPhonePK theCustomerPhone =
		currentSession.get(CustomersPhonePK.class, theCustomerId);
		
	// return the Customer
	return theCustomerPhone;
	}

	@Override
	public void save(CustomersPhone theCustomersphone) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Customer
		currentSession.save(theCustomersphone);
		
	}
	///

	@Override
	public void deleteById(int theid) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key

		Query theQuery = currentSession.createQuery("delete from CustomersPhone where customer_id=:theId");
		theQuery.setParameter("theId", theid);

		theQuery.executeUpdate();

	}
}

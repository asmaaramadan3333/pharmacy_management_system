package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhonePK;
import graduation.demo.pharmacymanagementsystem.entity.Supply;
@Repository
public class CustomersPhoneDAOImpl implements CustomersPhoneDAO {
	// define field for entity manager	
	private EntityManager entityManager;
	// set up constructor injection
	@Autowired
	public CustomersPhoneDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	////////////////////// get customer phonessss by the id of customer///////////

	@Override
	public List<CustomersPhone> findCustomerPhoneById(int theCustomerId)
	{

	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
		
	// get the Customer
	//CustomersPhonePK theCustomerPhone = currentSession.get(CustomersPhonePK.class, theCustomerId);
	//CustomersPhone theCustomerPhone = currentSession.get(CustomersPhone.class, theCustomerId);
	Query theQuery = currentSession.createQuery("FROM CustomersPhone  WHERE id.customerId =: theCustomer_Id " , CustomersPhone.class);

	theQuery.setParameter("theCustomer_Id", theCustomerId);
	List<CustomersPhone> customer_phones = theQuery.getResultList();
	// return the Customer
	return customer_phones;
	}

	
	
	
	
	
	
	
	
	@Override
	public void save(CustomersPhone theCustomersphone) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Customer
		currentSession.save(theCustomersphone);
		
	}
	
///////////////////////////////////////////// delete by customer id and the phone number///////////
	
	@Override
	@org.springframework.transaction.annotation.Transactional
	public void deleteById(int thecustomerid,int thephone) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key

		Query theQuery = currentSession.createQuery("DELETE from CustomersPhone AS p  where p.id.customerId = : theId and " 
				+ " p.id.phoneNumber =: thephonen ");
		
		theQuery.setParameter("theId", thecustomerid);
		theQuery.setParameter("thephonen", thephone);

		theQuery.executeUpdate();

	}

	
	@org.springframework.transaction.annotation.Transactional
	@Override
	public void update(CustomersPhone theCustomersPhone,int CustomersPhone)
	{
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(theCustomersPhone);
		
		  Query<?> theQuery = currentSession.
		  createQuery(" update CustomersPhone c SET c.id.phoneNumber =: thePhoneNumber WHERE c.id.customerId =: theCustomer_Id and  " + 
		   "c.id.phoneNumber =: thePhoneold"); 
		  theQuery.setParameter("theCustomer_Id", theCustomersPhone.getId().getCustomerId());
		  theQuery.setParameter("thePhoneold", theCustomersPhone.getId().getPhoneNumber());
		  theQuery.setParameter("thePhoneNumber", CustomersPhone);
		  theQuery.executeUpdate();
		 
	}


}




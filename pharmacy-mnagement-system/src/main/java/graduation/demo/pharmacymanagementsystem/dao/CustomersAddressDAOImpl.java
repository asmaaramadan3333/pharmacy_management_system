package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
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
	public List<CustomersAddress> findCustomerAddressById(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		Query theQuery = currentSession.createQuery("FROM CustomersAddress  WHERE id.customerId =: theCustomer_Id " , CustomersAddress.class);

		theQuery.setParameter("theCustomer_Id", theCustomerId);
		List<CustomersAddress> customersAddress = theQuery.getResultList();
		// return the Customer
	
		return customersAddress;
	}
 ////////////////////////////////add new address//////////////////
	@Override
	public void saveORupdate(CustomersAddress theCustomersAddress) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Customer
		currentSession.saveOrUpdate(theCustomersAddress);
		
	}

	@Override
	public CustomersAddress findSpecificCustomerPhone(int customerId, String address) {
         Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Customer
		//CustomersPhonePK theCustomerPhone = currentSession.get(CustomersPhonePK.class, theCustomerId);
		//CustomersPhone theCustomerPhone = currentSession.get(CustomersPhone.class, theCustomerId);
		Query theQuery = currentSession.createQuery("FROM CustomersAddress  WHERE id.customerId =: theCustomer_Id and " + 
		 "id.address =: theaddress", CustomersAddress.class);

		theQuery.setParameter("theCustomer_Id", customerId);
		theQuery.setParameter("theaddress", address);
		
		if (theQuery.getResultList() != null && !theQuery.getResultList().isEmpty()) {

			CustomersAddress theCustomersAddress = (CustomersAddress) theQuery.getResultList().get(0);
		
		// return the Customer
		return theCustomersAddress;
		}
		else
			return null;
	}
		///////////////////////////////////////////// delete by customer id and the phone number///////////
			
		
		@Override
		@org.springframework.transaction.annotation.Transactional
		public void deleteById(int thecustomerid,String  address) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("DELETE from CustomersAddress AS a  where a.id.customerId = : theId and " 
		+ " a.id.address =: theaddress ");
		
		theQuery.setParameter("theId", thecustomerid);
		theQuery.setParameter("theaddress", address);
		
		theQuery.executeUpdate();
		
		}
		@org.springframework.transaction.annotation.Transactional
		@Override
		public void update(CustomersAddress theCustomersAddress,String theCustomerAdressnew)
		{
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			//currentSession.update(theCustomersAddress);
			
			  Query<?> theQuery = currentSession.
			  createQuery(" update CustomersAddress c SET c.id.address =: theaddressnew WHERE c.id.customerId =: theCustomer_Id and  " + 
			   "c.id.address =: theaddressold"); 
			  theQuery.setParameter("theCustomer_Id", theCustomersAddress.getId().getCustomerId());
			  theQuery.setParameter("theaddressold", theCustomersAddress.getId().getAddress());
			  theQuery.setParameter("theaddressnew", theCustomerAdressnew);
			  theQuery.executeUpdate();
			 
		}

		
}

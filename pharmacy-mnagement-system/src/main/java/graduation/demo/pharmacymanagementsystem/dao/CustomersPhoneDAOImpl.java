package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersAddress;
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

	//////////////////////find phone oc customer by the id of customer///////////
	
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
	public CustomersPhone findSpecificCustomerPhone(int customerId, int phone) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Customer
		//CustomersPhonePK theCustomerPhone = currentSession.get(CustomersPhonePK.class, theCustomerId);
		//CustomersPhone theCustomerPhone = currentSession.get(CustomersPhone.class, theCustomerId);
		Query theQuery = currentSession.createQuery("FROM CustomersPhone  WHERE id.customerId =: theCustomer_Id and " + 
		 "id.phoneNumber =: thephonen", CustomersPhone.class);

		theQuery.setParameter("theCustomer_Id", customerId);
		theQuery.setParameter("thephonen", phone);
		
		if (theQuery.getResultList() != null && !theQuery.getResultList().isEmpty()) {

		CustomersPhone thecustomer_phones = (CustomersPhone) theQuery.getResultList().get(0);
		
		// return the Customer
		return thecustomer_phones;
		}
		else
			return null;
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


	
	
	/*
	 * @Override public void save(CustomersPhone theCustomersphone) {
	 * 
	 * // get the current hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // save Customer currentSession.save(theCustomersphone);
	 * 
	 * } ///
	 * 
	 * @Override public void deleteById(int theid,int thecustomerphone) { // get the
	 * current hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // delete object with primary key
	 * 
	 * Query theQuery = currentSession.
	 * createQuery("delete from CustomersPhonePK where customer_id=:theId and ,int customerphone:=customerphone"
	 * ); theQuery.setParameter("theId", theid);
	 * theQuery.setParameter("customerphone",thecustomerphone);
	 * 
	 * theQuery.executeUpdate();
	 * 
	 * }
	 * 
	 * @Override public void saveORupdateCustomerPhone(CustomersPhone
	 * theCustomersPhone) { // TODO Auto-generated method stub // get the current
	 * hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // save Customer currentSession.saveOrUpdate(theCustomersPhone); } public
	 * CustomersPhone findCustomerPhoneByCustomrId(int theCustomerId,int
	 * CustomerPhone) {
	 * 
	 * // get the current hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // get the Customer Query theQuery=currentSession.
	 * createQuery("FROM CustomersPhone WHERE id.customerId =:theCustomer_Id and id.phoneNumber =: theCustomerPhone"
	 * ,CustomersPhone.class); theQuery.setParameter("theCustomer_Id",
	 * theCustomerId); theQuery.setParameter("theCustomerPhone", CustomerPhone);
	 * CustomersPhone
	 * theCustomerPhone=(CustomersPhone)theQuery.getResultList().get(0) ;
	 * //currentSession.get(CustomersPhone.class,theCustomerId,phoneNumber); //
	 * return the Customer return theCustomerPhone; }
	 * 
	 * @Override public Customer findByCode(int theCustomerId) { // get the current
	 * hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // get the Customer Customer theCustomer = currentSession.get(Customer.class,
	 * theCustomerId);
	 * 
	 * // return the Customer return theCustomer; }
	 * 
	 * 
	 * 
	 * @Override public void saveORupdate(Customer theCustomer) { // get the current
	 * hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class);
	 * 
	 * // save Customer currentSession.saveOrUpdate(theCustomer); }
	 */
	
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

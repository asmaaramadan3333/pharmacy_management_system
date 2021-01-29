package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class CustomersDAOImpl implements CustomersDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public CustomersDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List<Customer> findAllCustomers() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
				
		// execute query and get result list
		List <Customer> Customer = theQuery.getResultList();
				
		// return the results		
		return Customer;
	}

	@Override
	public Customer findByCode(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the Customer
		Customer theCustomer =
				currentSession.get(Customer.class, theCustomerId);
				
		// return the Customer
		return theCustomer;
	}

	
	@Override
	public void saveORupdate(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Customer
		currentSession.saveOrUpdate(theCustomer);
		
	}
	
	
	@Override
	public List<Customer> searchByName(String theCustomerName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM Customer  WHERE name like :CustomerName", Customer.class );
		
		theQuery.setParameter("CustomerName", theCustomerName+ "%");
		
		
		List <Customer> Customers = theQuery.getResultList();
		
		// return the results		
		return Customers;
	}


	@Override
	public Customer getCustomerByEmail(String theemail) {
		
		Customer thecustomer = null;
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		try {
		// search object with name
		Query  theQuery = 
				currentSession.createQuery(
						"FROM Customer c  WHERE c.email =: mail", Customer.class );
		
		theQuery.setParameter("mail", theemail);
		
		/*
		 * if(theQuery.getSingleResult() != null) {
		 * 
		 * thecustomer = (Customer) theQuery.getSingleResult();
		 * System.out.println(">>>>>>>>.. "+thecustomer); }
		 */
		if(!theQuery.getResultList().isEmpty())
		{
			thecustomer=(Customer) theQuery.getResultList().get(0);
		}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return thecustomer;
		
		//}
		
	    //System.out.println(">>>>>>>>.. "+thecustomer);

			
		//return thecustomer;

	}
	
	
	
	@Override
	public Customer signIn(String theemail,String thepassword) {
		
		Customer thecustomer = null;
		try {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
		"FROM Customer c  WHERE c.email = :mail AND c.password = :pass", Customer.class );
		
		theQuery.setParameter("mail", theemail);
		
		theQuery.setParameter("pass",  thepassword );
		
		//if(theQuery.getSingleResult() != null) {
		if(theQuery.getResultList()!=null&&!theQuery.getResultList().isEmpty()) {
		
			thecustomer = (Customer) theQuery.getResultList().get(0);
		
		
		}}
		catch(NoResultException  ex)
		{
			ex.printStackTrace();
		}
		
		return thecustomer;
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void deleteByCode(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from Customer where code=:Customerid");
		theQuery.setParameter("Customerid", theCustomerId);
				
		theQuery.executeUpdate();

		
	}

	
	
	
	
	
}

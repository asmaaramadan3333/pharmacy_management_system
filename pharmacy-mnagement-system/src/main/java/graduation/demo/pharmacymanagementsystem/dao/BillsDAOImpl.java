package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;

@Repository
public class BillsDAOImpl implements BillsDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public BillsDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List<Bill> findAllBills() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Bill> theQuery =
				currentSession.createQuery("from Bill", Bill.class);
				
		// execute query and get result list
		List <Bill> Bill = theQuery.getResultList();
				
		// return the results		
		return Bill;
	}

	@Override
	public Bill findByBillID(long thebill_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the Bill
		Bill theBill =
				currentSession.get(Bill.class, thebill_id);
				
		// return the Bill
		return theBill;
	}
	

	@Override
	@Transactional
	public void save(Bill theBill) {
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
	
	
		currentSession.save(theBill);
	    currentSession.flush();
		//currentSession.getTransaction().commit();
		
	}
	
	
	
	@Override
	@Transactional
	public void saveORupdate(Bill theBill) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Bill
		currentSession.saveOrUpdate(theBill);
		
	}

	
	@Override
	public List<Bill> findCustomerBillsById(int theCustomerId)
	{

	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
		
	
	//Query theQuery = currentSession.createQuery("FROM Bill WHERE customerId =: theCustomer_Id " , Bill.class);

	Query theQuery = currentSession.createQuery("FROM Bill WHERE customer.customerId =: theCustomer_Id " , Bill.class);
	
	theQuery.setParameter("theCustomer_Id", theCustomerId);
		
	List<Bill> customer_bills = theQuery.getResultList();
	// return the Customer
	return customer_bills;
	}
	
	
	
	/*@Override
	public List<Bill> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM Bills  WHERE name like :BillName", Bill.class );
		
		theQuery.setParameter("BillName", theName+ "%");
		
		
		List <Bill> Bills = theQuery.getResultList();
		
		// return the results		
		return Bills;
	}*/

	@Override
	public void deleteByBillID(int thebill_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from Bill where code=:billId");
		theQuery.setParameter("billId", thebill_id);
				
		theQuery.executeUpdate();

		
	}

	
	
	
	
	
}

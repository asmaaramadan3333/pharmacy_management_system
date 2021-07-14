package graduation.demo.pharmacymanagementsystem.dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.Customer;
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
	public List<Bill> find_product_while_aperiod(Date replyTime1,Date replyTime2){
		
		List<Bill> Bill_list = new ArrayList<Bill>();
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			
		// create a query
		Query<Bill> theQuery = currentSession.createQuery("from Bill b where b.billState = 'done' and  b.replyTime between :reply1  and  :reply2 ", Bill.class);
 
		theQuery.setParameter("reply1", replyTime1);
		theQuery.setParameter("reply2", replyTime2);

		if (!theQuery.getResultList().isEmpty()) {
			 Bill_list = theQuery.getResultList();
		}

	    } 
		catch (Exception ex) {
		ex.printStackTrace();
	     }
	     return Bill_list;
		
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
	
	
	//@org.springframework.transaction.annotation.Transactional
	@Transactional
	@Override
	public void saveORupdate(Bill theBill) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save Bill
		//currentSession.saveOrUpdate(theBill);
		currentSession.saveOrUpdate(theBill);
		//currentSession.flush();
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


	@Override
	public List<Bill> find_filteredBills(Long billId1, String billType1, String billState1, String replyTime1) {
		List<Bill> bills_list = new ArrayList<Bill>();
		Session currentSession = entityManager.unwrap(Session.class);	
		if (replyTime1 !=null) {				
		replyTime1 = replyTime1.replaceAll("\\s","");
		String replyTime2 = replyTime1.concat(" 00:00:00");
		String replyTime3 = replyTime1.concat(" 23:59:59");
		
		Timestamp replyTime4 = Timestamp.valueOf(replyTime2);
		Timestamp replyTime5 = Timestamp.valueOf(replyTime3);								
		System.out.println(replyTime4);System.out.println(replyTime5);	
		try {
			
			
		Query<Bill> theQuery = currentSession.createQuery("FROM Bill b WHERE b.billId = COALESCE(:bill_id, billId)"
				+ "and b.billType = COALESCE (:bill_type,billType) and b.billState = COALESCE (:bill_state , billState)"
				+ "and b.replyTime  between :reply_time1 and :reply_time2  ", Bill.class);
		
		theQuery.setParameter("bill_id", billId1);
		theQuery.setParameter("bill_type",billType1);
		theQuery.setParameter("bill_state",billState1);
		theQuery.setParameter("reply_time1",replyTime4 );
		theQuery.setParameter("reply_time2",replyTime5 );
			
		
		if (!theQuery.getResultList().isEmpty()) {
			bills_list = theQuery.getResultList();
		}

	   } 
		catch (Exception ex) {
		ex.printStackTrace();
	    }
		}
		else {
			
			try {
								
				Query<Bill> theQuery = currentSession.createQuery("FROM Bill b WHERE b.billId = COALESCE(:bill_id, billId)"
						+ "and b.billType = COALESCE (:bill_type,billType) and b.billState = COALESCE (:bill_state , billState)"
						, Bill.class);
				
				theQuery.setParameter("bill_id", billId1);
				theQuery.setParameter("bill_type",billType1);
				theQuery.setParameter("bill_state",billState1);
			
				
				if (!theQuery.getResultList().isEmpty()) {
					bills_list = theQuery.getResultList();
				}

			   } 
				catch (Exception ex) {
				ex.printStackTrace();
			    }
				}

			
		
		return bills_list;
	}


	@Override
	public List<Bill> findEveryBillBymonth(Date replyTime4,Date replyTime5) {
		// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			GregorianCalendar cal = new GregorianCalendar();
			cal.set(GregorianCalendar.YEAR, 2004);
			cal.set(GregorianCalendar.MONTH, 2);
			cal.set(GregorianCalendar.DATE, 12);
			         
			Timestamp ts = new Timestamp(cal.getTime().getTime());
			System.out.println(ts);
			System.out.println("done");
			/*
			 * String theactualmonth ="0"+Integer.toString(month);
			 * System.out.println(theactualmonth); LocalDate date =
			 * LocalDate.parse(theactualmonth); System.out.println(date);
			 */	/*
					 * currentSession.createQuery(
					 * "select sum(totalPrice) and month(replayTime) from  Bill b where year(b.replayTime) =: theyear and Bill.status='done' "
					 * );
					 */
			Query theQuery = 
				
			currentSession.createQuery(
			"select sum(totalPrice) from  Bill b where b.billState='done' " + " and b.replyTime between :reply1 and :reply2 " , Bill.class);
			
				theQuery.setParameter("reply1", replyTime4);
	
				theQuery.setParameter("reply2",replyTime5);
				List <Bill> Bill= theQuery.getResultList();
		return Bill;
	}		

	@Override
	public List<Bill> findEveryBillBymonthAndTotalPrice(int year,int month) {
		Session currentSession = entityManager.unwrap(Session.class);
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.YEAR, year);
		cal.set(GregorianCalendar.MONTH, month);
		System.out.println(cal);
		
        java.sql.Date   beginDate=java.sql.Date.valueOf("2021-5-1");
        java.sql.Date   endDate=java.sql.Date.valueOf("2021-5-30");
		Query theQuery =currentSession.createQuery("select sum(totalPrice) from  Bill b where b.billState='done' " 
		+ " and b.replyTime between :reply1 and :reply2 " , Bill.class);
		theQuery.setParameter("reply1", beginDate);
		theQuery.setParameter("reply1", endDate);
		return null;
	}
}

	

	
	
	


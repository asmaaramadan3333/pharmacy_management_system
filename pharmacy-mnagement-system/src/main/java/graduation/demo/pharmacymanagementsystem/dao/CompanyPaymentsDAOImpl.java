package graduation.demo.pharmacymanagementsystem.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity. CompanyPayment;

@Repository
public class CompanyPaymentsDAOImpl implements CompanyPaymentsDAO {

	// define field for entity manager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public CompanyPaymentsDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
	
	@Override
	public List< CompanyPayment> findAllCompanyPayments() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query< CompanyPayment> theQuery =
				currentSession.createQuery("from  CompanyPayment",  CompanyPayment.class);
				
		// execute query and get result list
		List < CompanyPayment>  CompanyPayment = theQuery.getResultList();
				
		// return the results		
		return  CompanyPayment;
	}
/*
	@Override
	public  CompanyPayment findByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the  CompanyPayment
		 CompanyPayment the CompanyPayment =
				currentSession.get( CompanyPayment.class, theCode);
				
		// return the  CompanyPayment
		return the CompanyPayment;
	}
*/
	
	@Override
	public void saveORupdate( CompanyPayment theCompanyPayment) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save  CompanyPayment
		currentSession.saveOrUpdate(theCompanyPayment);
		
	}


	@Override
	public List<CompanyPayment> find_filteredCompanyPayments(Integer companyId1, Date start_date1, Date end_date1) {
		List<CompanyPayment> companypayment_list = new ArrayList<CompanyPayment>();
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {


		Query<CompanyPayment> theQuery = currentSession.createQuery(
				"FROM CompanyPayment c WHERE c.companyId = COALESCE(:companyId2, companyId)" 
				
				+ "and c.timing  between COALESCE(:start_date2,timing) and COALESCE(:end_date2,timing )", CompanyPayment.class);

		theQuery.setParameter("companyId2", companyId1);
		theQuery.setParameter("start_date2",start_date1);
		theQuery.setParameter("end_date2",end_date1);
	

		if (!theQuery.getResultList().isEmpty()) {
			companypayment_list = theQuery.getResultList();
		}

	   }
		catch (Exception ex) {
		ex.printStackTrace();
	    }
		
		


		return companypayment_list;
	}
		
	
	
/*	
	@Override
	public List< CompanyPayment> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
						"FROM  CompanyPayments  WHERE name like : CompanyPaymentName",  CompanyPayment.class );
		
		theQuery.setParameter(" CompanyPaymentName", theName+ "%");
		
		
		List < CompanyPayment>  CompanyPayments = theQuery.getResultList();
		
		// return the results		
		return  CompanyPayments;
	}

	@Override
	public void deleteByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from  CompanyPayments where code=: CompanyPaymentCode");
		theQuery.setParameter(" CompanyPaymentCode", theCode);
				
		theQuery.executeUpdate();

		
	}
*/
	
	
	
	
	
}

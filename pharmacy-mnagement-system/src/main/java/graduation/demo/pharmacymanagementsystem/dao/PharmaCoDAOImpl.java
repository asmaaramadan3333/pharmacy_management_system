package graduation.demo.pharmacymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.entity.SupplyProduct;

@Repository
public class PharmaCoDAOImpl implements PharmaCoDAO {
	// define field for entity manager	
	private EntityManager entityManager;
			
		// set up constructor injection
	@Autowired
	public PharmaCoDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
	
	
	@Override
	public List<PharmaCo> findAllPharmaCo() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<PharmaCo> theQuery = currentSession.createQuery("from PharmaCo", PharmaCo.class);
				
		// execute query and get result list
		List <PharmaCo> PharmaCoList = theQuery.getResultList();
				
		// return the results		
		return PharmaCoList;
	}
	
	
	
	@Override
	public List<PharmaCo> searchCompanyByCompanyName(String thecompanyname) {
        
			
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// search object with name
			Query  theQuery = 
					currentSession.createQuery(
							"FROM PharmaCo p  WHERE p.name like : thename", PharmaCo.class );
			
			theQuery.setParameter("thename", thecompanyname + "%",StringNVarcharType.INSTANCE);
			
			List<PharmaCo> thePharmaCoList = theQuery.getResultList();
			
			
			return thePharmaCoList ;
		}
	@Override
	public List<PharmaCo> findallcomplanyName() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<PharmaCo> theQuery =
				currentSession.createQuery("SELECT name FROM PharmaCo");
		List<PharmaCo>  pharmaco= theQuery.getResultList();
		return pharmaco;
	}


	@Transactional
	@Override
	public void save(PharmaCo new_PharmaCo) {

		Session currentSession = entityManager.unwrap(Session.class);
		// save PharmaCo
		currentSession.save(new_PharmaCo);
		currentSession.flush();
	}


	public PharmaCo findByPharmaCoId(int thePharmaCo_id)
	{
		Session currentSession = entityManager.unwrap(Session.class);

		PharmaCo thePharmaCo =
				currentSession.get(PharmaCo.class, thePharmaCo_id);

		// return the Bill
		return thePharmaCo;
	}
	
	private Date editcompanydate (Date companydate ,int paymentIntervals) {
		if(companydate!=null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(companydate);
          //  int duration = getSysPramDueDate("dueDate.allocation");
            cal.add(Calendar.MONTH, paymentIntervals);
            Date dueDate = cal.getTime();
            return dueDate;
        }
		else return null;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void update_balance_futurepayment(CompanyPayment theCompanyPayment) {

		PharmaCo thePharmaCo = findByPharmaCoId(theCompanyPayment.getCompanyId());
		
		int paymentIntervals = thePharmaCo.getPaymentInterval();
		   System.out.println("theCompanyPayment.getTiming() before edit" +theCompanyPayment.getTiming());

		  Date time3 = editcompanydate (theCompanyPayment.getTiming(),paymentIntervals);
		//  System.out.println("theCompanyPayment.getTiming() after edit"+theCompanyPayment.getTiming());
	      //System.out.println("time3" + time3);
	     	Session currentSession = entityManager.unwrap(Session.class);
		try {
			@SuppressWarnings("unchecked")
			Query<SupplyProduct> theQuery =	currentSession.createQuery(

		
			"update PharmaCo AS p set p.balance = p.balance - (:Payment2) ," 
			+ " p.paymentFutureDate = (:timing2)" + 
			 " where  p.id = :companyid2 "); 
			
			theQuery.setParameter("Payment2",theCompanyPayment.getPayment() );
			theQuery.setParameter("timing2",time3 );
			theQuery.setParameter("companyid2", theCompanyPayment.getCompanyId());
			int result = theQuery.executeUpdate();
              

			   }
				catch (Exception ex) {
				ex.printStackTrace();
			    }
		
	}

	
	
	
	
	

	/*
	 * /////////////////////////////////////////////////////////////////product
	 * id/////////////////////////
	 * 
	 * @Override public Product get_code(String name,String type,int size) { Product
	 * theProduct = null; // get the current hibernate session Session
	 * currentSession = entityManager.unwrap(Session.class); // search object with
	 * name Query theQuery = currentSession.createQuery(
	 * "FROM Product p  WHERE p.name =: thename AND p.size =: thesize AND p.type =: thetype"
	 * , PharmaCo.class ); theQuery.setParameter("thename", name);
	 * theQuery.setParameter("thesize", type); theQuery.setParameter("thetype",
	 * size); theProduct=(Product) theQuery.getResultList().get(0); return
	 * theProduct; } //////////////////////////////////////////////employee
	 * id////////////////////////////////////////
	 * 
	 * @Override public Employee getEmployeeByname(String name) {
	 * 
	 * Employee theemployee = null;
	 * 
	 * // get the current hibernate session Session currentSession =
	 * entityManager.unwrap(Session.class); try { // search object with name Query
	 * theQuery = currentSession.createQuery(
	 * "FROM Employee c  WHERE c.name =: thename", Employee.class );
	 * 
	 * theQuery.setParameter("thename", name);
	 * 
	 * if(!theQuery.getResultList().isEmpty()) { theemployee=(Employee)
	 * theQuery.getResultList().get(0); }
	 * 
	 * } catch(Exception ex) { ex.printStackTrace(); } return theemployee; }
	 */
}

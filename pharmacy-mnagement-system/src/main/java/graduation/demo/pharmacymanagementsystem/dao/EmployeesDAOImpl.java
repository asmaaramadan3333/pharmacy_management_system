package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
@Repository
public class EmployeesDAOImpl implements EmployeesDAO {
	// define field for entity manager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeesDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Employee> findAllEmployee() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
				
		// execute query and get result list
		List <Employee> Employee = theQuery.getResultList();
				
		// return the results		
		return Employee;
	}
	@Override
	public Employee signIn(String theusername, String thepassword) {
		Employee theemployee = null;
		try {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// search object with name
		Query theQuery = 
				currentSession.createQuery(
		"FROM Employee c  WHERE c.username = :theuser AND c.password = :pass", Employee.class );
		
		theQuery.setParameter("theuser", theusername);
		
		theQuery.setParameter("pass",  thepassword );
		
		//if(theQuery.getSingleResult() != null) {
		if(theQuery.getResultList()!=null&&!theQuery.getResultList().isEmpty()) {
		
			theemployee  = (Employee) theQuery.getResultList().get(0);
		
		
		}}
		catch(NoResultException  ex)
		{
			ex.printStackTrace();
		}
		
		return theemployee ;
	}
	@Override
	public Employee getEmployeeByUsername(String theusername) {
		
		Employee theemployee = null;
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		try {
		// search object with name
		Query  theQuery = 
				currentSession.createQuery(
						"FROM Employee c  WHERE c.username =: theuser", Employee.class );
		
		theQuery.setParameter("theuser", theusername);
		
		if(!theQuery.getResultList().isEmpty())
		{
			theemployee=(Employee) theQuery.getResultList().get(0);
		}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return theemployee;
	}
	@Override
	public Employee getEmployeeByname(String name) {
		
		Employee theemployee = null;
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		try {
		// search object with name
		Query  theQuery = 
				currentSession.createQuery(
						"FROM Employee c  WHERE c.name =: thename", Employee.class );
		
		theQuery.setParameter("thename", name);
		
		if(!theQuery.getResultList().isEmpty())
		{
			theemployee=(Employee) theQuery.getResultList().get(0);
		}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return theemployee;
	}
	@Override
	public String restoreThePassword(String the_username) {
			
			//Employee theemployee = null;
		Employee theemployee=null;
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			try {
			// search object with name
			Query  theQuery = 
					currentSession.createQuery(
							"FROM Employee e  WHERE e.email =: mail",Employee.class );
			
			theQuery.setParameter("mail", the_username);
			
			if(!theQuery.getResultList().isEmpty())
			{
				 theemployee=(Employee) theQuery.getResultList().get(0);
			}
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return theemployee.getEmail();	

		}
//////////////////////////////////////////add new employee  ////////////////////////////
	@Override
	public void saveORupdate(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//currentSession.persist(theEmployee);
		// save Customer
		currentSession.saveOrUpdate(theEmployee);
		//currentSession.save( theEmployee);
		currentSession.flush();
	}
		
}

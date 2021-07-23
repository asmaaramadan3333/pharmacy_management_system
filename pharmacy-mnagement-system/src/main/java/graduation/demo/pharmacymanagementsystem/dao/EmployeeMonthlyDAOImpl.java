package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthlyPK;

@Repository
public class EmployeeMonthlyDAOImpl implements EmployeeMonthlyDAO {
	// define field for entity manager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeeMonthlyDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Employee> getallEmployeeWithStatusZero() 
	{ 
		Session currentSession = entityManager.unwrap(Session.class);
		Query <Employee> theQuery = 
				currentSession.createQuery(
						" FROM Employee e  WHERE e.status =: thestate ", Employee.class );
		theQuery.setParameter("thestate", "0");
		System.out.println("done");
		List<Employee> Employee = theQuery.getResultList();
		return Employee;
			}
	@Override
	public int getMonthlyHolidayes(int employeeId, String month) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query <EmployeesMonthly> theQuery = 
		currentSession.createQuery( " FROM EmployeesMonthly WHERE id.employeeId =: theEmployee_Id and " 
						+  "id.month =: themonth", EmployeesMonthly.class );
		theQuery.setParameter("theEmployee_Id", employeeId);
		theQuery.setParameter("themonth", month);
		System.out.println("before");
		if(!theQuery.getResultList().isEmpty()) {
		EmployeesMonthly  EmployeesMonthly =theQuery.getResultList().get(0);
		System.out.println(EmployeesMonthly);
		return EmployeesMonthly.getMonthlyHolidays();
		}
		else {
			
		return 00;
		}
	}
	@Override
	public EmployeesMonthly get_byid(EmployeesMonthlyPK theid) {
		Session currentSession = entityManager.unwrap(Session.class);

		EmployeesMonthly theEmployeesMonthly =
				currentSession.get(EmployeesMonthly.class, theid);

	
		return theEmployeesMonthly;
	
	}
	@Override
	@Transactional
	public void saveOrUpdate(EmployeesMonthly theemployeesMonthly) {
		Session currentSession = entityManager.unwrap(Session.class);
		//theemployeesMonthly.setId(theemployeesMonthly.getId());
		currentSession.saveOrUpdate(theemployeesMonthly);
		currentSession.flush();		
	}

}

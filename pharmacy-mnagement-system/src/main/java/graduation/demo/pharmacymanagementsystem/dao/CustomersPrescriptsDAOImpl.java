package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPrescript;

@Repository
public class CustomersPrescriptsDAOImpl implements CustomersPrescriptsDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public CustomersPrescriptsDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<CustomersPrescript> findAllCustomersPrescripts() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<CustomersPrescript> theQuery = currentSession.createQuery("from CustomersPrescript",
				CustomersPrescript.class);

		// execute query and get result list
		List<CustomersPrescript> CustomersPrescript = theQuery.getResultList();

		// return the results
		return CustomersPrescript;
	}

	@Override
	public CustomersPrescript findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the CustomersPrescript
		CustomersPrescript theCustomersPrescript = currentSession.get(CustomersPrescript.class, theId);

		// return the CustomersPrescript
		return theCustomersPrescript;
	}

	@Override
	public void saveORupdate(CustomersPrescript theCustomersPrescript) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save CustomersPrescript
		currentSession.saveOrUpdate(theCustomersPrescript);

	}

	@Override
	public CustomersPrescript searchByurl(String theurl) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query<CustomersPrescript> theQuery = currentSession
				.createQuery("FROM CustomersPrescript  WHERE url = :CustomersPrescripturl", CustomersPrescript.class);

		theQuery.setParameter("CustomersPrescripturl", theurl);

		if (!theQuery.getResultList().isEmpty()) {
			return theQuery.getResultList().get(0);
		} else
			// return the results
			return null;
	}

	@Override
	public List<CustomersPrescript> findByCustomerId(int customerId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<CustomersPrescript> theQuery = currentSession
				.createQuery("FROM CustomersPrescript  WHERE customerId = :Customer_ID", CustomersPrescript.class);

		theQuery.setParameter("Customer_ID", customerId);

		if (!theQuery.getResultList().isEmpty()) {
			return theQuery.getResultList();
		} else
			// return the results
			return null;
	}

	@Override
	public void deleteByCode(int theCode) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key

		Query theQuery = currentSession
				.createQuery("delete from CustomersPrescript where code=:CustomersPrescriptCode");
		theQuery.setParameter("CustomersPrescriptCode", theCode);

		theQuery.executeUpdate();

	}

}

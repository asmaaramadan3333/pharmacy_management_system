package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Customer;
import graduation.demo.pharmacymanagementsystem.entity.CustomersPhone;
import graduation.demo.pharmacymanagementsystem.entity.Product;

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
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> Customer_list = theQuery.getResultList();

		// return the results
		return Customer_list;
	}
	
	@Override
	public List<Customer> findpaidCustomers() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer o where o.credit = 0  or o.credit < 0 ", Customer.class);

		// execute query and get result list
		List<Customer> Customer_list = theQuery.getResultList();

		// return the results
		return Customer_list ;
	}

	@Override
	public List<Customer> findcredit_addedCustomers() {
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer o where o.credit > 0 ", Customer.class);

		// execute query and get result list
		List<Customer> Customer_list = theQuery.getResultList();

		// return the results
		return Customer_list ;
	}

	
	@Override
	public Customer findByCode(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Customer
		Customer theCustomer = currentSession.get(Customer.class, theCustomerId);

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
	public Customer saveandreturncustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);			

		// save Customer
		currentSession.save(theCustomer);
		String customeremail=theCustomer.getEmail();
		System.out.println(customeremail);
		Customer theCustomer1=getCustomerByEmail(customeremail);
		System.out.println(theCustomer1);
		return theCustomer1;

	}

	@Override
	public List<Customer> searchByName(String theCustomerName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// search object with name
		Query<Customer> theQuery = currentSession.createQuery("FROM Customer c WHERE c.firstName like :CustomerName",
				Customer.class);

		theQuery.setParameter("CustomerName", theCustomerName + "%");

		List<Customer> Customers = theQuery.getResultList();

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
			Query<Customer> theQuery = currentSession.createQuery("FROM Customer c  WHERE c.email =: mail",
					Customer.class);

			theQuery.setParameter("mail", theemail);

			if (!theQuery.getResultList().isEmpty()) {
				thecustomer = (Customer) theQuery.getResultList().get(0);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return thecustomer;
	}

	@Override
	public Customer signIn(String theemail, String thepassword) {

		Customer thecustomer = null;
		try {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);

			// search object with name

			Query<Customer> theQuery = currentSession
					.createQuery("FROM Customer c  WHERE c.email = :mail AND c.password = :pass", Customer.class);

			theQuery.setParameter("mail", theemail);

			theQuery.setParameter("pass", thepassword);

			// if(theQuery.getSingleResult() != null) {
			if (theQuery.getResultList() != null && !theQuery.getResultList().isEmpty()) {

				thecustomer = (Customer) theQuery.getResultList().get(0);

			}
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}

		return thecustomer;

	}

	@Override
	public void add_products_to_customer(int theCustomerId, int theproductCode) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer theCustomer = findByCode(theCustomerId);

		Product theProduct = currentSession.get(Product.class, theproductCode);

		theCustomer.add(theProduct);

		currentSession.saveOrUpdate(theProduct);

		currentSession.saveOrUpdate(theCustomer);

	}
	////////////////dao////////////////
	@Override
	public void add_Phones_to_customer( CustomersPhone Custmersphone) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer theCustomer =findByCode(Custmersphone.getId().getCustomerId());


		//theCustomer.add2(Custmersphone);

		//currentSession.saveOrUpdate(Custmersphone);

		//currentSession.saveOrUpdate(theCustomer);
		CustomersPhone customerPhone1 = new CustomersPhone();
		customerPhone1.setIdParam(Custmersphone.getId().getCustomerId(), Custmersphone.getId().getPhoneNumber());

		currentSession.saveOrUpdate(customerPhone1);
	}


	@Override
	public void deleteByCode(int theCustomerId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key

		Query theQuery = currentSession.createQuery("delete from Customer  where code =: Customerid");
		theQuery.setParameter("Customerid", theCustomerId);

		theQuery.executeUpdate();

	}

	public CustomersPhone findCustomerPhoneByCustomrId(int theCustomerId, int customerphone) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Customer
		Query theQuery = currentSession.createQuery(" FROM CustomersPhone WHERE id.customerId =:theCustomer_Id and "
				+ " id.phoneNumber =: thecustomerphone ", CustomersPhone.class);
		theQuery.setParameter("theCustomer_Id", theCustomerId);
		theQuery.setParameter("thecustomerphone", customerphone);
		CustomersPhone theCustomerPhone = (CustomersPhone) theQuery.getResultList().get(0);
		// currentSession.get(CustomersPhone.class,theCustomerId,phoneNumber);


		// return the Customer
		return theCustomerPhone;
	}


	@org.springframework.transaction.annotation.Transactional
	@Override
	public void updatePassword(int customerId, String newPassword) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<?> theQuery = currentSession
				.createQuery(" update Customer c SET c.password =: thePassword  WHERE c.customerId =: theCustomer_Id ");
		theQuery.setParameter("theCustomer_Id", customerId);
		theQuery.setParameter("thePassword", newPassword);
		theQuery.executeUpdate();

	}





}
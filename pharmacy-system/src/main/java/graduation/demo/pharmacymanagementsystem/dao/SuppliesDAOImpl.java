package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.Supply;
import graduation.demo.pharmacymanagementsystem.entity.SupplyPK;

@Repository
public class SuppliesDAOImpl implements SuppliesDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public SuppliesDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Supply> findAllSupplies() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Supply> theQuery = currentSession.createQuery("from Supply", Supply.class);

		// execute query and get result list
		List<Supply> supply = theQuery.getResultList();

		// return the results
		return supply;
	}
/////////////////////////////////////// edit this func return value
	@Override
	public Supply findBybill_id(int supply_bill_id) {
		// get the current hibernate session
		Supply thesupply = null;
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Supply
		// Supply theSupply =
		// currentSession.get(Supply.class, supply_bill_id);
		Query theQuery = currentSession.createQuery("FROM Supply  WHERE id = :id", Supply.class);

		theQuery.setParameter("id", supply_bill_id);

		List<Supply> Supplies = theQuery.getResultList();
         
		// return the results
		return thesupply;
	}

	@Override
	public List <Supply> findBillTotalPrice(int supply_bill_id,int CompanyID) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("FROM Supply  WHERE id.companyId = : CompanyId and "
				+ "id.supplyBillId =: supply_billId ", Supply.class);

		theQuery.setParameter("supply_billId", supply_bill_id);
		theQuery.setParameter("CompanyId", CompanyID);

		List<Supply> Supplies = theQuery.getResultList();
			
		return Supplies;

	}

	@Override
	public void save(Supply theSupply) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save Supply
		currentSession.save(theSupply);

	}

/*	@Override
	public List<Supply> searchByName(String theName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// search object with name
		Query theQuery = currentSession.createQuery("FROM Supply  WHERE name like :SupplyName", Supply.class);

		theQuery.setParameter("SupplyName", theName + "%");

		List<Supply> Supplies = theQuery.getResultList();

		// return the results
		return Supplies;
	}*/

	@Override
	public void deleteById(int theID) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key

		Query theQuery = currentSession.createQuery("delete from Supply where id=:id");
		theQuery.setParameter("id", theID);

		theQuery.executeUpdate();

	}

}

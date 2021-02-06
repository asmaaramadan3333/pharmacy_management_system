package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;

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
	public PharmaCo getCompanyByCompanyName(String thecompanyname) {


		    PharmaCo thePharmaCo = null;
			
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			try {
			// search object with name
			Query  theQuery = 
					currentSession.createQuery(
							"FROM PharmaCo p  WHERE p.name =: thename", PharmaCo.class );
			
			theQuery.setParameter("thename", thecompanyname);
			
			if(!theQuery.getResultList().isEmpty())
			{
				thePharmaCo =(PharmaCo) theQuery.getResultList().get(0);
			}
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return thePharmaCo ;
			
			

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
	}



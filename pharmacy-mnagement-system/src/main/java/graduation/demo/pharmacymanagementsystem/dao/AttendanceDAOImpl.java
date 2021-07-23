package graduation.demo.pharmacymanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import graduation.demo.pharmacymanagementsystem.entity.Attendance;
import graduation.demo.pharmacymanagementsystem.entity.AttendancePK;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthlyPK;
@Repository
public class AttendanceDAOImpl implements AttendanceDAO {

	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public AttendanceDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public Attendance get_byid(AttendancePK theid) {
		Session currentSession = entityManager.unwrap(Session.class);

		Attendance theAttendance =
				currentSession.get(Attendance.class, theid);

		return theAttendance;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Attendance theAttendance) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theAttendance);
		currentSession.flush();
		
	}


	
	
}

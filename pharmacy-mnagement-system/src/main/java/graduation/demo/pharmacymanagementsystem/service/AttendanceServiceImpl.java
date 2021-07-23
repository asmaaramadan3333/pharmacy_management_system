package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduation.demo.pharmacymanagementsystem.dao.AttendanceDAO;

import graduation.demo.pharmacymanagementsystem.entity.Attendance;
import graduation.demo.pharmacymanagementsystem.entity.AttendancePK;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthly;
import graduation.demo.pharmacymanagementsystem.entity.EmployeesMonthlyPK;


@Service
public class AttendanceServiceImpl implements AttendanceService {

	private AttendanceDAO AttendanceDAO;

	@Autowired
	public AttendanceServiceImpl(AttendanceDAO theAttendanceDAO) {
		AttendanceDAO  = theAttendanceDAO;
	}
	
	
	@Override
	public Map<String, Object> addnew(Attendance theAttendance) {
		 Map<String, Object> coordinates = new HashMap<>();

		 Attendance theAttendance2 = get_by_id(theAttendance.getId());
			
			if(theAttendance2 == null)
			{
				AttendanceDAO.saveOrUpdate(theAttendance);
				coordinates.put("status", 1);
				coordinates.put("saved_Attendance",theAttendance);
			}
			else
			{
				coordinates.put("status", 0);
				coordinates.put("msg", "the Attendance id " + theAttendance.getId() + "aleady exist");
			}
			
			return coordinates;
	}

	@Override
	public Attendance get_by_id(AttendancePK theid) {
		return AttendanceDAO.get_byid(theid);
	}

	@Override
	public Attendance update(Attendance theAttendance) {
		
		AttendanceDAO.saveOrUpdate(theAttendance);
		return theAttendance;
	}


	
}

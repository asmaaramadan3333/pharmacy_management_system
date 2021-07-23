package graduation.demo.pharmacymanagementsystem.dao;

import graduation.demo.pharmacymanagementsystem.entity.Attendance;
import graduation.demo.pharmacymanagementsystem.entity.AttendancePK;


public interface AttendanceDAO {
	public Attendance get_byid(AttendancePK theid);
	public void saveOrUpdate(Attendance theAttendance);
}

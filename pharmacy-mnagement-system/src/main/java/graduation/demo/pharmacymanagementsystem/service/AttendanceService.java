package graduation.demo.pharmacymanagementsystem.service;

import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Attendance;
import graduation.demo.pharmacymanagementsystem.entity.AttendancePK;

public interface AttendanceService {
public Map<String, Object> addnew(Attendance theAttendance);
	
	public Attendance get_by_id(AttendancePK theid);
	public Attendance update(Attendance theAttendance);
	
}

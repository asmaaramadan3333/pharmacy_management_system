package graduation.demo.pharmacymanagementsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import graduation.demo.pharmacymanagementsystem.entity.Attendance;
import graduation.demo.pharmacymanagementsystem.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceRestController {

	private AttendanceService AttendanceService;
	
	@Autowired
	public AttendanceRestController(AttendanceService theAttendanceService) {
		AttendanceService = theAttendanceService;
	}
	
	@PostMapping("/add_new")
	public Map<String, Object> add_new_row (@RequestBody Attendance theAttendance)
	{    Map<String, Object> coordinates = new HashMap<>();
		
	      coordinates = AttendanceService.addnew(theAttendance);
		
		return coordinates;
		
	}
	
	@PutMapping("/update")
	public Attendance update_row (@RequestBody Attendance theAttendance)
	{    
		
		Attendance theAttendance2 = AttendanceService.update(theAttendance);
		return theAttendance2;
		
	}

	
	
}

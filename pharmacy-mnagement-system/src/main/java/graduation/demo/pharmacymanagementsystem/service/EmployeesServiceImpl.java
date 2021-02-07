package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.CustomersDAO;
import graduation.demo.pharmacymanagementsystem.dao.EmployeesDAO;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
@Service
public class EmployeesServiceImpl implements EmployeesService {
	private EmployeesDAO EmployeesDAO;

	@Autowired
	public EmployeesServiceImpl(EmployeesDAO theEmployeessDAO) {
		EmployeesDAO = theEmployeessDAO;
	}

	@Override
	@Transactional

	public Map<String, Boolean> employeeSignIn(String theusername, String thepassword) {

		Map<String, Boolean> coordinates = new HashMap<>();

		Employee theemployee = EmployeesDAO.getEmployeeByUsername(theusername);

		if (theemployee != null) {

			coordinates.put("having_an_account", true);

			Employee theExistingEmployee = EmployeesDAO.signIn(theusername, thepassword);

			if (theExistingEmployee != null) {

				coordinates.put("success", true);
				coordinates.put("correct_password", true);
			}

			else {
				coordinates.put("success", false);
				coordinates.put("correct_password", false);

			}

			return coordinates;

		}

		else

		{

			coordinates.put("success", false);
			coordinates.put("having_an_account", false);
			coordinates.put("correct_password", false);

			return coordinates;

		}

	}

	@Override
	public String restoreThePassword(String theusername) {
		// TODO Auto-generated method stub
		Employee theEmployee=EmployeesDAO.getEmployeeByUsername(theusername);
		return theEmployee.getPassword() ;
	}
	@Override
	public String restoreEmail(String theusername) {
		// TODO Auto-generated method stub
		Employee theEmployee=EmployeesDAO.getEmployeeByUsername(theusername);
		return theEmployee.getEmail() ;
	}
	@Override
	public int restoreId(String theusername) {
		// TODO Auto-generated method stub
		Employee theEmployee=EmployeesDAO.getEmployeeByUsername(theusername);
		return theEmployee.getId() ;
	}
	@Override
	public Employee getEmployeeByUsername(String theusername) {
		// TODO Auto-generated method stub
		return EmployeesDAO.getEmployeeByUsername(theusername);
	}

	@Override
	public int returnemployeeId(String theemployeename) {
		// TODO Auto-generated method stub
		
		Employee theEmployee=EmployeesDAO.getEmployeeByname(theemployeename);
		return theEmployee.getId();
	}
}

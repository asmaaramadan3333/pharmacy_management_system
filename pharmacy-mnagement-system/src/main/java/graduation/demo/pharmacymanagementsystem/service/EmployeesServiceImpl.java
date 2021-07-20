package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
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

	public Map<String, Object> employeeSignIn(String theusername, String thepassword) {

		Map<String,Object> coordinates = new HashMap<>();

		Employee theemployee = EmployeesDAO.getEmployeeByUsername(theusername);

		if (theemployee != null) {

			coordinates.put("having_an_account", 1);

			Employee theExistingEmployee = EmployeesDAO.signIn(theusername, thepassword);

			if (theExistingEmployee != null) {

				coordinates.put("success", 1);
				coordinates.put("correct_password", 1);
				coordinates.put("the_employee", theemployee);
			}

			else {
				coordinates.put("success", 0);
				coordinates.put("correct_password",0);
				coordinates.put("the_employee", theemployee);
			}

			return coordinates;

		}

		else

		{

			coordinates.put("success",0);
			coordinates.put("having_an_account", 0);
			coordinates.put("correct_password", 0);

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
	public Integer restoreId(String theusername) {
		// TODO Auto-generated method stub
		Employee theEmployee=EmployeesDAO.getEmployeeByUsername(theusername);
		if(theEmployee==null)
			return  null;
		else	
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

	@Override
	@Transactional
	public void saveORupdate(Employee theEmployee) {
		EmployeesDAO.saveORupdate(theEmployee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return EmployeesDAO.findAllEmployee();
	}
}

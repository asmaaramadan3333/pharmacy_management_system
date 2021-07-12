package graduation.demo.pharmacymanagementsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.EmployeeMonthlyDAO;

import graduation.demo.pharmacymanagementsystem.entity.Employee;

@Service
public class EmployeeMonthlyServiceImpl implements EmployeeMonthlyService {
	
	private EmployeeMonthlyDAO EmployeeMonthlyDAO;

	@Autowired
	public EmployeeMonthlyServiceImpl(EmployeeMonthlyDAO theEmployeesMonthlyDAO) {
		EmployeeMonthlyDAO  = theEmployeesMonthlyDAO;
	}
	@Override
	@Transactional
	public List<Employee> getallEmployeeWithStatusZero() {
		// TODO Auto-generated method stub
		return EmployeeMonthlyDAO.getallEmployeeWithStatusZero();
	}

	@Override
	@Transactional
	public List getEmployeeNameandHolidays(String month)
	{   
		List <Employee> Employee =EmployeeMonthlyDAO.getallEmployeeWithStatusZero();
		System.out.println(Employee);
	
		Map<String, Object> coordinates = new HashMap<>();
		ArrayList list = new ArrayList();
		
		for (int i=0 ;i<Employee.size();i++)
		{
		
		list.add(new HashMap());
		coordinates = new HashMap<>();
		System.out.println(Employee.get(i).getId());
		coordinates.put("EmployeeName", Employee.get(i).getName());
		int actualHolidayes=Integer.parseInt(Employee.get(i).getHolidays());
		System.out.println(actualHolidayes);
		
		int monthlyHolidayes=  EmployeeMonthlyDAO.getMonthlyHolidayes(Employee.get(i).getId(), month);
		System.out.println(monthlyHolidayes);
		coordinates.put("substractedHolidayes",monthlyHolidayes- actualHolidayes);
		list.add(coordinates);
		
		}
		return list;
	}
}

package graduation.demo.pharmacymanagementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.PharmaCoDAO;
import graduation.demo.pharmacymanagementsystem.entity.Employee;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.dao.ProductsDAO;
import graduation.demo.pharmacymanagementsystem.dao.EmployeesDAO;
@Service
public class PharmaCoServiceImpl implements PharmaCoService {
	private PharmaCoDAO PharmaCoDAO;
	//private ProductsDAO ProductsDAO;
	//private EmployeesDAO EmployeesDAO;

	/*
	 * @Autowired public PharmaCoServiceImpl(EmployeesDAO theEmployeesDAO) {
	 * EmployeesDAO = theEmployeesDAO; }
	 */
	/*
	 * @Autowired public PharmaCoServiceImpl(ProductsDAO theProductsDAO) {
	 * ProductsDAO = theProductsDAO; }
	 */

	
	  @Autowired public PharmaCoServiceImpl(PharmaCoDAO thePharmaCoDAO) {
	  PharmaCoDAO = thePharmaCoDAO;
	  }
	 


	@Override
	public int returnCompanyId(String thecompanyname) {
		// TODO Auto-generated method stub
		System.out.println(thecompanyname);
		PharmaCo thePharmaCo=PharmaCoDAO.getCompanyByCompanyName(thecompanyname);
		return thePharmaCo.getId();
	}
	/*
	 * public Map <String, Integer> get_id_employee_company_product(String
	 * name_of_product,String type,int size,String name_of_company,String
	 * name_of_employee) { Map<String, Integer> coordinates = new HashMap<>(); int
	 * thePharmaCo=returnCompanyId( name_of_company); Product
	 * theproduct=PharmaCoDAO.get_code(name_of_product, type, size); Employee
	 * theemployee=PharmaCoDAO.getEmployeeByname(name_of_employee);
	 * coordinates.put("thecode_of_product",theproduct.getCode());
	 * coordinates.put("the_id_of_employee",theemployee.getId());
	 * coordinates.put("the_id_of_company",thePharmaCo); return coordinates;
	 * 
	 * }
	 */

	@Override
	public PharmaCo getPharmaCo(String thecompanyname) {
		// TODO Auto-generated method stub
		return PharmaCoDAO.getCompanyByCompanyName(thecompanyname);
	}


	@Override
	public List<PharmaCo> findallcomplanyName() {
		// TODO Auto-generated method stub
		return PharmaCoDAO.findallcomplanyName();
	}
	
}

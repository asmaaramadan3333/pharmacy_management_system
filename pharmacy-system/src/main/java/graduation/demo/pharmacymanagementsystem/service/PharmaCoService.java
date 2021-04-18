package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;

public interface PharmaCoService {
	//public PharmaCo getCompanyByCompanyName(String thecompanyname);

	public int returnCompanyId(String thecompanyname);
	public PharmaCo getPharmaCo(String thecompanyname);
	public List <PharmaCo> findallcomplanyName();
   // public Map <String, Integer> get_id_employee_company_product(String name_of_product,String type,int size,String name_of_company,String name_of_employee);
}

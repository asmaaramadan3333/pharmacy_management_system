package graduation.demo.pharmacymanagementsystem.dao;


import java.util.List;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
public interface PharmaCoDAO {
	
	public List<PharmaCo> searchCompanyByCompanyName(String thecompanyname);
	
	public List <PharmaCo> findallcomplanyName();

	public List<PharmaCo> findAllPharmaCo();

	public void save(PharmaCo new_PharmaCo);
	
	//public Product get_code(String name, String type, int size);
	
	//public Employee getEmployeeByname(String name);
}

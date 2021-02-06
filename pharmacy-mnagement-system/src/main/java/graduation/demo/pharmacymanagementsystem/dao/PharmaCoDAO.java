package graduation.demo.pharmacymanagementsystem.dao;


import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;

public interface PharmaCoDAO {
	public PharmaCo getCompanyByCompanyName(String thecompanyname);
	public List <PharmaCo> findallcomplanyName();
}

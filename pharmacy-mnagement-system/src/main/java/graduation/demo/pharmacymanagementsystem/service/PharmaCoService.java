package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;

public interface PharmaCoService {
	//public PharmaCo getCompanyByCompanyName(String thecompanyname);

	public int returnCompanyId(String thecompanyname);
	public PharmaCo getPharmaCo(String thecompanyname);
	public List <PharmaCo> findallcomplanyName();
}

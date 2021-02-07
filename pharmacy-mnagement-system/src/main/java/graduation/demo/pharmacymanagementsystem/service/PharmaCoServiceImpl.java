package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduation.demo.pharmacymanagementsystem.dao.PharmaCoDAO;
import graduation.demo.pharmacymanagementsystem.entity.PharmaCo;
@Service
public class PharmaCoServiceImpl implements PharmaCoService {
	private PharmaCoDAO PharmaCoDAO;

	@Autowired
	public PharmaCoServiceImpl(PharmaCoDAO thePharmaCoDAO) {
		 PharmaCoDAO = thePharmaCoDAO;
	}


	@Override
	public int returnCompanyId(String thecompanyname) {
		// TODO Auto-generated method stub
		System.out.println(thecompanyname);
		PharmaCo thePharmaCo=PharmaCoDAO.getCompanyByCompanyName(thecompanyname);
		return thePharmaCo.getId() ;
	}


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

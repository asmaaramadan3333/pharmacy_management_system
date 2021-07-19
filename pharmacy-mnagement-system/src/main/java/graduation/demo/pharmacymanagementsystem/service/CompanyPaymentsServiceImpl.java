package graduation.demo.pharmacymanagementsystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import graduation.demo.pharmacymanagementsystem.dao.CompanyPaymentsDAO;
import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;

@Service
public class CompanyPaymentsServiceImpl implements CompanyPaymentsService {

    private CompanyPaymentsDAO CompanyPaymentsDAO ;
	
    @Autowired
    private PharmaCoService  PharmaCoService;
    
    
    @Autowired
	public CompanyPaymentsServiceImpl(CompanyPaymentsDAO theCompanyPaymentsDAO) {
    	CompanyPaymentsDAO = theCompanyPaymentsDAO;
	}
	
	@Override
	@Transactional
	public List<CompanyPayment> findAllCompanyPayments() {
		
		return CompanyPaymentsDAO.findAllCompanyPayments();
	}

	/*@Override
	@Transactional
	public CompanyPayment findByCode(int theCode) {
		
		return CompanyPaymentsDAO.findByCode(theCode);
	}*/

	
	
	
	@Override
	@Transactional
	public void saveORupdate(CompanyPayment theCompanyPayment) {
		   
		CompanyPaymentsDAO.saveORupdate(theCompanyPayment);
		
		if(theCompanyPayment.getPayment() != 0.0 &&theCompanyPayment.getTiming()!=null) {
		PharmaCoService.update_balance_futurepayment(theCompanyPayment);
		}
		
		
	}
 
	@Override
	public List<CompanyPayment> find_filteredCompanyPayments(Integer companyId, Date start_date, Date end_date) {
		return CompanyPaymentsDAO.find_filteredCompanyPayments(companyId,start_date,end_date);
	
	}

/*	@Override
	@Transactional
	public void deleteByCode(int theCode) {
		
		CompanyPaymentsDAO.deleteByCode(theCode);
		
	}*/

	/*@Override
	public List<CompanyPayment> searchByName(String theName) {
		
		return CompanyPaymentsDAO.searchByName(theName);
	}*/

}

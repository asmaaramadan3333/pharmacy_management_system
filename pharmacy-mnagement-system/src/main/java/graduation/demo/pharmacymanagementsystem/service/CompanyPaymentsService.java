package graduation.demo.pharmacymanagementsystem.service;

import java.util.Date;
import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;
import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;
import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;

public interface CompanyPaymentsService {

    public List <CompanyPayment> findAllCompanyPayments();
	
	//public CompanyPayment findByCode (int theCode);
	
	public void saveORupdate (CompanyPayment theCompanyPayment);

	public List<CompanyPayment> find_filteredCompanyPayments(Integer companyId, Date start_date, Date end_date);
	
	//public void deleteByCode (int theCode);
	
	//public List<CompanyPayment> searchByName(String theName);

	
	
}

package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.CompanyPayment;

public interface CompanyPaymentsDAO {

	public List <CompanyPayment> findAllCompanyPayments();
	
	//public CompanyPayment findByCode (int theCode);
	
	public void saveORupdate (CompanyPayment theCompanyPayment);
	
	//public void deleteByCode (int theCode);

	//public List<CompanyPayment> searchByName(String theName);
	
	
}

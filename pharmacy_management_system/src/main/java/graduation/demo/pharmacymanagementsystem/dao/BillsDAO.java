package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsDAO {

	public List <Bill> findAllBills();
	
	public Bill findByBillID (long thebill_id);
	
	public void saveORupdate (Bill theBill);
	
	public void deleteByBillID (int theCode);

	public void save(Bill theBill);

	public List<Bill> findCustomerBillsById(int theCustomerId);

	//public List<Bill> searchByName(String theName);
	
	
}

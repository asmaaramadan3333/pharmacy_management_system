package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsDAO {

	public List <Bill> findAllBills();
	
	public Bill findByBillID (int thebill_id);
	
	public void saveORupdate (Bill theBill);
	
	public void deleteByBillID (int theCode);

	//public List<Bill> searchByName(String theName);
	
	
}

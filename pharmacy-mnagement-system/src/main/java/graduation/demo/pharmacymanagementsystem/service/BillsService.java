package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsService {

    public List <Bill> findAllBills();
	
	public Bill findByBillID (int thebill_id);
	
	public void saveORupdate (Bill theBill);
	
	public void deleteByBillID (int thebill_id);
	
	//public List<Bill> searchByName(String theName);
	
}

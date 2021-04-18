package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsService {

    public List <Bill> findAllBills();
	
	public Bill findByBillID (long thebill_id);
	
	public void saveORupdate (Bill theBill);
	
	public void deleteByBillID (int thebill_id);

	void save(Bill theBill);
	
	//public List<Bill> searchByName(String theName);
	
	public List<Bill> findCustomerBillsById(int theCustomerId);

	
}

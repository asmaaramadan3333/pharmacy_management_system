package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Supply;

public interface SuppliesDAO {

	public List <Supply> findAllSupplies();
	
	public Supply findBybill_id (int supply_bill_id);
	
	public void save (Supply theSupply);
	
	public void deleteById (int theID);

	//public List<Supply> searchByName(String theName);

	public List <Supply> findBillTotalPrice(int supply_bill_id ,int CompanyID);
	
	
}

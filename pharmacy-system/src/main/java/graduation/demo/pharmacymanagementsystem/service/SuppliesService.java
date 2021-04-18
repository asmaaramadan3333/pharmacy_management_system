package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Supply;

public interface SuppliesService {

    public List <Supply> findAllSupplies();
	
	public Supply findBybill_id (int supply_bill_id);
	
	public void save (Supply theSupply);
	
	public void deleteById (int theID);
	
	//public List<Supply> searchByName(String theName);

	public double findBillTotalPrice (int supply_bill_id, int companyId);	
}


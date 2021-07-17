package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.SuppliesDAO;
import graduation.demo.pharmacymanagementsystem.entity.Supply;

@Service
public class SupplisServiceImpl implements SuppliesService {

    private SuppliesDAO SuppliesDAO ;
	
    @Autowired
	public SupplisServiceImpl(SuppliesDAO theSuppliesDAO) {
    	SuppliesDAO = theSuppliesDAO;
	}
	
	@Override
	@Transactional
	public List<Supply> findAllSupplies() {
		
		return SuppliesDAO.findAllSupplies();
	}

	@Override
	@Transactional
	public Supply findBybill_id(int supply_bill_id) {
		
		return SuppliesDAO.findBybill_id(supply_bill_id);
	}

	
	@Override
	@Transactional
	public double findBillTotalPrice (int supply_bill_id, int companyId) {
		
		List < Supply > supplies = SuppliesDAO.findBillTotalPrice(supply_bill_id, companyId);
		double total_price = 0;
		
		for(int i=0 ; i<supplies.size();i++)
		{
		   	total_price+=supplies.get(i).getTotalPrice();
		}
		
		return total_price;
	}
	
	@Override
	@Transactional
	public void save(Supply theSupply) {
		
		SuppliesDAO.save(theSupply);
	}

	@Override
	@Transactional
	public void deleteById(int theID) {
		
		SuppliesDAO.deleteById(theID);
		
	}

	@Override
	@Transactional
	public void saveORupdate(Supply theSupply) {
		// TODO Auto-generated method stub
		SuppliesDAO.saveORupdate(theSupply);
	}

	@Override
	public Supply findSpecificSupply(int companyId, int supplyBillId) {
		// TODO Auto-generated method stub
		return SuppliesDAO.findSpecificSupply(companyId, supplyBillId);
	}

	/*@Override
	public List<Supply> searchByName(String theName) {
		
		return SuppliesDAO.searchByName(theName);
	}*/

}

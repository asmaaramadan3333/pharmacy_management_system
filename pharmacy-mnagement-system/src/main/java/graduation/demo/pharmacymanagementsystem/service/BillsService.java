package graduation.demo.pharmacymanagementsystem.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.dto.SoldProductsQuantityDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsService {

    public List <Bill> findAllBills();
	
	public Bill findByBillID (long thebill_id);
	
	public Map<String, Object> update (Bill theBill);
	
	public void deleteByBillID (int thebill_id);

	void save(Bill theBill);
	
	//public List<Bill> searchByName(String theName);
	
	public List<Bill> findCustomerBillsById(int theCustomerId);

	public List<SoldProductsQuantityDTO> find_product_while_aperiod(String replyTime1, String replyTime2);

	public List<Bill> find_filteredBills(Long billId, String billType, String billState, String replyTime);

	
}

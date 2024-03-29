package graduation.demo.pharmacymanagementsystem.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.dto.BillMonthsDTO;
import graduation.demo.pharmacymanagementsystem.dto.SoldProductsQuantityDTO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsService {

    public List <Bill> findAllBills();
	
	public Bill findByBillID (long thebill_id);
	
	public Map<String, Object> update (Bill theBill);
	
	public void deleteByBillID (long thebill_id);

	void save(Bill theBill);
	public void saveORupdate(Bill theBill);
	//public List<Bill> searchByName(String theName);
	
	public List<Bill> findCustomerBillsById(int theCustomerId);

	public List<SoldProductsQuantityDTO> find_product_while_aperiod(String replyTime1, String replyTime2);

	public List<Bill> find_filteredBills(Long billId, String billType, String billState, String replyTime);
	
	public List<Map<String, Object>> findEveryBillBymonth(List<BillMonthsDTO> billMonthsDTOList);

	public List<Map<String, Object>> get_avg_pharmacy_feedback();
	
}

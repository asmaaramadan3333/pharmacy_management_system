
package graduation.demo.pharmacymanagementsystem.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsDAO {

	public List <Bill> findAllBills();

	public Bill findByBillID (long thebill_id);

	public void saveORupdate (Bill theBill);

	public void deleteByBillID (long theCode);

	public void save(Bill theBill);

	public List<Bill> findCustomerBillsById(int theCustomerId);

	List<Bill> find_product_while_aperiod(Date replyTime1, Date replyTime2);

	public List<Bill> find_filteredBills(Long billId, String billType, String billState, String replyTime);

	public Map<String, Object> findEveryBillBymonthAndTotalPrice(Date timestamp1, Date timestamp2);

	public List<Map<String, Object>> get_avg_pharmacy_feedback();

	


}

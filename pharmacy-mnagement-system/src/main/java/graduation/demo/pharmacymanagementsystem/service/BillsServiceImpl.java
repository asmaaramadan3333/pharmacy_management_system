package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import graduation.demo.pharmacymanagementsystem.dao.BillsDAO;
import graduation.demo.pharmacymanagementsystem.entity.Bill;

@Service
public class BillsServiceImpl implements BillsService {

    private BillsDAO BillsDAO ;
	
    @Autowired
	public BillsServiceImpl(BillsDAO theBillsDAO) {
    	BillsDAO = theBillsDAO;
	}
	
	@Override
	@Transactional
	public List<Bill> findAllBills() {
		
		return BillsDAO.findAllBills();
	}

	@Override
	@Transactional
	public Bill findByBillID(int thebill_id) {
		
		return BillsDAO.findByBillID(thebill_id);
	}

	@Override
	@Transactional
	public void saveORupdate(Bill theBill) {
		
		BillsDAO.saveORupdate(theBill);
	}

	@Override
	@Transactional
	public void deleteByBillID(int thebill_id) {
		
		BillsDAO.deleteByBillID(thebill_id);
		
	}

	/*@Override
	public List<Bill> searchByName(String theName) {
		
		return BillsDAO.searchByName(theName);
	}*/

}

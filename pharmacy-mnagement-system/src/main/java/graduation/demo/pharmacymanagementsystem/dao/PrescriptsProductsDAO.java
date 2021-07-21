package graduation.demo.pharmacymanagementsystem.dao;

import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProductPK;

public interface PrescriptsProductsDAO {

	public List <PrescriptsProduct> findAllPrescriptsProducts();
	
	public PrescriptsProduct findById(PrescriptsProductPK theId);
	
	public List<PrescriptsProduct> saveORupdate(List<PrescriptsProduct> thePrescriptsProduct) ;
	
	public void deleteByCode (int theCode);

	public List<PrescriptsProduct> searchByName(String theName);
	
	
}

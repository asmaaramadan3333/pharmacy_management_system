package graduation.demo.pharmacymanagementsystem.service;

import java.util.List;
import java.util.Map;

import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProduct;
import graduation.demo.pharmacymanagementsystem.entity.PrescriptsProductPK;

public interface PrescriptsProductsService {

    public List <PrescriptsProduct> findAllPrescriptsProducts();
	
    public PrescriptsProduct findById(PrescriptsProductPK theId);
    
    public Map<String, Object> saveORupdate(List<PrescriptsProduct> thePrescriptsProduct);	
	
    public void deleteByCode (int theCode);
	
	public List<PrescriptsProduct> searchByName(String theName);
	
}

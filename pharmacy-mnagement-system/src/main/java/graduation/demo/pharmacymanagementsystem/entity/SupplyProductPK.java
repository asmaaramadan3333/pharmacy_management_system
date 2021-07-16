package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the supply_products database table.
 * 
 */
@Embeddable
public class SupplyProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="company_id")
	private int companyId;

	@Column(name="supply_id")
	private int supplyId;

	@Column(name="product_code")
	private int productCode;

	public SupplyProductPK() {
	}
	public int getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getSupplyId() {
		return this.supplyId;
	}
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	public int getProductCode() {
		return this.productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SupplyProductPK)) {
			return false;
		}
		SupplyProductPK castOther = (SupplyProductPK)other;
		return 
			(this.companyId == castOther.companyId)
			&& (this.supplyId == castOther.supplyId)
			&& (this.productCode == castOther.productCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.supplyId;
		hash = hash * prime + this.productCode;
		
		return hash;
	}
}
package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the supply database table.
 * 
 */
@Embeddable
public class SupplyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="company_id")
	private int companyId;

	
	@Column(name="supply_bill_id")
	private int supplyBillId;

	public SupplyPK() {
	}
	public int getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public int getSupplyBillId() {
		return this.supplyBillId;
	}
	public void setSupplyBillId(int supplyBillId) {
		this.supplyBillId = supplyBillId;
	}
	@Override
	public String toString() {
		return "SupplyPK [companyId=" + companyId + ", supplyBillId=" + supplyBillId
				+ "]";
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SupplyPK)) {
			return false;
		}
		SupplyPK castOther = (SupplyPK)other;
		return 
			(this.companyId == castOther.companyId)
			&& (this.supplyBillId == castOther.supplyBillId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.supplyBillId;
		
		return hash;
	}
}
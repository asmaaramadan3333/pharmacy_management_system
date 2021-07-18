package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bills_products database table.
 * 
 */
@Embeddable
public class BillsProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="bill_id", insertable=false, updatable=false)
	private long billId;

	@Column(name="product_code", insertable=false, updatable=false)
	private int productCode;

	@Column(name="company_id")
	private int companyId;
	
	@Column(name="supply_id")
	private int supplyId;

	public BillsProductPK() {
	}
	public long getBillId() {
		return this.billId;
	}
	public void setBillId(long billId) {
		this.billId = billId;
	}
	public int getProductCode() {
		return this.productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BillsProductPK)) {
			return false;
		}
		BillsProductPK castOther = (BillsProductPK)other;
		return 
			this.billId==castOther.billId
			&& (this.productCode == castOther.productCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = (int) (hash * prime + this.billId);
		hash = hash * prime + this.productCode;
		
		return hash;
	}

	
}
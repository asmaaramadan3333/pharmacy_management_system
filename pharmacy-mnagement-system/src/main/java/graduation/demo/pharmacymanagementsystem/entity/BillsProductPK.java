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
	private String billId;

	@Column(name="product_code", insertable=false, updatable=false)
	private int productCode;

	public BillsProductPK() {
	}
	public String getBillId() {
		return this.billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
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
		if (!(other instanceof BillsProductPK)) {
			return false;
		}
		BillsProductPK castOther = (BillsProductPK)other;
		return 
			this.billId.equals(castOther.billId)
			&& (this.productCode == castOther.productCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.billId.hashCode();
		hash = hash * prime + this.productCode;
		
		return hash;
	}
}
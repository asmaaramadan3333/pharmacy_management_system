package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the prescripts_products database table.
 * 
 */
@Embeddable
public class PrescriptsProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="prescript_id")
	private int prescriptId;

	@Column(name="product_code", insertable=false, updatable=false)
	private int productCode;

	public PrescriptsProductPK() {
	}
	public int getPrescriptId() {
		return this.prescriptId;
	}
	public void setPrescriptId(int prescriptId) {
		this.prescriptId = prescriptId;
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
		if (!(other instanceof PrescriptsProductPK)) {
			return false;
		}
		PrescriptsProductPK castOther = (PrescriptsProductPK)other;
		return 
			(this.prescriptId == castOther.prescriptId)
			&& (this.productCode == castOther.productCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prescriptId;
		hash = hash * prime + this.productCode;
		
		return hash;
	}
}
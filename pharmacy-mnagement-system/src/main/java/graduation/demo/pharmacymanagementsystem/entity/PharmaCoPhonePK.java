package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pharma_co_phones database table.
 * 
 */
@Embeddable
public class PharmaCoPhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="company_id", insertable=false, updatable=false)
	private int companyId;

	private int phone;

	public PharmaCoPhonePK() {
	}
	public int getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getPhone() {
		return this.phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PharmaCoPhonePK)) {
			return false;
		}
		PharmaCoPhonePK castOther = (PharmaCoPhonePK)other;
		return 
			(this.companyId == castOther.companyId)
			&& (this.phone == castOther.phone);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.phone;
		
		return hash;
	}
}
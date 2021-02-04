package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customers_phones database table.
 * 
 */
@Embeddable
public class CustomersPhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="customer_id", insertable=false, updatable=false)
	private int customerId;

	@Column(name="phone_number")
	private int phoneNumber;

	public CustomersPhonePK() {
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomersPhonePK)) {
			return false;
		}
		CustomersPhonePK castOther = (CustomersPhonePK)other;
		return 
			(this.customerId == castOther.customerId)
			&& (this.phoneNumber == castOther.phoneNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId;
		hash = hash * prime + this.phoneNumber;
		
		return hash;
	}
}
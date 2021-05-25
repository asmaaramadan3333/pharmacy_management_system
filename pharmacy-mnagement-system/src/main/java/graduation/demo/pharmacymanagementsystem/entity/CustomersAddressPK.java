package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customers_addresses database table.
 * 
 */
@Embeddable
public class CustomersAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="customer_id", insertable=false, updatable=false)
	private int customerId;
	@Column(name="address" )
	private String address;

	public CustomersAddressPK() {
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomersAddressPK)) {
			return false;
		}
		CustomersAddressPK castOther = (CustomersAddressPK)other;
		return 
			(this.customerId == castOther.customerId)
			&& this.address.equals(castOther.address);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId;
		hash = hash * prime + this.address.hashCode();
		
		return hash;
	}
}
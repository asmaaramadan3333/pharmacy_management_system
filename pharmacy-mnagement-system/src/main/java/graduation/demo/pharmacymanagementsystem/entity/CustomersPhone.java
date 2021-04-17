package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the customers_phones database table.
 * 
 */
@Entity
@Table(name="customers_phones")

public class CustomersPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomersPhonePK id;

	//bi-directional many-to-one association to Customer
	//@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	//@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="customer_id",insertable=false,updatable=false)
	@JoinColumn(name="customer_id",insertable=false,updatable=false)

  @JsonIgnore
	private Customer customer;
	public void setIdParam (int customerId,int phoneNumber ) {
		this.id.setPhoneNumber(phoneNumber);
		this.id.setCustomerId(customerId);
		
	}

	public CustomersPhone() {
	}

	public CustomersPhonePK getId() {
		return this.id;
	}

	public void setId(CustomersPhonePK id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomersPhone [id=" + id + ", customer=" + customer + "]";
	}


}

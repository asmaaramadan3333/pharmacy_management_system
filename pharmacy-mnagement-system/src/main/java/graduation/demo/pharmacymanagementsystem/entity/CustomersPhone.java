package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customers_phones database table.
 * 
 */
@Entity
@Table(name="customers_phones")
@NamedQuery(name="CustomersPhone.findAll", query="SELECT c FROM CustomersPhone c")
public class CustomersPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomersPhonePK id;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)

	@JoinColumn(name="customer_id",insertable=false,updatable=false)

	private Customer customer;

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

}
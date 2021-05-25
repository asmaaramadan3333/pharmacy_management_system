package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the customers_addresses database table.
 * 
 */
@Entity
@Table(name="customers_addresses")
//@NamedQuery(name="CustomersAddress.findAll", query="SELECT c FROM CustomersAddress c")
public class CustomersAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomersAddressPK id;

	//bi-directional many-to-one association to Customer
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id",insertable=false,updatable=false)
	@JsonIgnore
	private Customer customer;
	public void setIdParam (int customerId,String address ) {
		
		this.id.setAddress(address);
		this.id.setCustomerId(customerId);
	}

	@Override
	public String toString() {
		return "CustomersAddress [id=" + id + ", customer=" + customer + "]";
	}

	public CustomersAddress() {
	}

	public CustomersAddressPK getId() {
		return this.id;
	}

	public void setId(CustomersAddressPK id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
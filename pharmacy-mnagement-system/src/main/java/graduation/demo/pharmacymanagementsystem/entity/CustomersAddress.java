package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customers_addresses database table.
 * 
 */
@Entity
@Table(name="customers_addresses")
@NamedQuery(name="CustomersAddress.findAll", query="SELECT c FROM CustomersAddress c")
public class CustomersAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int customerId;

	private String appartment;

	private String country;

	private String floor;

	private String governorate;

	private String region;

	private String street;

	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public CustomersAddress() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAppartment() {
		return this.appartment;
	}

	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getGovernorate() {
		return this.governorate;
	}

	public void setGovernorate(String governorate) {
		this.governorate = governorate;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
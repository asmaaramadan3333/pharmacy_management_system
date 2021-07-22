package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@Column(name = "generic_name")
	private String genericName;

	@Column(name = "main_category")
	private String mainCategory;

	@Column(name = "minimum_quantity")
	private int minimumQuantity;

	@Column(name = "name")
	private String name;
	@Column(name = "packages")
	private int packages;
	@Column(name = "position")
	private String position;

	@Column(name = "secondary_category")
	private String secondaryCategory;

	@Column(name = "state")
	private int state;
 
	
	// bi-directional many-to-one association to BillsProduct
	@JoinColumn(name="product_code")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<BillsProduct> billsProducts;

	// bi-directional many-to-one association to PrescriptsProduct
	@JoinColumn(name="product_code")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PrescriptsProduct> prescriptsProducts;

	// bi-directional many-to-many association to Customer

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })

	@JoinTable(name = "customers_products_history", joinColumns = {
			@JoinColumn(name = "product_code") }, inverseJoinColumns = { @JoinColumn(name = "customer_id") })

	@JsonIgnore
	private List<Customer> customers;

	// bi-directional many-to-one association to SupplyProduct
	@JoinColumn(name="product_code")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<SupplyProduct> supplyProducts;

	public Product() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGenericName() {
		return this.genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getMainCategory() {
		return this.mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public int getMinimumQuantity() {
		return this.minimumQuantity;
	}

	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPackages() {
		return this.packages;
	}

	public void setPackages(int packages) {
		this.packages = packages;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSecondaryCategory() {
		return this.secondaryCategory;
	}

	public void setSecondaryCategory(String secondaryCategory) {
		this.secondaryCategory = secondaryCategory;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	public List<BillsProduct> getBillsProducts() {
		return this.billsProducts;
	}

	public void setBillsProducts(List<BillsProduct> billsProducts) {
		this.billsProducts = billsProducts;
	}



	public List<PrescriptsProduct> getPrescriptsProducts() {
		return this.prescriptsProducts;
	}

	public void setPrescriptsProducts(List<PrescriptsProduct> prescriptsProducts) {
		this.prescriptsProducts = prescriptsProducts;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<SupplyProduct> getSupplyProducts() {
		return this.supplyProducts;
	}

	public void setSupplyProducts(List<SupplyProduct> supplyProducts) {
		this.supplyProducts = supplyProducts;
	}


}
package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Column(name="main_category")
	private String mainCategory;

	@Column(name="minimum_quantity")
	private int minimumQuantity;

	private String name;

	@Column(name="secondary_category")
	private String secondaryCategory;

	private int size;

	private int state;

	private String type;

	//bi-directional many-to-one association to BillsProduct
	@OneToMany(mappedBy="product")
	private List<BillsProduct> billsProducts;

	//bi-directional many-to-many association to Customer
	@ManyToMany
	@JoinTable(
		name="customers_products_history"
		, joinColumns={
			@JoinColumn(name="product_code")
			}
		, inverseJoinColumns={
			@JoinColumn(name="customer_id")
			}
		)
	@JsonIgnore
	private List<Customer> customers;

	//bi-directional many-to-one association to Supply
	@OneToMany(mappedBy="product")
	private List<Supply> supplies;

	public Product() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getSecondaryCategory() {
		return this.secondaryCategory;
	}

	public void setSecondaryCategory(String secondaryCategory) {
		this.secondaryCategory = secondaryCategory;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<BillsProduct> getBillsProducts() {
		return this.billsProducts;
	}

	public void setBillsProducts(List<BillsProduct> billsProducts) {
		this.billsProducts = billsProducts;
	}

	public BillsProduct addBillsProduct(BillsProduct billsProduct) {
		getBillsProducts().add(billsProduct);
		billsProduct.setProduct(this);

		return billsProduct;
	}

	public BillsProduct removeBillsProduct(BillsProduct billsProduct) {
		getBillsProducts().remove(billsProduct);
		billsProduct.setProduct(null);

		return billsProduct;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Supply> getSupplies() {
		return this.supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public Supply addSupply(Supply supply) {
		getSupplies().add(supply);
		supply.setProduct(this);

		return supply;
	}

	public Supply removeSupply(Supply supply) {
		getSupplies().remove(supply);
		supply.setProduct(null);

		return supply;
	}

}
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
@Table(name="products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Temporal(TemporalType.DATE)
	@Column(name="expire_date")
	private Date expireDate;

	@Column(name="main_category")
	private String mainCategory;

	@Column(name="minimum_quantity")
	private int minimumQuantity;
	@Column(name = "name")
	private String name;
	@Column(name = "packages")
	private int packages;
	@Column(name = "position")
	private String position;
	@Column(name = "price")
	private float price;
	@Column(name = "quantity")
	private int quantity;

	@Column(name="secondary_category")
	private String secondaryCategory;
	@Column(name = "state")
	private int state;

	//bi-directional many-to-one association to BillsProduct
	@OneToMany(mappedBy="product")
	private List<BillsProduct> billsProducts;
	//bi-directional many-to-many association to Customer


		@ManyToMany(fetch = FetchType.LAZY,
				cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
				CascadeType.REFRESH })

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

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
package graduation.demo.pharmacymanagmentsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Column(name="main_category")
	private String mainCategory;

	@Column(name="minimum_quantity")
	private int minimumQuantity;
    @Column(name="name")
	private String name;

	@Column(name="secondary_category")
	private String secondaryCategory;
	
    @Column (name="size")
	private int size;
    @Column (name="state")
	private int state;
    @Column (name="type")
	private String type;
	//define constructors
    @ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
		name="customers_products_history"
		, joinColumns={
			@JoinColumn(name="product_code")
			}
		, inverseJoinColumns={
			@JoinColumn(name="customer_id")
			}
		)
    
	private List<Customer> customers;
    public Product() {
	}
    
    
    
	public Product(String mainCategory, int minimumQuantity, String name, String secondaryCategory, int size, int state,
			String type, List<Customer> customers) {
		this.mainCategory = mainCategory;
		this.minimumQuantity = minimumQuantity;
		this.name = name;
		this.secondaryCategory = secondaryCategory;
		this.size = size;
		this.state = state;
		this.type = type;
		this.customers = customers;
	}



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public int getMinimumQuantity() {
		return minimumQuantity;
	}
	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondaryCategory() {
		return secondaryCategory;
	}
	public void setSecondaryCategory(String secondaryCategory) {
		this.secondaryCategory = secondaryCategory;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", mainCategory=" + mainCategory + ", minimumQuantity=" + minimumQuantity
				+ ", name=" + name + ", secondaryCategory=" + secondaryCategory + ", size=" + size + ", state=" + state
				+ ", type=" + type + "]";
	}

	
	
	
}

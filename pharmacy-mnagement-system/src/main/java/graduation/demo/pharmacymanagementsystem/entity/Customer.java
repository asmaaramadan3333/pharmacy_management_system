package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int customerId;
    @Column(name="credit")
	private float credit;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="email")
	private String email;

	@Column(name="first_name")
	private String firstName;
	@Column(name="gender")
	private String gender;

	@Column(name="last_name")
	private String lastName;
	@Column(name="password")
	private String password;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	
	private List<Bill> bills;

	//bi-directional one-to-one association to CustomersAddress
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CustomersAddress> customersAddresses;

	//bi-directional many-to-one association to CustomersPhone

	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CustomersPhone> customersPhones;

	//bi-directional many-to-many association to Product
	//@ManyToMany(mappedBy="customers")
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})

    @JoinTable(

    		name="customers_products_history"
    		, joinColumns={
    			@JoinColumn(name="customer_id")
    			}
    		, inverseJoinColumns={
    			@JoinColumn(name="product_code")
    			}
    		)

	private List<Product> products;


	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="customers")
	private List<Employee> employees;

	public Customer() {
	}

	public Customer(float credit, Date dateOfBirth, String email, String firstName, String gender, String lastName,
			String password, List<Bill> bills, List<CustomersAddress> customersAddresses, List<CustomersPhone> customersPhones,
			List<Product> products, List<Employee> employees) {
		
		this.credit = credit;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.password = password;
		this.bills = bills;
		this.customersAddresses = customersAddresses;
		this.customersPhones = customersPhones;
		this.products = products;
		this.employees = employees;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getCredit() {
		return this.credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setCustomer(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setCustomer(null);

		return bill;
	}

	public List<CustomersAddress> getCustomersAddresses() {
		return this.customersAddresses;
	}

	public void setCustomersAddresses(List<CustomersAddress> customersAddresses) {
		this.customersAddresses = customersAddresses;
	}

	public CustomersAddress addCustomersAddress(CustomersAddress customersAddress) {
		getCustomersAddresses().add(customersAddress);
		customersAddress.setCustomer(this);

		return customersAddress;
	}

	public CustomersAddress removeCustomersAddress(CustomersAddress customersAddress) {
		getCustomersAddresses().remove(customersAddress);
		customersAddress.setCustomer(null);

		return customersAddress;
	}
	public List<CustomersPhone> getCustomersPhones() {
		return this.customersPhones;
	}

	public void setCustomersPhones(List<CustomersPhone> customersPhones) {
		this.customersPhones = customersPhones;
	}

	public CustomersPhone addCustomersPhone (CustomersPhone customersPhone) {
		getCustomersPhones().add(customersPhone);
		
		customersPhone.setCustomer(this);

		return customersPhone;
	}

	public CustomersPhone removeCustomersPhone(CustomersPhone customersPhone) {
		getCustomersPhones().remove(customersPhone);
		customersPhone.setCustomer(null);

		return customersPhone;
	}


	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void add (Product theproduct)
	{
		if(products==null)
		{
			products=new ArrayList<>();
			
		}
		products.add(theproduct);
		
	}

	  
	public void add2 (CustomersPhone tempCustomersPhone)
	{
		if(customersPhones ==null)
		{
			customersPhones=new ArrayList<>();
			
		}
		customersPhones.add(tempCustomersPhone);
		tempCustomersPhone.setCustomer(this);
	}

}
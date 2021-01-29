package graduation.demo.pharmacymanagmentsystem.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="customers")
public class Customer  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
    public Customer()
    {
    	
    }
    
	
	public Customer(float credit, Date dateOfBirth, String email, String firstName, String gender, String lastName,
			String password, List<Product> products) {
		super();
		this.credit = credit;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.password = password;
		this.products = products;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", credit=" + credit + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + ", firstName=" + firstName + ", gender=" + gender + ", lastName=" + lastName + ", password="
				+ password + ", products=" + products + "]";
	}

	public void add (Product theproduct)
	{
		if(products==null)
		{
			products=new ArrayList<>();
			
		}
		products.add(theproduct);
		
	}
}

package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers_prescripts database table.
 * 
 */
@Entity
@Table(name="customers_prescripts")
@NamedQuery(name="CustomersPrescript.findAll", query="SELECT c FROM CustomersPrescript c")
public class CustomersPrescript implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int feedback;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reply_time")
	private Date replyTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sent_time")
	private Date sentTime;

	private String status;

	private String url;

	//bi-directional many-to-one association to Bill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bill_id")
	private Bill bill;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;

	//bi-directional many-to-one association to PrescriptsProduct
	@OneToMany(mappedBy="customersPrescript")
	private List<PrescriptsProduct> prescriptsProducts;

	public CustomersPrescript() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFeedback() {
		return this.feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Date getSentTime() {
		return this.sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<PrescriptsProduct> getPrescriptsProducts() {
		return this.prescriptsProducts;
	}

	public void setPrescriptsProducts(List<PrescriptsProduct> prescriptsProducts) {
		this.prescriptsProducts = prescriptsProducts;
	}

	public PrescriptsProduct addPrescriptsProduct(PrescriptsProduct prescriptsProduct) {
		getPrescriptsProducts().add(prescriptsProduct);
		prescriptsProduct.setCustomersPrescript(this);

		return prescriptsProduct;
	}

	public PrescriptsProduct removePrescriptsProduct(PrescriptsProduct prescriptsProduct) {
		getPrescriptsProducts().remove(prescriptsProduct);
		prescriptsProduct.setCustomersPrescript(null);

		return prescriptsProduct;
	}

}
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

	private Integer feedback;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reply_time")
	private Date replyTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sent_time")
	private Date sentTime;

	@Column(name="status")
	private String status;

	@Column(name="url")
	private String url;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="bill_id")
	private Long billId;

	/*
	 * //bi-directional many-to-one association to Bill
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="bill_id") private Bill bill;
	 */

	/*
	 * //bi-directional many-to-one association to Customer
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="customer_id") private Customer customer;
	 */
	/*
	 * //bi-directional many-to-one association to Employee
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY) private Employee employee;
	 */

	//bi-directional many-to-one association to PrescriptsProduct
	@JoinColumn(name="prescript_id")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PrescriptsProduct> prescriptsProducts;

	public CustomersPrescript() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Integer feedback) {
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


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public List<PrescriptsProduct> getPrescriptsProducts() {
		return this.prescriptsProducts;
	}

	public void setPrescriptsProducts(List<PrescriptsProduct> prescriptsProducts) {
		this.prescriptsProducts = prescriptsProducts;
	}



}
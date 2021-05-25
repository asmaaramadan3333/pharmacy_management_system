package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.util.TimeZone;

/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name = "bills")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	private long billId;

	@Column(name = "bill_state")
	private String billState;

	@Column(name = "bill_type")
	private String billType;

	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "delivery_fee")
	private float deliveryFee;

	@Column(name = "phone_number")
	private int phoneNumber;

	@Column(name = "delivery_feedback")
	private int deliveryFeedback;

	@Column(name = "employee_feedback")
	private int employeeFeedback;

	@Column(name = "pharmacy_feedback")
	private int pharmacyFeedback;

	@Column(name="user_feedback")
	private int userFeedback;
	
	@Column(name = "prescription_or_not")
	private int prescriptionOrNot;

	// @CreationTimestamp()/////
	// @JsonFormat(timezone = "GMT+02:00")
	// @DateTimeFormat(pattern="hh:mm:ss" )
	// @Temporal(TemporalType.TIME)
	// @Column(name = "time")//, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date time;

	@Column(name = "total_price")
	private float totalPrice;

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "customer_id", insertable = false, updatable = false)
	private int customerId;
	@Column(name = "employee_id", insertable = false, updatable = false)
	private int employeeId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// bi-directional many-to-one association to Customer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id") // ,columnDefinition = "customerId")

	@JsonIgnore
	private Customer customer;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	 @JsonIgnore
	private Employee employee1;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_man_id")
	 @JsonIgnore
	private Employee employee2;

	// bi-directional many-to-one association to BillsProduct
	@OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<BillsProduct> billsProducts;

	public Bill() {
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billState=" + billState + ", billType=" + billType + ", customerAddress="
				+ customerAddress + ", deliveryFee=" + deliveryFee + ", phoneNumber=" + phoneNumber
				+ ", deliveryFeedback=" + deliveryFeedback + ", employeeFeedback=" + employeeFeedback
				+ ", pharmacyFeedback=" + pharmacyFeedback + ", userFeedback=" + userFeedback + ", prescriptionOrNot="
				+ prescriptionOrNot + ", time=" + time + ", totalPrice=" + totalPrice + ", customerId=" + customerId
				+ ", employeeId=" + employeeId + ", customer=" + customer + ", employee1=" + employee1 + ", employee2="
				+ employee2 + ", billsProducts=" + billsProducts + "]";
	}

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getBillState() {
		return this.billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public float getDeliveryFee() {
		return this.deliveryFee;
	}

	public void setDeliveryFee(float deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public int getDeliveryFeedback() {
		return deliveryFeedback;
	}

	public void setDeliveryFeedback(int deliveryFeedback) {
		this.deliveryFeedback = deliveryFeedback;
	}

	public int getEmployeeFeedback() {
		return employeeFeedback;
	}

	public void setEmployeeFeedback(int employeeFeedback) {
		this.employeeFeedback = employeeFeedback;
	}

	public int getPharmacyFeedback() {
		return pharmacyFeedback;
	}

	public void setPharmacyFeedback(int pharmacyFeedback) {
		this.pharmacyFeedback = pharmacyFeedback;
	}

	public int getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(int userFeedback) {
		this.userFeedback = userFeedback;
	}

	public int getPrescriptionOrNot() {
		return prescriptionOrNot;
	}

	public void setPrescriptionOrNot(int prescriptionOrNot) {
		this.prescriptionOrNot = prescriptionOrNot;
	}

	public List<BillsProduct> getBillsProducts() {
		return this.billsProducts;
	}

	public void setBillsProducts(List<BillsProduct> billsProducts) {
		this.billsProducts = billsProducts;
	}

	public BillsProduct addBillsProduct(BillsProduct billsProduct) {
		getBillsProducts().add(billsProduct);
		billsProduct.setBill(this);

		return billsProduct;
	}

	public BillsProduct removeBillsProduct(BillsProduct billsProduct) {
		getBillsProducts().remove(billsProduct);
		billsProduct.setBill(null);

		return billsProduct;
	}

}
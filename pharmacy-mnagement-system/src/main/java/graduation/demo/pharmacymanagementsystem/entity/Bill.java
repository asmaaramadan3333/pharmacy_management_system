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
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date time;

	@Column(name = "total_price")
	private float totalPrice;


	@Column(name = "customer_id")
	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@JoinColumn(name="bill_id")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)

	private List<BillsProduct> billsProducts;
	
	@JoinColumn(name="bill_id")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CustomersPrescript> customersPrescripts;
	public Bill() {
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billState=" + billState + ", billType=" + billType + ", customerAddress="
				+ customerAddress + ", deliveryFee=" + deliveryFee + ", phoneNumber=" + phoneNumber
				+ ", deliveryFeedback=" + deliveryFeedback + ", employeeFeedback=" + employeeFeedback
				+ ", pharmacyFeedback=" + pharmacyFeedback + ", userFeedback=" + userFeedback + ", prescriptionOrNot="
				+ prescriptionOrNot + ", time=" + time + ", totalPrice=" + totalPrice + 
				 ", billsProducts=" + billsProducts + "]";
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
	public List<CustomersPrescript> getCustomersPrescripts() {
		return this.customersPrescripts;
	}

	public void setCustomersPrescripts(List<CustomersPrescript> customersPrescripts) {
		this.customersPrescripts = customersPrescripts;
	}
}
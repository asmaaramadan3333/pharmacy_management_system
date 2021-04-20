package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.util.TimeZone;
/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name="bills")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_id")
	private long billId;

	@Column(name="bill_state")
	private String billState;

	@Column(name="bill_type")
	private String billType;

	@Column(name="customer_address")
	private String customerAddress;



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="delivery_fee")
	private float deliveryFee;

	@Column(name="phone_number")
	private int phoneNumber;

    @Column(name="customer_id",insertable =false, updatable=false)
    private int customerId;
    @Column(name="employee_id",insertable =false, updatable=false)
    private int employeeId;
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	//@CreationTimestamp()/////
	//@JsonFormat(timezone = "GMT+02:00")
	//@DateTimeFormat(pattern="hh:mm:ss" )
    //@Temporal(TemporalType.TIME)
	//@Column(name = "time")//, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date time;

	@Column(name="total_price")
	private float totalPrice;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")//,columnDefinition = "customerId")
	
	@JsonIgnore
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	//@JsonIgnore
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="delivery_man_id")
	//@JsonIgnore
	private Employee employee2;

	//bi-directional many-to-one association to BillsProduct
	@OneToMany(mappedBy="bill")
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private List<BillsProduct> billsProducts;

	public Bill() {
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billState=" + billState + ", billType=" + billType + ", customerAddress="
				+ customerAddress + ", deliveryFee=" + deliveryFee + ", phoneNumber=" + phoneNumber + ", time=" + time
				+ ", totalPrice=" + totalPrice + ", customer=" + customer + ", employee1=" + employee1 + ", employee2="
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
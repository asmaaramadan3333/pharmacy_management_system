package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the supply database table.
 * 
 */
@Entity
@Table(name="supply")
@NamedQuery(name="Supply.findAll", query="SELECT s FROM Supply s")
public class Supply implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SupplyPK id;

	@Column(name="availability_feedback")
	private String availabilityFeedback;

	@Temporal(TemporalType.DATE)
	@Column(name="delivered_date")
	private Date deliveredDate;

	@Column(name="delivery_feedback")
	private int deliveryFeedback;

	@Temporal(TemporalType.DATE)
	@Column(name="requested_date")
	private Date requestedDate;

	@Column(name="status")
	private String status;

	@Column(name="total_price")
	private float totalPrice;

	@Column(name="employee_id")
	private int employeeId;
	//bi-directional many-to-one association to PharmaCo
	/*
	 * @ManyToOne(fetch=FetchType.LAZY,cascade=
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * })
	 * 
	 * @JoinColumn(name="company_id",insertable=false,updatable=false)
	 * 
	 * @JsonIgnore private PharmaCo pharmaCo;
	 */
		/*
		 * //bi-directional many-to-one association to Employee
		 * 
		 * @ManyToOne(fetch=FetchType.LAZY,cascade=
		 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
		 * })
		 * 
		 * @JoinColumn(name="employee_id", insertable=false,updatable=false)
		 * 
		 * @JsonIgnore private Employee employee;
		 */

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@JoinColumns({
		@JoinColumn(name = "company_id"),@JoinColumn(name = "supply_id") })
		@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		private List<SupplyProduct> supplyProducts;

		
	public Supply() {
	}

	public SupplyPK getId() {
		return this.id;
	}

	public void setId(SupplyPK id) {
		this.id = id;
	}
	
     /////// new added function
	
	/*public void setIdParam (int companyId,int productCode,int supplyBillId ) {
		this.id.setCompanyId(companyId);
		this.id.setSupplyBillId(supplyBillId);
		this.id.setProductCode(productCode);
	}*/
	
	public String getAvailabilityFeedback() {
		return this.availabilityFeedback;
	}

	public void setAvailabilityFeedback(String availabilityFeedback) {
		this.availabilityFeedback = availabilityFeedback;
	}

	public Date getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public int getDeliveryFeedback() {
		return this.deliveryFeedback;
	}

	public void setDeliveryFeedback(int deliveryFeedback) {
		this.deliveryFeedback = deliveryFeedback;
	}

	public Date getRequestedDate() {
		return this.requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	


	public List<SupplyProduct> getSupplyProducts() {
		return this.supplyProducts;
	}

	public void setSupplyProducts(List<SupplyProduct> supplyProducts) {
		this.supplyProducts = supplyProducts;
	}



	
}
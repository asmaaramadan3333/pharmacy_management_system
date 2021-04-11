package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


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

	@Column(name="bonus_quantity")
	private int bonusQuantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="delivered_quantity")
	private int deliveredQuantity;

	@Temporal(TemporalType.DATE)
	@Column(name="expire_date")
	private Date expireDate;

	@Column(name="pharmacist_price")
	private float pharmacistPrice;

	@Column(name="product_price")
	private float productPrice;
	
	@Column(name="remained_quantity")
	private int remainedQuantity;

	@Column(name="total_price")
	private float totalPrice;

	//bi-directional many-to-one association to PharmaCo
		@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})

		@JoinColumn(name="company_id",insertable=false,updatable=false)
	    @JsonIgnore
		private PharmaCo pharmaCo;

		//bi-directional many-to-one association to Employee
		@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="employee_id", insertable=false,updatable=false)
		@JsonIgnore
		private Employee employee;

		//bi-directional many-to-one association to Product
		@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="product_code", insertable=false,updatable=false)
		@JsonIgnore
		private Product product;
	public Supply() {
	}

	public SupplyPK getId() {
		return this.id;
	}

	public void setId(SupplyPK id) {
		this.id = id;
	}
	
     /////// new added function
	
	public void setIdParam (int companyId,int productCode,int supplyBillId ) {
		this.id.setCompanyId(companyId);
		this.id.setSupplyBillId(supplyBillId);
		this.id.setProductCode(productCode);
	}
	
	
	public int getBonusQuantity() {
		return this.bonusQuantity;
	}

	public void setBonusQuantity(int bonusQuantity) {
		this.bonusQuantity = bonusQuantity;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDeliveredQuantity() {
		return this.deliveredQuantity;
	}

	public void setDeliveredQuantity(int deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public float getPharmacistPrice() {
		return this.pharmacistPrice;
	}

	public void setPharmacistPrice(float pharmacistPrice) {
		this.pharmacistPrice = pharmacistPrice;
	}

	public float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getRemainedQuantity() {
		return this.remainedQuantity;
	}

	public void setRemainedQuantity(int remainedQuantity) {
		this.remainedQuantity = remainedQuantity;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PharmaCo getPharmaCo() {
		return this.pharmaCo;
	}

	public void setPharmaCo(PharmaCo pharmaCo) {
		this.pharmaCo = pharmaCo;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
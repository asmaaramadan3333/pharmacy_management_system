package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the supply_products database table.
 * 
 */
@Entity
@Table(name = "supply_products")
@NamedQuery(name = "SupplyProduct.findAll", query = "SELECT s FROM SupplyProduct s")
public class SupplyProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SupplyProductPK id;

	@Column(name = "bonus_quantity")
	private float bonusQuantity;

	@Column(name = "delivered_quantity")
	private int deliveredQuantity;

	@Column(name = "expired_date")
	private float expiredDate;

	@Column(name = "pharmacist_price")
	private float pharmacistPrice;

	@Column(name = "product_price")
	private float productPrice;

	@Column(name = "remained_quantity")
	private float remainedQuantity;

	/*
	 * //bi-directional many-to-one association to PharmaCo
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="company_id" , insertable=false, updatable=false) private
	 * PharmaCo pharmaCo;
	 * 
	 * 
	 * //bi-directional many-to-one association to Product
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="product_code" , insertable=false,updatable=false) private
	 * Product product;
	 */
	// bi-directional many-to-one association to Supply
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "company_id", referencedColumnName = "company_id",
	 * insertable = false, updatable = false),
	 * 
	 * @JoinColumn(name = "supply_id", referencedColumnName = "supply_bill_id",
	 * insertable = false, updatable = false) }) private Supply supply;
	 */

	public SupplyProduct() {
	}

	public SupplyProductPK getId() {
		return this.id;
	}

	public void setId(SupplyProductPK id) {
		this.id = id;
	}

	public float getBonusQuantity() {
		return this.bonusQuantity;
	}

	public void setBonusQuantity(float bonusQuantity) {
		this.bonusQuantity = bonusQuantity;
	}

	public int getDeliveredQuantity() {
		return this.deliveredQuantity;
	}

	public void setDeliveredQuantity(int deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public float getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(float expiredDate) {
		this.expiredDate = expiredDate;
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

	public float getRemainedQuantity() {
		return this.remainedQuantity;
	}

	public void setRemainedQuantity(float remainedQuantity) {
		this.remainedQuantity = remainedQuantity;
	}




}
package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the prescripts_products database table.
 * 
 */
@Entity
@Table(name = "prescripts_products")
@NamedQuery(name = "PrescriptsProduct.findAll", query = "SELECT p FROM PrescriptsProduct p")
public class PrescriptsProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrescriptsProductPK id;

	private String status;

	private String type;

	// bi-directional many-to-one association to CustomersPrescript

	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "prescript_id", insertable = false, updatable = false)
	private CustomersPrescript customersPrescript;

	/*
	 * //bi-directional many-to-one association to Product
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="product_code" , insertable=false,updatable=false) private
	 * Product product;
	 */

	public PrescriptsProduct() {
	}

	public PrescriptsProductPK getId() {
		return this.id;
	}

	public void setId(PrescriptsProductPK id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
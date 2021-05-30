package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the company_payments database table.
 * 
 */
@Entity
@Table(name="company_payments")
@NamedQuery(name="CompanyPayment.findAll", query="SELECT c FROM CompanyPayment c")
public class CompanyPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="payment")
	private float payment;

	@Temporal(TemporalType.DATE)
	private Date timing;
	/*
	 * //bi-directional many-to-one association to PharmaCo
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="company_id") private PharmaCo pharmaCo;
	 */

	public CompanyPayment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getPayment() {
		return this.payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}



	public Date getTiming() {
		return this.timing;
	}

	public void setTiming(Date timing) {
		this.timing = timing;
	}



}
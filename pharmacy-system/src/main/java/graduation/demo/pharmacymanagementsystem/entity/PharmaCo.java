package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pharma_co database table.
 * 
 */
@Entity
@Table(name="pharma_co")
@NamedQuery(name="PharmaCo.findAll", query="SELECT p FROM PharmaCo p")
public class PharmaCo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;

	@Column(name="email")
	private String email;

	
	@Temporal(TemporalType.DATE)
	@Column(name="payment_end_date")
	private Date paymentEndDate;

	@Column(name="payment_grace_period")
	private int paymentGracePeriod;

	@Column(name="payment_interval")
	private String paymentInterval;

	@Column(name="payment_method")
	private String paymentMethod;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_start_date")
	private Date paymentStartDate;

	//bi-directional many-to-one association to CompanyPayment
	@OneToMany(mappedBy="pharmaCo")
	private List<CompanyPayment> companyPayments;

	//bi-directional many-to-one association to PharmaCoPhone
	@OneToMany(mappedBy="pharmaCo")
	private List<PharmaCoPhone> pharmaCoPhones;

	//bi-directional many-to-one association to Supply
	@OneToMany(mappedBy="pharmaCo")
	private List<Supply> supplies;

	public PharmaCo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPaymentEndDate() {
		return this.paymentEndDate;
	}

	public void setPaymentEndDate(Date paymentEndDate) {
		this.paymentEndDate = paymentEndDate;
	}

	public int getPaymentGracePeriod() {
		return this.paymentGracePeriod;
	}

	public void setPaymentGracePeriod(int paymentGracePeriod) {
		this.paymentGracePeriod = paymentGracePeriod;
	}

	public String getPaymentInterval() {
		return this.paymentInterval;
	}

	public void setPaymentInterval(String paymentInterval) {
		this.paymentInterval = paymentInterval;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentStartDate() {
		return this.paymentStartDate;
	}

	public void setPaymentStartDate(Date paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}

	public List<CompanyPayment> getCompanyPayments() {
		return this.companyPayments;
	}

	public void setCompanyPayments(List<CompanyPayment> companyPayments) {
		this.companyPayments = companyPayments;
	}

	/*public CompanyPayment addCompanyPayment(CompanyPayment companyPayment) {
		getCompanyPayments().add(companyPayment);
		companyPayment.setPharmaCo(this);

		return companyPayment;
	}*/

	/*public CompanyPayment removeCompanyPayment(CompanyPayment companyPayment) {
		getCompanyPayments().remove(companyPayment);
		companyPayment.setPharmaCo(null);

		return companyPayment;
	}*/

	public List<PharmaCoPhone> getPharmaCoPhones() {
		return this.pharmaCoPhones;
	}

	public void setPharmaCoPhones(List<PharmaCoPhone> pharmaCoPhones) {
		this.pharmaCoPhones = pharmaCoPhones;
	}

	/*public PharmaCoPhone addPharmaCoPhone(PharmaCoPhone pharmaCoPhone) {
		getPharmaCoPhones().add(pharmaCoPhone);
		pharmaCoPhone.setPharmaCo(this);

		return pharmaCoPhone;
	}

	public PharmaCoPhone removePharmaCoPhone(PharmaCoPhone pharmaCoPhone) {
		getPharmaCoPhones().remove(pharmaCoPhone);
		pharmaCoPhone.setPharmaCo(null);

		return pharmaCoPhone;
	}*/

	public List<Supply> getSupplies() {
		return this.supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	/*public Supply addSupply(Supply supply) {
		getSupplies().add(supply);
		supply.setPharmaCo(this);

		return supply;
	}

	public Supply removeSupply(Supply supply) {
		getSupplies().remove(supply);
		supply.setPharmaCo(null);

		return supply;
	}*/

}
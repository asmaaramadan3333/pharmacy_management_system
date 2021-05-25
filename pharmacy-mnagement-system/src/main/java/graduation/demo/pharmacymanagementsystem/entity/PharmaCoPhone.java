package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pharma_co_phones database table.
 * 
 */
@Entity
@Table(name="pharma_co_phones")
@NamedQuery(name="PharmaCoPhone.findAll", query="SELECT p FROM PharmaCoPhone p")
public class PharmaCoPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PharmaCoPhonePK id;

	//bi-directional many-to-one association to PharmaCo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id" ,insertable=false,updatable=false)
	@JsonIgnore
	private PharmaCo pharmaCo;

	public PharmaCoPhone() {
	}

	public PharmaCoPhonePK getId() {
		return this.id;
	}

	public void setId(PharmaCoPhonePK id) {
		this.id = id;
	}

	public PharmaCo getPharmaCo() {
		return this.pharmaCo;
	}

	public void setPharmaCo(PharmaCo pharmaCo) {
		this.pharmaCo = pharmaCo;
	}

}
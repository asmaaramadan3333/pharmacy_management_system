package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the internal_expenses database table.
 * 
 */
@Entity
@Table(name="internal_expenses")
@NamedQuery(name="InternalExpens.findAll", query="SELECT i FROM InternalExpens i")
public class InternalExpens implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date timing;

	private String type;

	public InternalExpens() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getTiming() {
		return this.timing;
	}

	public void setTiming(Date timing) {
		this.timing = timing;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
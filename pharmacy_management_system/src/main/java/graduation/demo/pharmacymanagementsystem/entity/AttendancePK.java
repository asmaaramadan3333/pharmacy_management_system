package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the attendance database table.
 * 
 */
@Embeddable
public class AttendancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private java.util.Date day;

	@Column(name="employee_id", insertable=false, updatable=false)
	private int employeeId;

	public AttendancePK() {
	}
	public java.util.Date getDay() {
		return this.day;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AttendancePK)) {
			return false;
		}
		AttendancePK castOther = (AttendancePK)other;
		return 
			this.day.equals(castOther.day)
			&& (this.employeeId == castOther.employeeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.day.hashCode();
		hash = hash * prime + this.employeeId;
		
		return hash;
	}
}
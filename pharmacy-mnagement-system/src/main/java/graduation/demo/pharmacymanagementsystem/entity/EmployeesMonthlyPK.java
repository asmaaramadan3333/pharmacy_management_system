package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the employees_monthly database table.
 * 
 */
@Embeddable
public class EmployeesMonthlyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String month;

	@Column(name="employee_id", insertable=false, updatable=false)
	private int employeeId;

	public EmployeesMonthlyPK() {
	}
	public String getMonth() {
		return this.month;
	}
	public void setMonth(String month) {
		this.month = month;
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
		if (!(other instanceof EmployeesMonthlyPK)) {
			return false;
		}
		EmployeesMonthlyPK castOther = (EmployeesMonthlyPK)other;
		return 
			this.month.equals(castOther.month)
			&& (this.employeeId == castOther.employeeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.month.hashCode();
		hash = hash * prime + this.employeeId;
		
		return hash;
	}
}
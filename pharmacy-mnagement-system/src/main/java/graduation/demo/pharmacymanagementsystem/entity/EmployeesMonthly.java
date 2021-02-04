package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employees_monthly database table.
 * 
 */
@Entity
@Table(name="employees_monthly")
@NamedQuery(name="EmployeesMonthly.findAll", query="SELECT e FROM EmployeesMonthly e")
public class EmployeesMonthly implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeesMonthlyPK id;

	@Column(name="monthly_holidays")
	private int monthlyHolidays;

	@Column(name="monthly_hours")
	private int monthlyHours;

	@Column(name="monthly_lates")
	private int monthlyLates;

	@Column(name="monthly_permissions")
	private int monthlyPermissions;

	@Column(name="receivable_salary")
	private String receivableSalary;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id", insertable=false,updatable=false)
	private Employee employee;

	public EmployeesMonthly() {
	}

	public EmployeesMonthlyPK getId() {
		return this.id;
	}

	public void setId(EmployeesMonthlyPK id) {
		this.id = id;
	}

	public int getMonthlyHolidays() {
		return this.monthlyHolidays;
	}

	public void setMonthlyHolidays(int monthlyHolidays) {
		this.monthlyHolidays = monthlyHolidays;
	}

	public int getMonthlyHours() {
		return this.monthlyHours;
	}

	public void setMonthlyHours(int monthlyHours) {
		this.monthlyHours = monthlyHours;
	}

	public int getMonthlyLates() {
		return this.monthlyLates;
	}

	public void setMonthlyLates(int monthlyLates) {
		this.monthlyLates = monthlyLates;
	}

	public int getMonthlyPermissions() {
		return this.monthlyPermissions;
	}

	public void setMonthlyPermissions(int monthlyPermissions) {
		this.monthlyPermissions = monthlyPermissions;
	}

	public String getReceivableSalary() {
		return this.receivableSalary;
	}

	public void setReceivableSalary(String receivableSalary) {
		this.receivableSalary = receivableSalary;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
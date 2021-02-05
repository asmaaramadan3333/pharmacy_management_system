package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@Table(name="attendance")
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AttendancePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="arrival_time")
	private Date arrivalTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="departure_time")
	private Date departureTime;

	private int holiday;

	private int late;

	private String permission;

	//bi-directional many-to-one association to Employee

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id", insertable=false,updatable=false)

	private Employee employee;

	public Attendance() {
	}

	public AttendancePK getId() {
		return this.id;
	}

	public void setId(AttendancePK id) {
		this.id = id;
	}

	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public int getHoliday() {
		return this.holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public int getLate() {
		return this.late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
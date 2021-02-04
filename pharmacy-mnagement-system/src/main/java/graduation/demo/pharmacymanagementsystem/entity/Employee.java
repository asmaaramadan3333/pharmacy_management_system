package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String email;

	private String holidays;

	@Column(name="job_type")
	private String jobType;

	private String name;

	private String password;

	@Column(name="payment_method")
	private String paymentMethod;

	private int phone;

	private float salary;

	private String shift;

	private String status;

	private String username;

	@Column(name="working_days")
	private int workingDays;

	@Column(name="working_hours")
	private int workingHours;

	//bi-directional many-to-one association to Attendance
	//@OneToMany(mappedBy="employee")
	//private List<Attendance> attendances;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="employee1")
	private List<Bill> bills1;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="employee2")
	private List<Bill> bills2;

	//bi-directional many-to-one association to EmployeesMonthly
	@OneToMany(mappedBy="employee")
	private List<EmployeesMonthly> employeesMonthlies;

	//bi-directional many-to-many association to Customer
	@ManyToMany
	@JoinTable(
		name="serve"
		, joinColumns={
			@JoinColumn(name="employee_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="customer_id")
			}
		)
	private List<Customer> customers;

	//bi-directional many-to-one association to Supply
	@OneToMany(mappedBy="employee")
	private List<Supply> supplies;

	public Employee() {
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

	public String getHolidays() {
		return this.holidays;
	}

	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getShift() {
		return this.shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWorkingDays() {
		return this.workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public int getWorkingHours() {
		return this.workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	/*
	 * public List<Attendance> getAttendances() { return this.attendances; }
	 * 
	 * public void setAttendances(List<Attendance> attendances) { this.attendances =
	 * attendances; }
	 * 
	 * public Attendance addAttendance(Attendance attendance) {
	 * getAttendances().add(attendance); attendance.setEmployee(this);
	 * 
	 * return attendance; }
	 * 
	 * public Attendance removeAttendance(Attendance attendance) {
	 * getAttendances().remove(attendance); attendance.setEmployee(null);
	 * 
	 * return attendance; }
	 */

	public List<Bill> getBills1() {
		return this.bills1;
	}

	public void setBills1(List<Bill> bills1) {
		this.bills1 = bills1;
	}

	public Bill addBills1(Bill bills1) {
		getBills1().add(bills1);
		bills1.setEmployee1(this);

		return bills1;
	}

	public Bill removeBills1(Bill bills1) {
		getBills1().remove(bills1);
		bills1.setEmployee1(null);

		return bills1;
	}

	public List<Bill> getBills2() {
		return this.bills2;
	}

	public void setBills2(List<Bill> bills2) {
		this.bills2 = bills2;
	}

	public Bill addBills2(Bill bills2) {
		getBills2().add(bills2);
		bills2.setEmployee2(this);

		return bills2;
	}

	public Bill removeBills2(Bill bills2) {
		getBills2().remove(bills2);
		bills2.setEmployee2(null);

		return bills2;
	}

	public List<EmployeesMonthly> getEmployeesMonthlies() {
		return this.employeesMonthlies;
	}

	public void setEmployeesMonthlies(List<EmployeesMonthly> employeesMonthlies) {
		this.employeesMonthlies = employeesMonthlies;
	}

	public EmployeesMonthly addEmployeesMonthly(EmployeesMonthly employeesMonthly) {
		getEmployeesMonthlies().add(employeesMonthly);
		employeesMonthly.setEmployee(this);

		return employeesMonthly;
	}

	public EmployeesMonthly removeEmployeesMonthly(EmployeesMonthly employeesMonthly) {
		getEmployeesMonthlies().remove(employeesMonthly);
		employeesMonthly.setEmployee(null);

		return employeesMonthly;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Supply> getSupplies() {
		return this.supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public Supply addSupply(Supply supply) {
		getSupplies().add(supply);
		supply.setEmployee(this);

		return supply;
	}

	public Supply removeSupply(Supply supply) {
		getSupplies().remove(supply);
		supply.setEmployee(null);

		return supply;
	}

}
package graduation.demo.pharmacymanagementsystem.dto;

import java.util.Date;

public class CustomerDTO {

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String gender;

	private String email;

	private float credit;

	private String phoneNumber;

	private String address;

	
	public CustomerDTO() {

	}

	public CustomerDTO(String firstName, String lastName, Date dateOfBirth, String gender, String email, float credit,
			String phoneNumber, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.credit = credit;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", email=" + email + ", credit=" + credit + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}

	
	
}

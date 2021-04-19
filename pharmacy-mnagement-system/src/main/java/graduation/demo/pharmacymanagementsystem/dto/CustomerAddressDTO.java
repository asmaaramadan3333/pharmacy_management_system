package graduation.demo.pharmacymanagementsystem.dto;

public class CustomerAddressDTO {
	private int theCustomerId;
	private String theCustomerAddressOld;
	private String theCustomerAddressNew;
	public  CustomerAddressDTO() {
	}
	public CustomerAddressDTO(int theCustomerId, String theCustomerAddressOld, String theCustomerAddressNew) {
	
		this.theCustomerId = theCustomerId;
		this.theCustomerAddressOld = theCustomerAddressOld;
		this.theCustomerAddressNew = theCustomerAddressNew;
	}
	public int getTheCustomerId() {
		return theCustomerId;
	}
	public void setTheCustomerId(int theCustomerId) {
		this.theCustomerId = theCustomerId;
	}
	public String getTheCustomerAddressOld() {
		return theCustomerAddressOld;
	}
	public void setTheCustomerAddressOld(String theCustomerAddressOld) {
		this.theCustomerAddressOld = theCustomerAddressOld;
	}
	public String getTheCustomerAddressNew() {
		return theCustomerAddressNew;
	}
	public void setTheCustomerAddressNew(String theCustomerAddressNew) {
		this.theCustomerAddressNew = theCustomerAddressNew;
	}
	@Override
	public String toString() {
		return "CustomerAddressDTO [theCustomerId=" + theCustomerId + ", theCustomerAddressOld=" + theCustomerAddressOld
				+ ", theCustomerAddressNew=" + theCustomerAddressNew + "]";
	}
	
}

package graduation.demo.pharmacymanagementsystem.dto;

public class CustomersPhoneDTO {
	private int theCustomerId;
	private int theCustomerPhoneold;
	private int theCustomerPhonenew;
	public CustomersPhoneDTO() {
	}
	public CustomersPhoneDTO(int theCustomerId, int theCustomerPhoneold, int theCustomerPhonenew) {
		
		this.theCustomerId = theCustomerId;
		this.theCustomerPhoneold = theCustomerPhoneold;
		this.theCustomerPhonenew = theCustomerPhonenew;
	}
	public int getTheCustomerId() {
		return theCustomerId;
	}
	public void setTheCustomerId(int theCustomerId) {
		this.theCustomerId = theCustomerId;
	}
	public int getTheCustomerPhoneold() {
		return theCustomerPhoneold;
	}
	public void setTheCustomerPhoneold(int theCustomerPhoneold) {
		this.theCustomerPhoneold = theCustomerPhoneold;
	}
	public int getTheCustomerPhonenew() {
		return theCustomerPhonenew;
	}
	public void setTheCustomerPhonenew(int theCustomerPhonenew) {
		this.theCustomerPhonenew = theCustomerPhonenew;
	}
	@Override
	public String toString() {
		return "CustomersPhoneDTO [theCustomerId=" + theCustomerId + ", theCustomerPhoneold=" + theCustomerPhoneold
				+ ", theCustomerPhonenew=" + theCustomerPhonenew + "]";
	}
	
}

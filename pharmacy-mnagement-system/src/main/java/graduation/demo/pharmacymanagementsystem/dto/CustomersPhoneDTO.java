package graduation.demo.pharmacymanagementsystem.dto;

public class CustomersPhoneDTO {
	private int theCustomerId;
	private String theCustomerPhoneold;
	private String theCustomerPhonenew;
	public CustomersPhoneDTO() {
	}
	public CustomersPhoneDTO(int theCustomerId, String theCustomerPhoneold, String theCustomerPhonenew) {
		
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
	public String getTheCustomerPhoneold() {
		return theCustomerPhoneold;
	}
	public void setTheCustomerPhoneold(String theCustomerPhoneold) {
		this.theCustomerPhoneold = theCustomerPhoneold;
	}
	public String getTheCustomerPhonenew() {
		return theCustomerPhonenew;
	}
	public void setTheCustomerPhonenew(String theCustomerPhonenew) {
		this.theCustomerPhonenew = theCustomerPhonenew;
	}
	@Override
	public String toString() {
		return "CustomersPhoneDTO [theCustomerId=" + theCustomerId + ", theCustomerPhoneold=" + theCustomerPhoneold
				+ ", theCustomerPhonenew=" + theCustomerPhonenew + "]";
	}
	
}

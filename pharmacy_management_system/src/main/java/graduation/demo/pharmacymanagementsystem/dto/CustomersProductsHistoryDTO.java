package graduation.demo.pharmacymanagementsystem.dto;

public class CustomersProductsHistoryDTO {

	private int customerId;
	
	private int code;
	
	public CustomersProductsHistoryDTO() {
	}

	public CustomersProductsHistoryDTO(int customerId, int code) {
		this.customerId = customerId;
		this.code = code;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CustomersProductsHistoryDTO [customerId=" + customerId + ", code=" + code + "]";
	}
 

	
}

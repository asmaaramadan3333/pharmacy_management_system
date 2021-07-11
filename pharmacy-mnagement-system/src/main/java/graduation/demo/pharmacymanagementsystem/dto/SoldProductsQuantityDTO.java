package graduation.demo.pharmacymanagementsystem.dto;

public class SoldProductsQuantityDTO {

    private String productName;
	
	private int quantity;

	
	
	public SoldProductsQuantityDTO() {
		
	}
	
	public SoldProductsQuantityDTO(String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}




	@Override
	public String toString() {
		return "SoldProductsQuantityDTO [productName=" + productName + ", quantity=" + quantity + "]";
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}

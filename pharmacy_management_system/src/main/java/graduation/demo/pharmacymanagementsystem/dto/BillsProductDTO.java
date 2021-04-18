package graduation.demo.pharmacymanagementsystem.dto;


public class BillsProductDTO {

	private long billId;

	private int quantity;
	
	private float totalPrice;

	private float unitPrice;
	
	private String product_name;

	public BillsProductDTO() {
		
	}
	
	
    
	public int getQuantity() {
		return quantity;
	}

	public long getBillId() {
		return billId;
	}



	public void setBillId(long billId) {
		this.billId = billId;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return product_name;
	}

	public void setName(String name) {
		this.product_name = name;
	}



	public BillsProductDTO(long billId, int quantity, float totalPrice, float unitPrice, String name) {
		this.billId = billId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.unitPrice = unitPrice;
		this.product_name = name;
	}



	@Override
	public String toString() {
		return "BillsProductDTO [billId=" + billId + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", unitPrice=" + unitPrice + ", product_name=" + product_name + "]";
	}

	
	
	
	
}

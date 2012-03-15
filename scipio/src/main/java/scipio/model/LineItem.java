package scipio.model;

import java.math.BigDecimal;

public class LineItem {
	private int qty;
	private BigDecimal unitPrice;
	private String inventoryId;
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public BigDecimal getAmount() {
		return unitPrice.multiply(BigDecimal.valueOf(qty));
	}

	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
}

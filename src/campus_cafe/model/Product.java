/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */
package campus_cafe.model;

import java.math.BigDecimal;

public abstract class Product {
	private String id;
	private String name; 
	private BigDecimal basePrice;
	private int quantity;
	
	public Product(String id, String name, BigDecimal basePrice) {
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
	}
	public String getId() { 
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getDisplayName() {
	    return name;
	}
	public BigDecimal getBasePrice() {
		return this.basePrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public abstract BigDecimal price();
	
}


/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */
package campus_cafe.model;

import java.math.BigDecimal;

public class Beverage extends Product {
	private Size size;
	
	public Beverage(String id, String name, BigDecimal basePrice) {
		super(id, name, basePrice);
		this.size = Size.MEDIUM; //sensible size (should prompt user)
	}
	
	 public Size getSize() {
	        return size;
	    }

	    public void setSize(Size size) {
	        if (size == null) {
	            this.size = Size.MEDIUM;
	        } else {
	            this.size = size;
	        }
	    }

	@Override
	public BigDecimal price() {
        BigDecimal multiplier;
        switch (size) {
            case SMALL: multiplier = BigDecimal.valueOf(0.9); break;
            case LARGE: multiplier = BigDecimal.valueOf(1.5); break;
            default: multiplier = BigDecimal.ONE;
        }
        return getBasePrice().multiply(multiplier).multiply(BigDecimal.valueOf(getQuantity()));
    }

    @Override
    public String getDisplayName() {
        return String.format("%s (%s)", getName(), size);
    }
}
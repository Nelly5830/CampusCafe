/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */
package campus_cafe.model;

import java.math.BigDecimal;

public class Food extends Product {
    private boolean extraCheese;

    public Food(String id, String name, BigDecimal basePrice) {
        super(id, name, basePrice);
        this.extraCheese = false; // default
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public BigDecimal price() {
        BigDecimal total = getBasePrice();
        if (extraCheese) {
            total = total.add(BigDecimal.valueOf(1.00)); // surcharge
        }
        return total.multiply(BigDecimal.valueOf(getQuantity()));
    }
    public String getDisplayName() {
        return hasExtraCheese() ? getName() + " + cheese" : getName();
    }
}

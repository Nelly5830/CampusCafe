/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */
package campus_cafe.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<LineItem> lineItems = new ArrayList<>();
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.065);

    public void addItem(Product p, int qty) {
        lineItems.add(new LineItem(p, qty));
    }

    public List<LineItem> getLineItems() {
        return new ArrayList<>(lineItems);
    }

    public BigDecimal subtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (LineItem li : lineItems) {
            subtotal = subtotal.add(li.lineTotal());
        }
        return subtotal;
    }

    public BigDecimal tax() {
        return subtotal().multiply(TAX_RATE);
    }

    public BigDecimal total() {
        return subtotal().add(tax());
    }
}

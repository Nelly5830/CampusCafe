package campus_cafe.model;

import java.math.BigDecimal;

public final class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
        this.product = copyProduct(product, quantity);
    }

    private Product copyProduct(Product p, int qty) {
        if (p instanceof Beverage) {
            Beverage b = (Beverage) p;
            Beverage clone = new Beverage(b.getId(), b.getName(), b.getBasePrice());
            clone.setSize(b.getSize());
            clone.setQuantity(qty);
            return clone;
        } else if (p instanceof Food) {
            Food f = (Food) p;
            Food clone = new Food(f.getId(), f.getName(), f.getBasePrice());
            clone.setExtraCheese(f.hasExtraCheese());
            clone.setQuantity(qty);
            return clone;
        }
        throw new IllegalArgumentException("Unknown product type");
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal lineTotal() {
        return product.price();
    }
}

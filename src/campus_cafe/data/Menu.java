/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */

package campus_cafe.data;

import campus_cafe.model.*;
import java.math.BigDecimal;
import java.util.*;

public class Menu {
    private List<Product> items = new ArrayList<>();

    public Menu() {
        buildMenu();
    }

    private void buildMenu() {
    	
        Beverage beverage = new Beverage("B01", "Coffee", BigDecimal.valueOf(2.99));
        items.add(beverage);

        beverage = new Beverage("B02", "Tea", BigDecimal.valueOf(2.99));
        items.add(beverage);
        
        beverage = new Beverage("B03", "Energy Drink", BigDecimal.valueOf(3.99));
        items.add(beverage);

        Food food = new Food("F01", "Bacon Egg and Cheese Sandwich", BigDecimal.valueOf(4.99));
        items.add(food);
        
        food= new Food("F02", "Sausage Egg and Cheese Sandwich", BigDecimal.valueOf(4.99));
        items.add(food);

        food = new Food("F03", "Salad", BigDecimal.valueOf(3.99));
        items.add(food);
    }

    public void displayMenu() {
        for (Product item : items) {
            System.out.println(String.format("%s -- %s: $%.2f",
                    item.getId(), item.getName(), item.getBasePrice()));
        }
    }

    public Product getMenuItem(String id) {
        for (Product item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }
}
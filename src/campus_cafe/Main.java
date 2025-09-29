/* 
 * Troy Nelson
 * Object Oriented Programming
 * September 28, 2025
 */
package campus_cafe;

import campus_cafe.data.*;
import campus_cafe.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
        String menuOption = "";
        boolean firstTime = true; 

        do {
            if (firstTime) {
                System.out.println("Welcome to the campus cafe!");
                System.out.println();
                firstTime = false;
            } else {
                System.out.println("Anything else?");
                System.out.println();
            }
            System.out.println("Menu:");
            menu.displayMenu();
            System.out.print("Enter item code (or type 'end' to finish): ");
            System.out.println();
            menuOption = sc.nextLine();

            if (menuOption.equalsIgnoreCase("end")) {
                break;
            }

            Product item = menu.getMenuItem(menuOption);
            if (item == null) {
                System.out.println("Your Selection is invalid");
                System.out.println();
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity;
            try {
                quantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
                System.out.println();
                continue;
            }
            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                System.out.println();
                continue;
            }

            // customize if Beverage
            if (item instanceof Beverage) {
                System.out.print("Choose size (SMALL, MEDIUM, LARGE): ");
                String sizeStr = sc.nextLine().toUpperCase();
                try {
                    ((Beverage) item).setSize(Size.valueOf(sizeStr));
                } catch (IllegalArgumentException e) {
                    ((Beverage) item).setSize(Size.MEDIUM);
                }
            }

            // customize if Food
            if (item instanceof Food) {
                System.out.print("Extra cheese? (yes/no): ");
                String ans = sc.nextLine().toLowerCase();
                ((Food) item).setExtraCheese(ans.startsWith("y"));
            }

            order.addItem(item, quantity);
            System.out.println("Added to order: " + item.getDisplayName() + " x" + quantity);
            System.out.println();
            
        } while (true);

        System.out.println("\n--- RECEIPT ---");
        for (LineItem li : order.getLineItems()) {
            System.out.printf("%s x%d ... $%.2f\n",
                    li.getProduct().getDisplayName(),
                    li.getQuantity(),
                    li.lineTotal());
        }
        System.out.printf("Subtotal: $%.2f\n", order.subtotal());
        System.out.printf("Tax: $%.2f\n", order.tax());
        System.out.printf("Total: $%.2f\n", order.total());
    }
}

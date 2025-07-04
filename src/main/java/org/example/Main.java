package org.example;

import Model.*;
import Services.CheckoutService;
import Services.ShippingService;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product cheese = ProductFactory.createProduct("Cheese", 100, 10, true, true, 200, System.currentTimeMillis() + 86400000); // Expires in 1 day
        Product biscuits = ProductFactory.createProduct("Biscuits", 150, 5, true, true, 700, System.currentTimeMillis() + 86400000);
        Product tv = ProductFactory.createProduct("TV", 500, 3, false, true, 5000, 0);
        Product scratchCard = ProductFactory.createProduct("Scratch Card", 50, 10, false, false, 0, 0);

        // Create new customer
        Customer customer = new Customer("Hend Ahmed", 1000);

        // Create cart and add items
        ShoppingCart cart = new ShoppingCart();
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error adding to cart: " + e.getMessage());
            return;
        }

        // Checkout
        CheckoutService checkoutService = new CheckoutService(new ShippingService(), new WeightedShippingStrategy());
        try {
            checkoutService.checkout(customer, cart);
        } catch (IllegalStateException e) {
            System.err.println("Checkout error: " + e.getMessage());
        }
    }
}
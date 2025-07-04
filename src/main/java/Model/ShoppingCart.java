package Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (product != null && ((Expirable) product).isExpired()) {
            throw new IllegalStateException("Cannot add expired product: " + product.getName());
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock for " + product.getName() + ": " + product.getQuantity() + " available");
        }


        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity); // Update the quantity of the existing item in cart
                product.setQuantity(product.getQuantity() - quantity); // Update the product quantity in stock
                return;
            }
        }
        items.add(new CartItem(product, quantity)); // Add new item to the cart
        product.setQuantity(product.getQuantity() - quantity);
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    // check if the cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }
}

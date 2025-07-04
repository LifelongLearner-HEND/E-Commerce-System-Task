package Model;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<CartItem> items;
    private final double shippingCost;

    public Order(Customer customer, List<CartItem> items, double shippingCost) {
        this.customer = customer;
        this.items = items;
        this.shippingCost = shippingCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public double getTotal() {
        return getSubtotal() + shippingCost;
    }
}

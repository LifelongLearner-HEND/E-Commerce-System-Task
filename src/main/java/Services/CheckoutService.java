package Services;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private final ShippingService shippingService;
    private final ShippingStrategy shippingStrategy;

    public CheckoutService(ShippingService shippingService, ShippingStrategy shippingStrategy) {
        this.shippingService = shippingService;
        this.shippingStrategy = shippingStrategy;
    }

    public Order checkout(Customer customer, ShoppingCart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        // Check for expired or out of stock items
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product != null && ((Expirable) product).isExpired()) {
                throw new IllegalStateException("Product expired: " + product.getName());
            }
            if (product.getQuantity() < item.getQuantity()) {
                throw new IllegalStateException("Product out of stock: " + product.getName());
            }
        }

        // Collect shippable items
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() != null && (item.getProduct()).isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add(item.getProduct());
                }
            }
        }

        // Calculate shipping cost
        double shippingCost = shippingStrategy.calculateShippingCost(shippableItems);

        // Create new order
        Order order = new Order(customer, cart.getItems(), shippingCost);

        // Check customer balance
        double total = order.getTotal();
        customer.updateBalance(total);

        // Process shipment
        shippingService.processShipment(shippableItems);

        // Print summary
        new OrderSummary(order).printSummary();

        return order;
    }
}

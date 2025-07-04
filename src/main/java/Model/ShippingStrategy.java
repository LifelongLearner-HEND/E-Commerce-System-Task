package Model;

import java.util.List;

// Applying Strategy design pattern for shipping cost calculation
public interface ShippingStrategy {
    double calculateShippingCost(List<Shippable> shippableItems);
}

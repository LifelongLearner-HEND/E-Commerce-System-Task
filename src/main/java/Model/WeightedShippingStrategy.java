package Model;

import java.util.List;

public class WeightedShippingStrategy implements ShippingStrategy{
    private static final double COST_PER_KG = 10.0; // Assuming a cost of 10 dollars per kg

    @Override
    public double calculateShippingCost(List<Shippable> shippableItems) {
        double totalWeightKg = shippableItems.stream()
                .mapToDouble(Shippable::getWeight)
                .sum() / 1000.0; // Converting grams to kg
        return Math.ceil(totalWeightKg) * COST_PER_KG;
    }
}

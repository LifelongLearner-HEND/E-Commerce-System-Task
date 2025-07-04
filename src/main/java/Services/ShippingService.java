package Services;
import Model.Shippable;

import java.util.List;

public class ShippingService {
    public void processShipment(List<Shippable> shippableItems) {
        if (shippableItems.isEmpty()) {
            return;
        }
        System.out.println("|| Shipment Notice ||");
        double totalWeight = 0;
        for (Shippable item : shippableItems) {
            System.out.printf("%s %.0fg%n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight / 1000.0);
    }
}

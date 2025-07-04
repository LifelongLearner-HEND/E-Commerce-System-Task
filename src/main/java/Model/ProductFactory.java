package Model;

// Applying Factory design pattern to create Product instances
public class ProductFactory {
    public static Product createProduct(String name, double price, int quantity, boolean isExpirable, boolean isShippable, double weight, long expiryDate) {
        return new Product(name, price, quantity, isExpirable, isShippable, weight, expiryDate);
    }
}

package Model;

public class Product implements IProduct, Expirable, Shippable{
    private final String name;
    private final double price;
    private int quantity;
    private final boolean isExpirable;
    private final boolean isShippable;
    private final double weight; // assumed to be in grams
    private final long expiryDate; // assumed to be in melli seconds

    public Product(String name, double price, int quantity, boolean isExpirable, boolean isShippable, double weight, long expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isShippable = isShippable;
        this.weight = isShippable ? weight : 0;
        this.expiryDate = isExpirable ? expiryDate : Long.MAX_VALUE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than zero!");
        }
        this.quantity = quantity;
    }

    @Override
    public boolean isExpired() {
        return isExpirable && System.currentTimeMillis() > expiryDate;
    }

    @Override
    public double getWeight() {
        return isShippable ? weight : 0;
    }

    public boolean isShippable() {
        return isShippable;
    }

}

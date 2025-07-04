package Model;

public class OrderSummary {
    private final Order order;

    public OrderSummary(Order order) {
        this.order = order;
    }

    public void printSummary() {
        System.out.println("|| Checkout Receipt ||");
        for (CartItem item : order.getItems()) {
            System.out.printf("%dx %s %.2f%n", item.getQuantity(), item.getProduct().getName(), item.getSubtotal());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.2f%n", order.getSubtotal());
        System.out.printf("Shipping %.2f%n", order.getShippingCost());
        System.out.printf("Amount %.2f%n", order.getTotal());
        System.out.printf("Customer balance after payment: %.2f%n", order.getCustomer().getBalance());
    }
}

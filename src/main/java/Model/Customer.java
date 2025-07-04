package Model;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance: " + balance);
        }
        balance -= amount;
    }
}

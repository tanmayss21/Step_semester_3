package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 5: Payment Processing for a Shopping System
 * 
 * Implements an order checkout system with payment method abstractions,
 * empty order validations, and status updates on transaction results.
 */
public class PaymentProcessingSystem {

    public static void main(String[] args) {
        Shopper custX = new Shopper("C-X", "Customer X");
        Shopper custY = new Shopper("C-Y", "Customer Y");
        Shopper custZ = new Shopper("C-Z", "Customer Z");

        Product prodA = new Product("P1", "Product A", 10.0);
        Product prodB = new Product("P2", "Product B", 20.0);
        Product prodC = new Product("P3", "Product C", 15.0);

        PaymentMethod creditCard = new CreditCardPayment(true);
        PaymentMethod payPalFail = new PayPalPayment(false);

        Order orderX = new Order("Order X", custX);
        orderX.addItem(prodA, 2);
        orderX.addItem(prodB, 1);
        orderX.processPayment(creditCard);

        Order orderY = new Order("Order Y", custY);
        orderY.processPayment(creditCard);

        Order orderZ = new Order("Order Z", custZ);
        orderZ.addItem(prodC, 1);
        orderZ.processPayment(payPalFail);
    }
}

class Shopper {
    private String id;
    private String name;

    public Shopper(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

interface PaymentMethod {
    String getMethodName();
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    private boolean shouldSucceed;

    public CreditCardPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }
}

class PayPalPayment implements PaymentMethod {
    private boolean shouldSucceed;

    public PayPalPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }
}

class Order {
    private String orderId;
    private Shopper customer;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    public Order(String orderId, Shopper customer) {
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Order created for " + customer.getName() + ".");
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public void processPayment(PaymentMethod method) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated via " + method.getMethodName() + " for " + orderId + ".");
        boolean success = method.processPayment(calculateTotal());
        if (success) {
            this.status = "Paid";
            System.out.println("Payment for " + orderId + " successful. Order status: " + status + ".");
        } else {
            System.out.println("Payment for " + orderId + " failed. Order status: " + status + ".");
        }
    }
}

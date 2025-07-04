# E-Commerce System for Fawry

## Overview
This Java-based e-commerce system is crafted for the Fawry Fullstack Internship task. It delivers a robust, modular platform for managing products, handling shopping carts, and processing checkouts, built with OOP principles, SOLID design, and design patterns.

## Features
- **Product Definition**: Products have name, price, and quantity. Supports expirable items (e.g., Cheese, Biscuits) and non-expirable ones (e.g., TV, Mobile).
- **Shipping**: Manages shippable items (e.g., Cheese, TV) with weight-based costs and non-shippable items (e.g., Mobile Scratch Cards).
- **Shopping Cart**: Enables adding products with quantity checks (stock and expiration validation).
- **Checkout**: Processes orders, computes subtotal and shipping fees, verifies customer balance, and prints a detailed receipt. Integrates with `ShippingService` for shippable items.
- **Error Handling**: Addresses edge cases like empty carts, insufficient balance, out-of-stock, or expired products.

## Project Structure
```
com.ecommerce
├── model
│   ├── product
│   │   ├── Product.java
│   │   ├── Expirable.java
│   │   ├── Shippable.java
│   │   ├── ConcreteProduct.java
│   │   └── ProductFactory.java
│   ├── cart
│   │   ├── ShoppingCart.java
│   │   └── CartItem.java
│   ├── customer
│   │   └── Customer.java
│   └── order
│       ├── Order.java
│       └── OrderSummary.java
├── service
│   ├── ShippingService.java
│   ├── CheckoutService.java
│   └── ShippingStrategy.java
└── Main.java
```

## Design Highlights
- **OOP & SOLID**: Classes follow single-responsibility and interface-based abstractions.
- **Design Patterns**: Factory for product creation, Strategy for shipping cost calculation, Facade for checkout.
- **Error Handling**: Validates stock, expiration, and balance.
- **Extensibility**: Supports adding new product types or shipping strategies.


## Assumptions
- **Currency**: Generic unit (e.g., USD).
- **Shipping Cost**: $10 per kg, rounded up.
- **Expiration**: Based on epoch milliseconds.
- **Storage**: In-memory, no database.
- **Thread Safety**: Single-threaded.

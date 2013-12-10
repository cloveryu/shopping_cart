package com.thoughtworks.shopping.cart.domain;

public class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }
}

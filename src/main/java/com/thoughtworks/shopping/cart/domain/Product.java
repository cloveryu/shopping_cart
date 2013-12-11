package com.thoughtworks.shopping.cart.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }
}

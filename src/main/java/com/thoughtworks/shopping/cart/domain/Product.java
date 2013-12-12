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

    @Override
    public int hashCode() {
        return productName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product that = (Product) obj;
        return that.productName.equals(productName);
    }
}

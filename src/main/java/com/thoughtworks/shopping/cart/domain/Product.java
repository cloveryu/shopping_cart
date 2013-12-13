package com.thoughtworks.shopping.cart.domain;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Product implements Serializable {

    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name) + Objects.hashCode(price);
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
        return Objects.equal(name, that.name) && Objects.equal(price, that.price);
    }

    public int getPrice() {
        return price;
    }
}

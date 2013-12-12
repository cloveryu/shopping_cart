package com.thoughtworks.shopping.cart.domain;

import com.thoughtworks.shopping.cart.exception.ShoppingCartOverflowException;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product, Integer> products = new HashMap<Product, Integer>();

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Product product : products.keySet()) {
            totalAmount += products.get(product);
        }
        return totalAmount;
    }

    public void addProduct(Product product) throws ShoppingCartOverflowException {
        int prevAmount = 0;
        if (products.containsKey(product)) {
            prevAmount = products.get(product);
        }
        products.put(product, prevAmount + 1);
    }

    public Product findByName(String name) {
        for (Product product : products.keySet()) {
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public Product deleteByName(String name) {
        for (Product product : products.keySet()) {
            if (name.equals(product.getName())) {
                products.remove(product);
                return product;
            }
        }
        return null;
    }

    public int getAmountByName(String name) {
        for (Product product : products.keySet()) {
            if (name.equals(product.getName())) {
                return products.get(product);
            }
        }
        return 0;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products.keySet()) {
            totalPrice += products.get(product) * product.getPrice();
        }
        return totalPrice;
    }

}

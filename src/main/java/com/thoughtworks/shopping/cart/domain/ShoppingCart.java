package com.thoughtworks.shopping.cart.domain;

import com.thoughtworks.shopping.cart.exception.ShoppingCartOverflowException;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static final int MAX_NUMBER_OF_PRODUCT = 10;
    private int amount = 0;
    List<Product> products = new ArrayList<Product>(MAX_NUMBER_OF_PRODUCT);

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) throws ShoppingCartOverflowException {
        if (amount >= MAX_NUMBER_OF_PRODUCT) {
            throw new ShoppingCartOverflowException("it's too much.");
        }
        products.add(product);
        amount++;
    }

    public Product findByName(String name) {
        for (int i = 0; i < amount; i++) {
            if (name.equals(products.get(i).getName())) {
                return products.get(i);
            }
        }
        return null;
    }

    public Product deleteByName(String name) {
        for (int i = 0; i < amount; i++) {
            if (products.get(i).getName().equals(name)){
                Product result = products.get(i);
                products.remove(i);
                return result;
            }
        }
        return null;
    }
}

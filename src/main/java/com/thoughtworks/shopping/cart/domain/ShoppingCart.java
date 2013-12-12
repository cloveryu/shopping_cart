package com.thoughtworks.shopping.cart.domain;

import com.thoughtworks.shopping.cart.exception.ShoppingCartOverflowException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private int amount = 0;
    Map<Product, Integer> products = new HashMap<Product, Integer>();

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) throws ShoppingCartOverflowException {
        amount++;
        products.put(product, amount);
    }

    public Product findByName(String name) {
        Iterator iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Product product = (Product)key;
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public Product deleteByName(String name) {
        Iterator iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Product product = (Product)key;
            if (name.equals(product.getName())) {
                iterator.remove();
                return product;
            }
        }
        return null;
    }

    public Integer getNum(String name) {
        Iterator iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Product product = (Product)key;
            if (name.equals(product.getName())) {
                Integer result = (Integer)value;
                return result;
            }
        }
        return null;
    }
}

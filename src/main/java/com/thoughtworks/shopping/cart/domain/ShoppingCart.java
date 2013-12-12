package com.thoughtworks.shopping.cart.domain;

import com.thoughtworks.shopping.cart.exception.ShoppingCartOverflowException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private int amount = 0;
    Map<String, Integer> products = new HashMap<String, Integer>();

    public int getAmount() {
        return amount;
    }

    public void addProduct(String name) throws ShoppingCartOverflowException {
        amount++;
        products.put(name, amount);
    }

    public String findByName(String name) {
        Iterator iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            if (name.equals(key.toString())) {
                return key.toString();
            }
        }
        return null;
    }

    public String deleteByName(String name) {
        Iterator iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            if (name.equals(key.toString())) {
                String result = key.toString();
                iterator.remove();
                return result;
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
            if (name.equals(key.toString())) {
                Integer result = (Integer)value;
                return result;
            }
        }
        return null;
    }
}

package com.thoughtworks.shopping.cart.domain;

import java.util.ArrayList;

public class ShoppingCart {
    private int amount = 0;
//    private Product[] products = new Product[10];
    ArrayList<Product> products = new ArrayList<Product>();

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) {
//        String exception = null;
//        try{
            products.add(product);
            amount++;
//        } catch (ArrayIndexOutOfBoundsException e) {
//            exception = "out of range!";
//        }
//        return exception;
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
        for (int i = 0; i < amount; i++){
            if (products.get(i).getName().equals(name)){
                Product result = products.get(i);
                products.remove(i);
                return result;
            }
        }
        return null;
    }
}

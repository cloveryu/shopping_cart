package com.thoughtworks.shopping.cart.domain;

public class ShoppingCart {
    private int amount = 0;
    private  Product[] products = new Product[10];

    public int getAmount() {
        return amount;
    }

    public String addProduct(Product product) {
        String exception = null;
        try{
            products[amount] = product;
            amount++;
        }catch (ArrayIndexOutOfBoundsException e){
            exception = "out of range!";
        }
        return exception;
    }

    public Product findByName(String name) {
        for (int i = 0; i < amount; i++){
            if (products[i].getName().equals(name)){
                return products[i];
            }
        }
        return null;
    }
}

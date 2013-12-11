package com.thoughtworks.shopping.cart.exception;

public class ShoppingCartOverflowException extends RuntimeException {

    public ShoppingCartOverflowException(String message) {
        super(message);
    }

}

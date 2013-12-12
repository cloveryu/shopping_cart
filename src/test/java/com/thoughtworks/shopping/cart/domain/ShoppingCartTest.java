package com.thoughtworks.shopping.cart.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void should_get_product_amount() {
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_product() {
        shoppingCart.addProduct("cake");
        assertThat(shoppingCart.getAmount(), is(1));
    }

    @Test
    public void should_find_product_by_name() {
        shoppingCart.addProduct("cake");
        assertThat(shoppingCart.findByName("cake"), is("cake"));
    }

    @Test
    public void should_not_find_Product_by_name() {
        assertThat(shoppingCart.findByName("book"), nullValue());
    }

//    @Test(expected = ShoppingCartOverflowException.class)
//    public void should_throw_shopping_cart_overflow_exception() {
//        Product product = new Product("cup");
//        for (int i = 0; i < 10; i++) {
//            shoppingCart.addProduct(product);
//        }
//        shoppingCart.addProduct(product);
//    }

    @Test
    public void should_delete_product_by_name() {
        shoppingCart.addProduct("pen");
        assertThat(shoppingCart.deleteByName("pen"), is("pen"));
    }

    @Test
    public void should_not_delete_product_by_name() {
        assertThat(shoppingCart.deleteByName("cup"), nullValue());
    }

    @Test
    public void should_get_the_amount_by_find_name() {
        for (int i = 0;i < 5; i++) {
            shoppingCart.addProduct("pen");
        }
        assertThat(shoppingCart.getNum("pen"), is(5));
    }
}

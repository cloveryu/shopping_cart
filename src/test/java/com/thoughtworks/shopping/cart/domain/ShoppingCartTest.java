package com.thoughtworks.shopping.cart.domain;

import com.thoughtworks.shopping.cart.exception.ShoppingCartOverflowException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

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
        shoppingCart.addProduct(new Product("cake"));
        assertThat(shoppingCart.getAmount(), is(1));
    }

    @Test
    public void should_find_product_by_name() {
        Product product = new Product("cake");
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.findByName("cake"), is(product));
    }

    @Test
    public void should_not_find_Product_by_name() {
        assertThat(shoppingCart.findByName("book"), nullValue());
    }

    @Test(expected = ShoppingCartOverflowException.class)
    public void should_throw_shopping_cart_overflow_exception() {
        Product product = new Product("cup");
        for (int i = 0; i < 10; i++) {
            shoppingCart.addProduct(product);
        }
        shoppingCart.addProduct(product);
    }

    @Test
    public void should_delete_product_by_name() {
        Product product = new Product("pen");
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.deleteByName("pen"), is(product));
    }

    @Test
    public void should_not_delete_product_by_name() {
        assertThat(shoppingCart.deleteByName("cup"), nullValue());
    }
}

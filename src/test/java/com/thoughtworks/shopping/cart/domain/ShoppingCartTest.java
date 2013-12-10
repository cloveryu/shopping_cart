package com.thoughtworks.shopping.cart.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void should_get_product_amount() throws Exception {
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_product() throws Exception {
        shoppingCart.addProduct(new Product("cake"));
        assertThat(shoppingCart.getAmount(),is(1));
    }

    @Test
    public void should_find_product_by_name() throws Exception {
        Product product = new Product("cake");
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.findByName("cake"),is(product));
    }

    @Test
    public void should_not_find_Product_by_name() throws Exception {
        assertThat(shoppingCart.findByName("book"), nullValue());
    }

    @Test
    public void should_num_out_of_range() throws Exception {
        Product product = new Product("cup");
        for (int i = 0; i <= 10; i++){
            shoppingCart.addProduct(product);
        }
        String warning = "out of range!";
        assertThat(shoppingCart.addProduct(product),is(warning));

    }
}

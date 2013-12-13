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
        assertThat(shoppingCart.getTotalAmount(), is(0));
    }

    @Test
    public void should_add_product() {
        Product product = new Product("name", 2);
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.getTotalAmount(), is(1));
    }

    @Test
    public void should_find_product_by_name() {
        Product product = new Product("cake", 2);
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.findByName("cake"), is(product));
    }

    @Test
    public void should_not_find_product_by_name() {
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
        Product product = new Product("pen", 2);
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.deleteByName("pen"), is(product));
    }

    @Test
    public void should_not_delete_product_by_name() {
        assertThat(shoppingCart.deleteByName("cup"), nullValue());
    }

    @Test
    public void should_get_the_amount_by_name() {
        Product pen = new Product("pen", 2);
        Product cup = new Product("cup", 2);
        shoppingCart.addProduct(pen);
        shoppingCart.addProduct(pen);
        shoppingCart.addProduct(cup);
        shoppingCart.addProduct(cup);
        shoppingCart.addProduct(cup);
        assertThat(shoppingCart.getAmountByName("pen"), is(2));
        assertThat(shoppingCart.getAmountByName("cup"), is(3));
        assertThat(shoppingCart.getAmountByName("no"), is(0));
    }

    @Test
    public void should_get_the_total_price_of_products() {
        Product apple = new Product("apple", 2);
        Product orange = new Product("orange", 3);
        shoppingCart.addProduct(apple);
        shoppingCart.addProduct(apple);
        shoppingCart.addProduct(orange);
        assertThat(shoppingCart.getTotalPrice(), is(7));
    }
}

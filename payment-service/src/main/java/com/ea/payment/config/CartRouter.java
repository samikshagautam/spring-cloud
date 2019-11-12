package com.ea.payment.config;

public class CartRouter implements Router {
    @Override
    public String url(String path) {
        return "http://order/carts/" + path;
    }
}

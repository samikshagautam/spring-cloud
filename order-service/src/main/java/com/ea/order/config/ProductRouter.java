package com.ea.order.config;

public class ProductRouter implements Router {
    @Override
    public String url(String path) {
        return "http://product/" + path;
    }
}

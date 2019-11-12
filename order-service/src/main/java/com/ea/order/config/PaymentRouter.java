package com.ea.order.config;

public class PaymentRouter implements Router {
    @Override
    public String url(String path) {
        return "http://payment/payments/" + path;
    }
}

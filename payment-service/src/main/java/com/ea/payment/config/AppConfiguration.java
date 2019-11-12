package com.ea.payment.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @LoadBalanced
    @Bean
    // communicate between services
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CartRouter paymentRouter() {
        return new CartRouter();
    }
}

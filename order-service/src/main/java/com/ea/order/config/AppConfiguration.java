package com.ea.order.config;

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
    public PaymentRouter paymentRouter() {
        return new PaymentRouter();
    }

    @Bean
    public ProductRouter productRouter() {
        return new ProductRouter();
    }
}

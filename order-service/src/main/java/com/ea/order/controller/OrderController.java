package com.ea.order.controller;

import com.ea.order.entity.Order;
import com.ea.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;

    @PostMapping("/{transId}")
    public Order placeAnOrder(@PathVariable("transId") Long transId) throws Exception {
        return service.placeAnOrder(transId);
    }
}

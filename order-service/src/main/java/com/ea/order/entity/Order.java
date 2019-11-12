package com.ea.order.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private List<OrderItem> orderItems;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "shipping_cost")
    private Double shippingCost;

    @Column(name = "order_total")
    private Double orderTotal;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "status")
    private OrderStatus status;



}

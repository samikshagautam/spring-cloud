package com.ea.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "price")
    private Double price;

    @Column(name = "order_id")
    private Long orderId;


}

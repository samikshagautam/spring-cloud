package com.ea.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "price")
    private Double price;


}

package com.ea.order.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String desc;
}

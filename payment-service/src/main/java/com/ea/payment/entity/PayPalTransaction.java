package com.ea.payment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "paypal_transactions")
public class PayPalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "charge_token")
    private String chargeToken;

    @Column(name = "transaction_token")
    private String transactionToken;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "email")
    private String email;

    @Column(name = "shipping_id")
    private Long shippingId;


}

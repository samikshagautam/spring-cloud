package com.ea.payment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "accound_id")
    private Long accountId;

    @Column(name = "card_name")
    private String name;

    @Column(name = "card_num")
    private String number;

    @Column(name = "exp_year")
    private int expYear;

    @Column(name = "exp_month")
    private int expMonth;

    @Column(name = "security_num")
    private int securityNum;

    @Column(name = "card_type")
    private String cardType;


}

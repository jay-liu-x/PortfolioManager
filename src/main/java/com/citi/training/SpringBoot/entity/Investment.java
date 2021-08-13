package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name="investments")
public class Investment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_id")
    private int investmentId;

    @Column(name = "investment_account_id")
    private Integer investmentAccountId;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "close_price")
    private Double closePrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date")
    private Date currentDate;

    public Investment() {};
}

package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name="investments")
public class Investment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "investmentId")
    private int investmentId;

    @Column(name = "symbol") private String symbol;
    @Column(name = "purchasePrice") private Double purchasePrice;
    @Column(name = "purchaseDate") private Date purchaseDate;
    @Column(name = "closePrice") private Double closePrice;
    @Column(name = "quantity") private Integer quantity;
    @Column(name = "date") private Date currentDate;
}

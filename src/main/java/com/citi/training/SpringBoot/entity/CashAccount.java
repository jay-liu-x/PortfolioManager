package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name="cashAccount")
public class CashAccount extends Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cashId;

    @Column(name = "name") private String name;
    @Column(name = "email") private String email;
    @Column(name = "date") private Date currentDate;
    @Column(name = "cashValue") private Double value;

    //TODO saving and chequing
    private Enum accountType;
}

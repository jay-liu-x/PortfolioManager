package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="cash_account")
public class CashAccount extends Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cash_id")
    private int cashId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private Date currentDate;

    @Column(name = "cash_value")
    private Double value;

    public CashAccount() {};
}

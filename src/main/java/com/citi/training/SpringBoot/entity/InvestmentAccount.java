package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="investmentAccount")
public class InvestmentAccount extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "investmentAccountId")
    private int investmentAccountId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "investmentValue")
    private Double investmentValue;

    @Column(name = "date")
    private Date currentDate;

    @JoinColumn(name = "investmentAccountId", referencedColumnName = "investmentAccountId")
    @OneToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Investment> investments = new ArrayList<>();

    public InvestmentAccount() {};
}

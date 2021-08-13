package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "email", referencedColumnName = "email")
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<CashAccount> cashAccounts = new ArrayList<>();

    @JoinColumn(name = "email", referencedColumnName = "email")
    @OneToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<InvestmentAccount> investmentAccounts = new ArrayList<>();
}

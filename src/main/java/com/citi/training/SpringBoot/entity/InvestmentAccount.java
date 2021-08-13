package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="investment_account")
public class InvestmentAccount extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_account_id")
    private int investmentAccountId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "investment_value")
    private Double investmentValue;

    @Column(name = "date")
    private Date currentDate;

    @JoinColumn(name = "investment_account_id", referencedColumnName = "investment_account_id")
    @OneToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Investment> investments = new ArrayList<>();

    public InvestmentAccount() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getInvestmentValue() {
        return investmentValue;
    }

    public void setInvestmentValue(Double investmentValue) {
        this.investmentValue = investmentValue;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }
}

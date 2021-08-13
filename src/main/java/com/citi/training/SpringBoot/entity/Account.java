package com.citi.training.SpringBoot.entity;

public abstract class Account {
    private Person accountOwner;
    private String company;
    private Double principal;

    public Person getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Person accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }
}

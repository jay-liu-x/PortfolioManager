package com.citi.training.SpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
    private Date date;

    public Investment() {};

    public Integer getInvestmentAccountId() {
        return investmentAccountId;
    }

    public void setInvestmentAccountId(Integer investmentAccountId) {
        this.investmentAccountId = investmentAccountId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double calculateGains() {
        return (this.closePrice - this.purchasePrice) * this.quantity;
    }
}

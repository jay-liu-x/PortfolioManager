package com.citi.training.SpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

//CREATE TABLE marketmover
//        (
//        marketmover_id int NOT NULL AUTO_INCREMENT,
//        index_name VARCHAR(50),
//        date DATE,
//        change_rate DOUBLE,
//        index_value DOUBLE,
//        PRIMARY KEY(marketmover_id)
//        );

@Entity
@Table(name = "marketmover")
public class MarketMover implements Serializable {
    public int getMarketMoverId() {
        return marketMoverId;
    }

    public void setMarketMoverId(int marketMoverId) {
        this.marketMoverId = marketMoverId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(Double changeRate) {
        this.changeRate = changeRate;
    }

    public Double getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(Double indexValue) {
        this.indexValue = indexValue;
    }

    @Id
    @Column(name = "marketmover_id")
    private int marketMoverId;

    @Column(name = "index_name")
    private String indexName;

    @Column(name = "date")
    private Date date;

    @Column(name = "change_rate")
    private Double changeRate;

    @Column(name = "index_value")
    private Double indexValue;
}

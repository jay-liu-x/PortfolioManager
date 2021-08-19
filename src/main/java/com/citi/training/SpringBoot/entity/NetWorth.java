package com.citi.training.SpringBoot.entity;

import java.sql.Date;

public class NetWorth implements Comparable<NetWorth>{
    private Date date;
    private Double networth;

    public NetWorth(Date date, Double networth) {
        this.date = date;
        this.networth = networth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getNetworth() {
        return networth;
    }

    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    @Override
    public int compareTo(NetWorth o) {
        return getDate().compareTo(o.getDate());
    }
}

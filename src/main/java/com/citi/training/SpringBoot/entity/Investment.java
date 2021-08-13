package com.citi.training.SpringBoot.entity;

import java.io.Serializable;


public class Investment implements Serializable{
    private String symbol;
    private Double purchasePrice;
    private Double closePrice;
    private int quantity;
}

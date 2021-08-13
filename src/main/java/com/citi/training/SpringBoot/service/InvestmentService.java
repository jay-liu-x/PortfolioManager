package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;

import java.util.Collection;

public interface InvestmentService {
    Collection<Investment> getAllInvestments();
}

package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public interface InvestmentService {
    Collection<Investment> getAllInvestments();

    Collection<Investment> getInvestmentsBySymbol(String symbol);

    Collection<Investment> getInvestmentsByInvestmentId(int id);

    void deleteInvestmentById(int id);

    List<Investment> getTopFiveGainers();

    List<Investment> getTopFiveLosers();

    Collection<Investment> getInvestmentsByDateAndAccount(Date date, int id);

    Collection<Investment> getInvestmentsByDate(Date date);

    public Double calculateIncome();

    public Double calculateSpending();

    public Double calculateOverall();
}

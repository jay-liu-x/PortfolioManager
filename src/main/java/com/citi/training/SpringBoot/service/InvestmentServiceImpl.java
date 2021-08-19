package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.sql.Date;


@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    private final java.util.Date lastDayOfSale = new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-18");
    private final java.util.Date firstDayOfPurchase = new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-12");

    public InvestmentServiceImpl() throws ParseException {
    }

    @Override
    public Collection<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public Collection<Investment> getInvestmentsBySymbol(String symbol) {
        return investmentRepository.findBySymbol(symbol);
    }

    @Override
    public Collection<Investment> getInvestmentsByInvestmentId(int id) {
        return investmentRepository.findByInvestmentId(id);
    }

    @Override
    public void deleteInvestmentById(int id) {
        Investment toBeDeleted =investmentRepository.findById(id).get();
        investmentRepository.delete(toBeDeleted);
    }

    @Override
    public List<Investment> getTopFiveGainers() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        investmentsWithoutDuplicates.sort((o1, o2) -> Double.compare(o2.calculateGains(), o1.calculateGains()));
        return investmentsWithoutDuplicates.subList(0, 5);
    }

    @Override
    public List<Investment> getTopFiveLosers() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        investmentsWithoutDuplicates.sort((o1, o2) -> Double.compare(o1.calculateGains(), o2.calculateGains()));
        return investmentsWithoutDuplicates.subList(0, 5);
    }

    /* Get the latest date of an investment for calculating gains. */
    private List<Investment> getInvestmentsWithoutDuplicates(List<Investment> investments) {
        List<Investment> investmentsWithoutDuplicates = new ArrayList<>();
        Investment prevInvestment = investments.get(0);
        for (Investment investment : investments) {
            if (!investment.getSymbol().equals(prevInvestment.getSymbol())) {
                investmentsWithoutDuplicates.add(prevInvestment);
            }
            prevInvestment = investment;
        }
        return investmentsWithoutDuplicates;
    }

    @Override
    public List<Investment> getInvestmentsByDateAndAccount(Date date, int id) {
        return investmentRepository.findByDateAndInvestmentAccountId(date, id);
    }

    @Override
    public List<Investment> getInvestmentsByDate(Date date) {
        return investmentRepository.findByDate(date);
    }

    /* Total income for the last 7 days. */
    @Override
    public Double calculateIncome() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        double income = 0.00;
        for (Investment investment : investmentsWithoutDuplicates) {
            if (investment.getDate().before(lastDayOfSale)) {
                income += investment.getClosePrice() * investment.getQuantity();
            }
        }

        return income;
    }

    /* Total spending for the last 7 days. */
    @Override
    public Double calculateSpending() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        double spending = 0.00;
        for (Investment investment : investmentsWithoutDuplicates) {
            if (investment.getPurchaseDate().after(firstDayOfPurchase)) {
                spending += investment.getPurchasePrice() * investment.getQuantity();
            }
        }

        return spending;
    }

    @Override
    public Double calculateOverall() {
        return this.calculateIncome() - this.calculateSpending();
    }
}

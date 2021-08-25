package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    public List<Investment> getAllGainers() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        List<Investment> gainers = new ArrayList<>();
        for (Investment investment : investmentsWithoutDuplicates) {
            if (investment.calculateGains() > 0) {
                gainers.add(investment);
            }
        }
        return gainers;
    }

    @Override
    public List<Investment> getAllLosers() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        List<Investment> losers = new ArrayList<>();
        for (Investment investment : investmentsWithoutDuplicates) {
            if (investment.calculateGains() < 0) {
                losers.add(investment);
            }
        }
        return losers;
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

    public static java.util.Date addDays(java.util.Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /* History of incomes for the last 7 days. */
    @Override
    public ArrayList<Double> calculateIncomes() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        ArrayList<Double> incomes = new ArrayList<>();
        double curIncome = 0.00;
        for (java.util.Date curDate = firstDayOfPurchase; curDate.before(addDays(lastDayOfSale, 1)); curDate = addDays(curDate, 1)) {
            for (Investment investment : investmentsWithoutDuplicates) {
                if (investment.getDate().equals((curDate))) {
                    curIncome += investment.getClosePrice() * investment.getQuantity();
                }
            }
            incomes.add(curIncome);
            curIncome = 0;
        }

        return incomes;
    }

    /* History of spendings for the last 7 days. */
    @Override
    public ArrayList<Double> calculateSpendings() {
        List<Investment> investments = investmentRepository.findAll();
        List<Investment> investmentsWithoutDuplicates = getInvestmentsWithoutDuplicates(investments);
        ArrayList<Double> spendings = new ArrayList<>();
        double curSpending = 0.00;
        for (java.util.Date curDate = firstDayOfPurchase; curDate.before(addDays(lastDayOfSale, 1)); curDate = addDays(curDate, 1)) {
            for (Investment investment : investmentsWithoutDuplicates) {
                if (investment.getPurchaseDate().equals((curDate))) {
                    curSpending += investment.getPurchasePrice() * investment.getQuantity();
                }
            }
            spendings.add(curSpending);
            curSpending = 0;
        }

        return spendings;
    }
}

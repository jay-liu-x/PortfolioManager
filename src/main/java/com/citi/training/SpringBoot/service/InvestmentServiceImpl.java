package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

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
}

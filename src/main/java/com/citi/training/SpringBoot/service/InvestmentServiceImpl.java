package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public Collection<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }
}

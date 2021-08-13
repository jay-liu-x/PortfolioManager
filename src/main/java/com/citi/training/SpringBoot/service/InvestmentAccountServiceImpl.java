package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.repo.InvestmentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InvestmentAccountServiceImpl implements InvestmentAccountService {

    @Autowired
    private InvestmentAccountRepository investmentAccountRepository;

    @Override
    public Collection<InvestmentAccount> getAllInvestmentAccounts() {
        return investmentAccountRepository.findAll();
    }
}

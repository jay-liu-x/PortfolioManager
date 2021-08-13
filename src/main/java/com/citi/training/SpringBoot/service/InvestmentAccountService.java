package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;

import java.util.Collection;

public interface InvestmentAccountService {
    Collection<InvestmentAccount> getAllInvestmentAccounts();
}

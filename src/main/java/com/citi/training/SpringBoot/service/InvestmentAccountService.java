package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;

import java.util.Collection;

public interface InvestmentAccountService {
    Collection<InvestmentAccount> getAllInvestmentAccounts();

    void deleteInvestmentAccountById(int id);

    void deleteInvestmentAccount(InvestmentAccount investmentAccount);

    InvestmentAccount addNewInvestmentAccount(InvestmentAccount investmentAccount);

    InvestmentAccount updateInvestmentAccount(InvestmentAccount investmentAccount);

    InvestmentAccount getInvestmentAccountById(int id);
}

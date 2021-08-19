package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.NetWorth;

import java.util.Collection;

public interface InvestmentAccountService {
    Collection<InvestmentAccount> getAllInvestmentAccounts();

    InvestmentAccount getInvestmentAccountById(int id);

    Collection<NetWorth> getNetWorthById(int id);

    Collection<NetWorth> getAllNetWorth();
}

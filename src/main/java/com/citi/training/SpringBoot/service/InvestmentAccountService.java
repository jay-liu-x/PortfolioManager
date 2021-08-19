package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.NetWorth;

import java.util.Collection;
import java.util.List;

public interface InvestmentAccountService {
    Collection<InvestmentAccount> getAllInvestmentAccounts();

    InvestmentAccount getInvestmentAccountById(int id);

    List<NetWorth> getNetWorthById(int id);

    List<NetWorth> getAllNetWorth();
}

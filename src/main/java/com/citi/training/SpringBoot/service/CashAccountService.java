package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.CashAccount;
import com.citi.training.SpringBoot.entity.NetWorth;

import java.util.Collection;
import java.util.List;

public interface CashAccountService {
    Collection<CashAccount> getAllCashAccounts();

    CashAccount getCashAccountById(int id);

    NetWorth getCashAccountNetWorthById(int id);

    List<NetWorth> getAllCashAccountNetWorth();
}

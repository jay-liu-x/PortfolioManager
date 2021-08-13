package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.CashAccount;

import java.util.Collection;

public interface CashAccountService {
    Collection<CashAccount> getAllCashAccounts();
}

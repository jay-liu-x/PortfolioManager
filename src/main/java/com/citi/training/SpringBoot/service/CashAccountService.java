package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.CashAccount;

import java.util.Collection;

public interface CashAccountService {
    Collection<CashAccount> getAllCashAccounts();

    CashAccount getCashAccountById(int id);

    CashAccount addNewCashAccount(CashAccount cashAccount);

    CashAccount updateCashAccount(CashAccount cashAccount);

    void deleteCashAccountById(int id);

    void deleteCashAccount(CashAccount cashAccount);
}

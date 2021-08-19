package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.CashAccount;
import com.citi.training.SpringBoot.entity.NetWorth;
import com.citi.training.SpringBoot.repo.CashAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CashAccountServiceImpl implements CashAccountService {

    @Autowired
    private CashAccountRepository cashAccountRepository;

    @Override
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountRepository.findAll();
    }

    @Override
    public CashAccount getCashAccountById(int id) {
        Optional<CashAccount> account =  cashAccountRepository.findById(id);
        if (account.isPresent()) {
            return account.get();
        }
        else return null;
    }

    @Override
    public NetWorth getCashAccountNetWorthById(int id) {
        Optional<CashAccount> account = cashAccountRepository.findById(id);
        if (account.isPresent()) {
            return new NetWorth(account.get().getCurrentDate(), account.get().getValue());
        }
        else return null;
    }

    @Override
    public List<NetWorth> getAllCashAccountNetWorth() {
        List<CashAccount> accounts = cashAccountRepository.findAll();
        List<NetWorth> netWorths = new ArrayList<>();
        for (CashAccount account : accounts) {
            netWorths.add(new NetWorth(account.getCurrentDate(), account.getValue()));
        }
        return netWorths;
    }
}

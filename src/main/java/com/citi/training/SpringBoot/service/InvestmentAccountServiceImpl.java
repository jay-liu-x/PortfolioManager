package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.repo.InvestmentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvestmentAccountServiceImpl implements InvestmentAccountService {

    @Autowired
    private InvestmentAccountRepository investmentAccountRepository;

    @Override
    public Collection<InvestmentAccount> getAllInvestmentAccounts() {
        return investmentAccountRepository.findAll();
    }

    @Override
    public InvestmentAccount getInvestmentAccountById(int id) {
        Optional<InvestmentAccount> account =  investmentAccountRepository.findById(id);
        if (account.isPresent()) {
            return account.get();
        }
        else return null;
    }

    @Override
    public InvestmentAccount addNewInvestmentAccount(InvestmentAccount investmentAccount) {
        return investmentAccountRepository.save(investmentAccount);
    }

    @Override
    public InvestmentAccount updateInvestmentAccount(InvestmentAccount investmentAccount) {
        return investmentAccountRepository.save(investmentAccount);
    }


    @Override
    public void deleteInvestmentAccountById(int id) {
        InvestmentAccount accountToBeDeleted = investmentAccountRepository.findById(id).get();
        deleteInvestmentAccount(accountToBeDeleted);
    }

    @Override
    public void deleteInvestmentAccount(InvestmentAccount investmentAccount) {
        investmentAccountRepository.delete(investmentAccount);
    }
}

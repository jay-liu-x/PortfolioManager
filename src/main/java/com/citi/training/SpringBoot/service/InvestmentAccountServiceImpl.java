package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.NetWorth;
import com.citi.training.SpringBoot.repo.InvestmentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvestmentAccountServiceImpl implements InvestmentAccountService {

    @Autowired
    private InvestmentAccountRepository investmentAccountRepository;
    @Autowired
    private InvestmentService investmentService;

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
    public List<NetWorth> getNetWorthById(int id) {
        List<NetWorth> netWorths = new ArrayList<>();
        for (int day = 12; day < 19; day++) {
            LocalDate date = LocalDate.of(2021,8,day);
            Collection<Investment> investments = investmentService.getInvestmentsByDateAndAccount(Date.valueOf(date), id);
            double netWorthValue = 0.0;
            for (Investment investment : investments) {
                netWorthValue += investment.getClosePrice();
            }
            netWorths.add(new NetWorth(Date.valueOf(date), netWorthValue));
        }
        return netWorths;
    }


    @Override
    public List<NetWorth> getAllNetWorth() {
        List<NetWorth> netWorths = new ArrayList<>();
        for (int day = 12; day < 19; day++) {
            LocalDate date = LocalDate.of(2021,8,day);
            Collection<Investment> investments = investmentService.getInvestmentsByDate(Date.valueOf(date));
            double netWorthValue = 0.0;
            for (Investment investment : investments) {
                netWorthValue += investment.getClosePrice();
            }
            netWorths.add(new NetWorth(Date.valueOf(date), netWorthValue));
        }
        return netWorths;
    }
}

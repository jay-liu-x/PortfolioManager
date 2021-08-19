package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.NetWorth;
import com.citi.training.SpringBoot.service.CashAccountService;
import com.citi.training.SpringBoot.service.InvestmentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/net_worth")
public class NetWorthController {
    @Autowired
    private InvestmentAccountService investmentAccountService;
    @Autowired
    private CashAccountService cashAccountService;

    @GetMapping
    public Collection<NetWorth> getAllNetWorth() {
        Collection<NetWorth> investmentNetWorths = getAllInvestmentNetWorth();
        Collection<NetWorth> cashNetWorths = getAllCashNetWorth();
        Collection<NetWorth> newNetWorth = new ArrayList<>();
        for (NetWorth netWorth : investmentNetWorths) {
            NetWorth netWorthNew = null;
            for (NetWorth netWorth2 : cashNetWorths) {
                netWorthNew = new NetWorth(netWorth.getDate(), netWorth.getNetworth()+netWorth2.getNetworth());
            }
            newNetWorth.add(netWorthNew);
        }
        return newNetWorth;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/total")
    public double getTotalNetWorth() {
        double networthValue = 0.0;
        Collection<NetWorth> netWorths = getAllNetWorth();
        for (NetWorth netWorth : netWorths) {
            networthValue += netWorth.getNetworth();
        }
        return networthValue;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment_accounts")
    public Collection<NetWorth> getAllInvestmentNetWorth() {
        return investmentAccountService.getAllNetWorth();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment_accounts/{id}")
    public Collection<NetWorth> getInvestmentNetWorthByAccount(@PathVariable("id") int id) {
        return investmentAccountService.getNetWorthById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment_accounts/total")
    public double getTotalInvestmentNetWorth() {
        List<NetWorth> netWorths = investmentAccountService.getAllNetWorth();
        Collections.sort(netWorths);
        Collections.reverse(netWorths);
        return netWorths.get(0).getNetworth();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cash_accounts/{id}")
    public NetWorth getCashNetWorthByAccount(@PathVariable("id") int id) {
        return cashAccountService.getCashAccountNetWorthById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cash_accounts")
    public List<NetWorth> getAllCashNetWorth() {
        return cashAccountService.getAllCashAccountNetWorth();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cash_accounts/total")
    public double getTotalCashNetWorth() {
        double totalNetWorth = 0.0;
        List<NetWorth> netWorths = cashAccountService.getAllCashAccountNetWorth();
        for (NetWorth netWorth : netWorths) {
            totalNetWorth += netWorth.getNetworth();
        }
        return totalNetWorth;
    }
}


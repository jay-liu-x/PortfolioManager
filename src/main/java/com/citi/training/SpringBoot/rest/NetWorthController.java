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

@RestController
@RequestMapping("/net_worth")
public class NetWorthController {
    @Autowired
    private InvestmentAccountService investmentAccountService;
    @Autowired
    private CashAccountService cashAccountService;

    @RequestMapping(method = RequestMethod.GET, value = "/investment_accounts")
    public Collection<NetWorth> getAllInvestmentNetWorth() {
        return investmentAccountService.getAllNetWorth();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investment_accounts/{id}")
    public Collection<NetWorth> getInvestmentNetWorthByAccount(@PathVariable("id") int id) {
        return investmentAccountService.getNetWorthById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/net_worth/cash_accounts/{id}")
    public Collection<NetWorth> getAllCashNetWorth(@PathVariable("id") int id) {
        //TODO: net worth api for cash value
        return new ArrayList<>();
    }
}


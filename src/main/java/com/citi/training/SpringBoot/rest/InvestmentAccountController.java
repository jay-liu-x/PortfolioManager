package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.service.InvestmentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/investmentAccounts")
public class InvestmentAccountController {
    @Autowired
    private InvestmentAccountService investmentAccountService;

    @GetMapping
    public Collection<InvestmentAccount> getAllInvestmentAccounts() {
        return investmentAccountService.getAllInvestmentAccounts();
    }
}

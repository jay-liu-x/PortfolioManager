package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.service.InvestmentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/investment_accounts")
public class InvestmentAccountController {
    @Autowired
    private InvestmentAccountService investmentAccountService;

    @GetMapping
    public Collection<InvestmentAccount> getAllInvestmentAccounts() {
        return investmentAccountService.getAllInvestmentAccounts();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public InvestmentAccount getInvestmentAccountById(@PathVariable("id") int id) {
        return investmentAccountService.getInvestmentAccountById(id);
    }
}

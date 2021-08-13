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

    @RequestMapping(method=RequestMethod.GET, value="/404/{id}")
    public ResponseEntity<InvestmentAccount> getByIdWith404(@PathVariable("id") int id) {
        InvestmentAccount account = investmentAccountService.getInvestmentAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteAccount(@PathVariable("id") int id) {
        investmentAccountService.deleteInvestmentAccountById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCd(@RequestBody InvestmentAccount investmentAccount) {
        investmentAccountService.deleteInvestmentAccount(investmentAccount);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addAccount(@RequestBody InvestmentAccount investmentAccount) {
        investmentAccountService.addNewInvestmentAccount(investmentAccount);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateAccount(@RequestBody InvestmentAccount investmentAccount) {
        investmentAccountService.updateInvestmentAccount(investmentAccount);
    }
}

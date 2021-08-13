package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.CashAccount;
import com.citi.training.SpringBoot.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cash_accounts")
public class CashAccountController {
    @Autowired
    private CashAccountService cashAccountService;

    @GetMapping
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountService.getAllCashAccounts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CashAccount getCashAccountById(@PathVariable("id") int id) {
        return cashAccountService.getCashAccountById(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/404/{id}")
    public ResponseEntity<CashAccount> getByIdWith404(@PathVariable("id") int id) {
        CashAccount account = cashAccountService.getCashAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteAccount(@PathVariable("id") int id) {
        cashAccountService.deleteCashAccountById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCd(@RequestBody CashAccount cashAccount) {
        cashAccountService.deleteCashAccount(cashAccount);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addAccount(@RequestBody CashAccount cashAccount) {
        cashAccountService.addNewCashAccount(cashAccount);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateAccount(@RequestBody CashAccount cashAccount) {
        cashAccountService.updateCashAccount(cashAccount);
    }
}

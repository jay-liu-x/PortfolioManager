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
}
